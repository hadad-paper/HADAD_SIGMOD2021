library(psych)
args <- commandArgs(trailingOnly = TRUE)
V9<-as.matrix(read.table(file=paste(args[1],"",sep=""), header = FALSE, sep = ","))
path <- paste('results.out', sep='')
times <- double(5)
for (iter in 1:5) {
      start <- Sys.time()
      res = det(V9)
      end <- Sys.time()
      print(res)
      times[iter] <- as.numeric(end-start, units="secs")
}
writeHeader <- if (!file.exists(path)) TRUE else FALSE
write.table(paste("P2.5RW:",args[1],sep=""), 
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