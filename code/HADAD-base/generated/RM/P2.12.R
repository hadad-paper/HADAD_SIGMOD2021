library(psych)
library(Matrix)
b_0<-as.matrix(read.table("syn1.csv", format="csv", header=FALSE, sep=","))
b_1<-as.matrix(read.table("syn2.csv", format="csv", header=FALSE, sep=","))
RW8<-(sum(((t((colSums(b_1))))*(rowSums(b_0)))))