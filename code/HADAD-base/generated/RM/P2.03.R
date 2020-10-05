library(psych)
library(Matrix)
b_0<-as.matrix(read.table("syn5d.csv", format="csv", header=FALSE, sep=","))
RW1<-(trace(b_0))