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
      times_m <- double(4)
      times_f <- double(4)
      avg<-double(4)
      for (iter in 1:4) {
        tryCatch(
          expr = {
            start_m <- Sys.time()
            s1=sum(t(TNM))
            end_m <- Sys.time()
            times_m[iter] <- as.numeric(end_m-start_m, units="secs")
            
            start_f <- Sys.time()
            s2=sum(TNM)
            end_f <- Sys.time()
            times_f[iter] <- as.numeric(end_f-start_f, units="secs")
            avg[iter]<- (as.numeric(end_m-start_m, units="secs")/as.numeric(end_f-start_f, units="secs"))

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
      print("T")
      print(times_m)
      print("F")
      print(times_f)

      result[t]<-((sum(avg) - min(avg) - max(avg)) / 2)
      print("Results")
      print(result)
    }
    write.table(rbind(result), file = "../../../figures/HybridResults/Morpheus/resultP1-16.csv", row.names =FALSE, col.names = FALSE,sep = ",",append = TRUE)
}