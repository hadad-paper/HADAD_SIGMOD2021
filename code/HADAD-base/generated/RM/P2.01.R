library(psych)
library(Matrix)
b_0<-as.matrix(read.table("syn5c.csv", format="csv", header=FALSE, sep=","))
b_1<-as.matrix(read.table("syn5d.csv", format="csv", header=FALSE, sep=","))
RW3<-((trace(b_1))+(trace(b_0)))