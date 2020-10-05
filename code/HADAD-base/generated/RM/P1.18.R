library(psych)
library(Matrix)
b_0<-as.matrix(read.table("syn3a.csv", format="csv", header=FALSE, sep=","))
RW1<-(sum(b_0))