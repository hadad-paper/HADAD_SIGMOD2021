library(psych)
library(Matrix)
b_1<-as.matrix(read.table("syn5c.csv", format="csv", header=FALSE, sep=","))
RW0<-b_1