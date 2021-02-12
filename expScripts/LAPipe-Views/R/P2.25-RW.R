library(psych)
library(Matrix)

args <- commandArgs(trailingOnly = TRUE)

X<-as.matrix(readMM(file=paste(args[1],"",sep="")))
V4<-as.matrix(read.table(file=paste(args[2],"",sep=""), header = FALSE, sep = ","))
v1<-as.matrix(read.table(file=paste(args[3],"",sep=""), header = FALSE, sep = ",")
path <- paste('results.out', sep='')
times <- double(5)
for (iter in 1:5) {
      start <- Sys.time()
      res = (V4%*%v1)-(X%*%v1)
      end <- Sys.time()
      print(res[1,1])
      times[iter] <- as.numeric(end-start, units="secs")
}

writeHeader <- if (!file.exists(path)) TRUE else FALSE
write.table(paste("P2.14RW:",args[1],sep=""), 
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
