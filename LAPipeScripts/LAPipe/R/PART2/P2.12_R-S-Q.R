library(psych)
library(Matrix)
args <- commandArgs(trailingOnly = TRUE)
M<-as.matrix(readMM(file=paste(args[1],"",sep="")))
N<-as.matrix(read.table(file=paste(args[2],"",sep=""), header = FALSE, sep = ","))
path <- paste('results.out', sep='')
times <- double(5)
for (iter in 1:5) {
      start <- Sys.time()
      res = sum(rowSums(t(N)%*%t(M)))
      end <- Sys.time()
      print(res)
      times[iter] <- as.numeric(end-start, units="secs")
}

writeHeader <- if (!file.exists(path)) TRUE else FALSE
write.table(paste("P2.12Q:",args[1],sep=""), 
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