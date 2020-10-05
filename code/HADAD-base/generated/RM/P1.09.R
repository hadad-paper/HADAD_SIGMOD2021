library(psych)
library(Matrix)
b_0<-as.matrix(read.table("syn5c.csv", format="csv", header=FALSE, sep=","))
RW1<-(det(b_0))