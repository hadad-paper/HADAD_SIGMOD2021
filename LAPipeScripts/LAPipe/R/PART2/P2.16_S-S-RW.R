library(psych)
library(Matrix)
args <- commandArgs(trailingOnly = TRUE)
C<-as.matrix(read.table(file=paste(args[1],"",sep=""), header = FALSE, sep = ","))
D<-as.matrix(read.table(file=paste(args[2],"",sep=""), header = FALSE, sep = ","))
path <- paste('results.out', sep='')
times <- double(5)
for (iter in 1:5) {
      start <- Sys.time()
      res = tr(solve(D%*%C))+tr(D)
      end <- Sys.time()
      print(res)
      times[iter] <- as.numeric(end-start, units="secs")
}

writeHeader <- if (!file.exists(path)) TRUE else FALSE
write.table(paste("P2.16RW:",args[1],sep=""), 
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