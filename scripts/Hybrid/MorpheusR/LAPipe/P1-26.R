library('Matrix');
library('matrixStats');
library(data.table);
source('src/NormalMatrix.r');
range1 <- 1:5
range2<- 1:20
nr <- 1000000
ds <- 20

for ( f in range1){
result <-double(20)
   for (t in range2){
       print ("------")
       print (f)
       print("-------")
       print(t)
       dr = ds * f
       ns = nr * t
       S= matrix(rexp(ns, rate=.1), nrow=ns,ncol=ds)
       R= matrix(rexp(nr, rate=.1), nrow=nr,ncol=dr)
       Jset1= sample.int(nr, ns, replace = TRUE)
       K= sparseMatrix(i=c(1:ns),j=Jset1,x=1,dims=c(ns,nr));
       T = cbind(S,K%*%R)
       TNM = NormalMatrix(EntTable = list(S),
                   AttTables = list(R),
                   KFKDs = list(K),
                   Sparse = TRUE);
      TR = nrow(T)
      A= matrix(rexp(TR, rate=.1), nrow=ncol(T),ncol=TR)
      times_m <- double(4)
      times_f <- double(4)
      avg<-double(4)
      for (iter in 1:4) {
        tryCatch(
          expr = {
            start_m <- Sys.time()
            s1= T *(t(A) /(t(A)%*%(A%*%TNM)))
            end_m <- Sys.time()
            times_m[iter] <- as.numeric(end_m-start_m, units="secs")

          },
          error = function(e){ 
              message('Exception')
              print(e)

          },
          warning = function(w){
             
          },
          finally = {
                
          }
        )

      }
      print("F")
      print(times_m)
      result[t]<-times_m[3]
    }
    write.table(rbind(result), file = "../../../figures/HybridResults/Morpheus/resultP1-26.csv", row.names =FALSE, col.names = FALSE,sep = ",",append = TRUE)
}