library(psych)
library(Matrix)
b_0<-as.matrix(read.table("syn5c.csv", format="csv", header=FALSE, sep=","))
RW0<-(trace((solve(b_0))))