library(psych)
library(Matrix)
args <- commandArgs(trailingOnly = TRUE)

A<-as.matrix(readMM(file=paste(args[1],"",sep="")))
B<-as.matrix(readMM(file=paste(args[2],"",sep="")))
V1<-as.matrix(read.table(file=paste(args[3],"",sep=""), header = FALSE, sep = ","))
path <- paste('results.out', sep='')
times <- double(5)
for (iter in 1:5) {
      start <- Sys.time()
      res = A%*%V1 +B%*%V1
      end <- Sys.time()
      print(res[1,1])
      times[iter] <- as.numeric(end-start, units="secs")
}
writeHeader <- if (!file.exists(path)) TRUE else FALSE
write.table(paste("P1.4RW:",args[1],sep=""), 
            path, 
            append = TRUE, 
            row.names = FALSE,
            col.names = writeHeader,
            sep = ',')
writeHeader <- if (!file.exists(path)) TRUE else FALSE
write.table(times, 
            path, 
            append = TRUE, 
            row.names = FALSE,
            col.names = writeHeader,
            sep = ',')
writeHeader <- if (!file.exists(path)) TRUE else FALSE
write.table("\n", 
            path, 
            append = TRUE, 
            row.names = FALSE,
            col.names = writeHeader,
            sep = ',')