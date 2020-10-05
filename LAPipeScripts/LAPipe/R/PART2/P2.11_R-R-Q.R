library(psych)
library(Matrix)
args <- commandArgs(trailingOnly = TRUE)
A<-as.matrix(readMM(file=paste(args[1],"",sep="")))
B<-as.matrix(readMM(file=paste(args[2],"",sep="")))
path <- paste('results.out', sep='')
times <- double(5)
for (iter in 1:5) {
      start <- Sys.time()
      res = sum(A+B)
      end <- Sys.time()
      print(res)
      times[iter] <- as.numeric(end-start, units="secs")
}

writeHeader <- if (!file.exists(path)) TRUE else FALSE
write.table(paste("P2.11Q:",args[1],sep=""), 
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