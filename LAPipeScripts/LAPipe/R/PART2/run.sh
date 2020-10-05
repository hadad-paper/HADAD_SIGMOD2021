#Datasets Path
DATA_PATH_SYN="../../../../data/synthetic/"
DATA_PATH_REAL="../../../../data/real-data/"
#Synthetic
syn1="matrix-50000-100-1.0.csv"
syn2="matrix-100-50000-1.0.csv"
syn3="matrix-1000000-100-1.0.csv"
syn4="matrix-5000000-100-1.0.csv"
syn5="matrix-10000-10000-1.0.csv"
syn6="matrix-20000-20000-1.0.csv"
syn7="matrix-100-1-1.0.csv"
syn8="matrix-50000-1-1.0.csv"
syn9="matrix-100000-1-1.0.csv"
syn10="matrix-100-100-1.0.csv"

#Absolute Paths (Syn)
syn1=$(cd $(dirname "$DATA_PATH_SYN$syn1"); pwd)/$(basename "$DATA_PATH_SYN$syn1")
syn2=$(cd $(dirname "$DATA_PATH_SYN$syn2"); pwd)/$(basename "$DATA_PATH_SYN$syn2")
syn3=$(cd $(dirname "$DATA_PATH_SYN$syn3"); pwd)/$(basename "$DATA_PATH_SYN$syn3")
syn4=$(cd $(dirname "$DATA_PATH_SYN$syn4"); pwd)/$(basename "$DATA_PATH_SYN$syn4")
syn5=$(cd $(dirname "$DATA_PATH_SYN$syn5"); pwd)/$(basename "$DATA_PATH_SYN$syn5")
syn6=$(cd $(dirname "$DATA_PATH_SYN$syn6"); pwd)/$(basename "$DATA_PATH_SYN$syn6")
syn7=$(cd $(dirname "$DATA_PATH_SYN$syn7"); pwd)/$(basename "$DATA_PATH_SYN$syn7")
syn8=$(cd $(dirname "$DATA_PATH_SYN$syn8"); pwd)/$(basename "$DATA_PATH_SYN$syn8")
syn9=$(cd $(dirname "$DATA_PATH_SYN$syn9"); pwd)/$(basename "$DATA_PATH_SYN$syn9")
syn10=$(cd $(dirname "$DATA_PATH_SYN$syn10"); pwd)/$(basename "$DATA_PATH_SYN$syn10")


#Real-datasets
AS="AS.mtx"
AM="AM.mtx"
AL1="AL1.mtx"
AL2="AL2.mtx"
AL3="AL3.mtx"
NS="NS.mtx"
NM="NM.mtx"
NL1="NL1.mtx"
NL2="NL2.mtx"

#Absolute Paths (real)
AS=$(cd $(dirname "$DATA_PATH_REAL$AS"); pwd)/$(basename "$DATA_PATH_REAL$AS")
AM=$(cd $(dirname "$DATA_PATH_REAL$AM"); pwd)/$(basename "$DATA_PATH_REAL$AM")
AL1=$(cd $(dirname "$DATA_PATH_REAL$AL1"); pwd)/$(basename "$DATA_PATH_REAL$AL1")
AL2=$(cd $(dirname "$DATA_PATH_REAL$AL2"); pwd)/$(basename "$DATA_PATH_REAL$AL2")
AL3=$(cd $(dirname "$DATA_PATH_REAL$AL3"); pwd)/$(basename "$DATA_PATH_REAL$AL3")
NS=$(cd $(dirname "$DATA_PATH_REAL$NS"); pwd)/$(basename "$DATA_PATH_REAL$NS")
NL1=$(cd $(dirname "$DATA_PATH_REAL$NL1"); pwd)/$(basename "$DATA_PATH_REAL$NL1")
NL2=$(cd $(dirname "$DATA_PATH_REAL$NL2"); pwd)/$(basename "$DATA_PATH_REAL$NL2")


#P2.1
taskset -c 0-23 Rscript P2.1_S-S-Q.R $syn5 $syn5
taskset -c 0-23 Rscript P2.1_S-S-RW.R $syn5 $syn5
taskset -c 0-23 Rscript P2.1_S-S-Q.R $syn6 $syn1
taskset -c 0-23 Rscript P2.1_S-S-RW.R $syn6 $syn6
#P2.2
taskset -c 0-23 Rscript P2.2_S-Q.R $syn5
taskset -c 0-23 Rscript P2.2_S-RW.R $syn5

#P2.3
taskset -c 0-23 Rscript P2.3_S-Q.R $syn5
taskset -c 0-23 Rscript P2.3_S-RW.R $syn5
taskset -c 0-23 Rscript P2.3_S-Q.R $syn6
taskset -c 0-23 Rscript P2.3_S-RW.R $syn6

#P2.4
taskset -c 0-23 Rscript P2.4_R-S-Q.R $AL1 $syn3 $syn7 
taskset -c 0-23 Rscript P2.4_R-S-RW.R $AL1 $syn3 $syn7 
taskset -c 0-23 Rscript P2.4_R-R-Q.R $AL2 $AL2 $syn7
taskset -c 0-23 Rscript P2.4_R-R-RW.R $AL2 $AL2 $syn7
taskset -c 0-23 Rscript P2.4_R-S-Q.R $NL1 $syn3 $syn7
taskset -c 0-23 Rscript P2.4_R-S-RW.R $NL1 $syn3 $syn7
taskset -c 0-23 Rscript P2.4_R-R-Q.R $NL2 $NL2 $syn7
taskset -c 0-23 Rscript P2.4_R-R-RW.R $NL2 $NL2 $syn7
taskset -c 0-23 Rscript P2.4_S-S-Q.R $syn3 $syn3 $syn7
taskset -c 0-23 Rscript P2.4_S-S-RW.R $syn3 $syn3 $syn7
taskset -c 0-23 Rscript P2.4_S-S-Q.R $syn4 $syn4 $syn7
taskset -c 0-23 Rscript P2.4_S-S-RW.R $syn4 $syn4 $syn7

#P2.5
taskset -c 0-23 Rscript P2.5_S-S-Q.R $syn5 $syn5
taskset -c 0-23 Rscript P2.5_S-S-RW.R $syn5 $syn5
taskset -c 0-23 Rscript P2.5_S-S-Q.R $syn6 $syn6
taskset -c 0-23 Rscript P2.5_S-S-RW.R $syn6 $syn6

#P2.6
taskset -c 0-23 Rscript P2.6_S-S-Q.R $syn5 $syn5
taskset -c 0-23 Rscript P2.6_S-S-RW.R $syn5 $syn5
taskset -c 0-23 Rscript P2.6_S-S-Q.R $syn6 $syn6
taskset -c 0-23 Rscript P2.6_S-S-RW.R $syn6 $syn6

#P2.7
taskset -c 0-23 Rscript P2.7_S-S-Q.R $syn5 $syn5
taskset -c 0-23 Rscript P2.7_S-S-RW.R $syn5 $syn5
taskset -c 0-23 Rscript P2.7_S-S-Q.R $syn6 $syn6
taskset -c 0-23 Rscript P2.7_S-S-RW.R $syn6 $syn6

#P2.8
taskset -c 0-23 Rscript P2.8_S-S-Q.R $syn5 $syn5
taskset -c 0-23 Rscript P2.8_S-S-RW.R $syn5 $syn5
taskset -c 0-23 Rscript P2.8_S-S-Q.R $syn6 $syn6
taskset -c 0-23 Rscript P2.8_S-S-RW.R $syn6 $syn6

#P2.9
taskset -c 0-23 Rscript P2.9_S-S-Q.R $syn5 $syn5
taskset -c 0-23 Rscript P2.9_S-S-RW.R $syn5 $syn5
taskset -c 0-23 Rscript P2.9_S-S-Q.R $syn6 $syn6
taskset -c 0-23 Rscript P2.9_S-S-RW.R $syn6 $syn6

#P2.10
taskset -c 0-23 Rscript P2.10_R-S-Q.R $AS $syn2
taskset -c 0-23 Rscript P2.10_R-S-RW.R $AS $syn2
taskset -c 0-23 Rscript P2.10_R-S-Q.R $NS $syn2
taskset -c 0-23 Rscript P2.10_S-S-RW.R $syn1 $syn2

#P2.11
taskset -c 0-23 Rscript P2.11_R-S-Q.R $AL1 $syn3
taskset -c 0-23 Rscript P2.11_R-S-RW.R $AL1 $syn3
taskset -c 0-23 Rscript P2.11_R-R-Q.R $AL2 $AL2
taskset -c 0-23 Rscript P2.11_R-R-RW.R $AL2 $AL2
taskset -c 0-23 Rscript P2.11_R-S-Q.R $NL1 $syn3
taskset -c 0-23 Rscript P2.11_R-S-RW.R $NL1 $syn3
taskset -c 0-23 Rscript P2.11_R-R-Q.R $NL2 $NL2
taskset -c 0-23 Rscript P2.11_R-R-RW.R $NL2 $NL2
taskset -c 0-23 Rscript P2.11_S-S-Q.R $syn3 $syn3
taskset -c 0-23 Rscript P2.11_S-S-RW.R $syn3 $syn3
taskset -c 0-23 Rscript P2.11_S-S-Q.R $syn4 $syn4
taskset -c 0-23 Rscript P2.11_S-S-RW.R $syn4 $syn4

#P2.12
taskset -c 0-23 Rscript P2.12_R-S-Q.R $AS $syn2
taskset -c 0-23 Rscript P2.12_R-S-RW.R $AS $syn2
taskset -c 0-23 Rscript P2.12_R-S-Q.R $NS $syn2
taskset -c 0-23 Rscript P2.12_R-S-RW.R $NS $syn2
taskset -c 0-23 Rscript P2.12_S-S-Q.R $syn1 $syn2
taskset -c 0-23 Rscript P2.12_S-S-RW.R $syn1 $syn2

#P2.13
taskset -c 0-23 Rscript P2.13_R-S-Q.R $AS $syn2
taskset -c 0-23 Rscript P2.13_R-S-RW.R $AS $syn2
taskset -c 0-23 Rscript P2.13_R-S-Q.R $NS $syn2
taskset -c 0-23 Rscript P2.13_R-S-RW.R $NS $syn2
taskset -c 0-23 Rscript P2.13_S-S-Q.R $syn1 $syn2
taskset -c 0-23 Rscript P2.13_S-S-RW.R $syn1 $syn2


#P2.14
taskset -c 0-23 Rscript P2.14_R-S-Q.R $AS $syn2
taskset -c 0-23 Rscript P2.14_R-S-RW.R $AS $syn2
taskset -c 0-23 Rscript P2.14_R-S-Q.R $NS $syn2
taskset -c 0-23 Rscript P2.14_R-S-RW.R $NS $syn2
taskset -c 0-23 Rscript P2.14_S-S-Q.R $syn1 $syn2
taskset -c 0-23 Rscript P2.14_S-S-RW.R $syn1 $syn2

#P2.15
taskset -c 0-23 Rscript P2.15_R-Q.R $AL1
taskset -c 0-23 Rscript P2.15_R-RW.R $AL1
taskset -c 0-23 Rscript P2.15_R-Q.R $AL2
taskset -c 0-23 Rscript P2.15_R-RW.R $AL2
taskset -c 0-23 Rscript P2.15_R-Q.R $NL1
taskset -c 0-23 Rscript P2.15_R-RW.R $NL1
taskset -c 0-23 Rscript P2.15_R-Q.R $NL2
taskset -c 0-23 Rscript P2.15_R-RW.R $NL2
taskset -c 0-23 Rscript P2.15_S-Q.R $syn3
taskset -c 0-23 Rscript P2.15_S-RW.R $syn3
taskset -c 0-23 Rscript P2.15_S-Q.R $syn4
taskset -c 0-23 Rscript P2.15_S-RW.R $syn4

#P2.16
taskset -c 0-23 Rscript P2.16_S-S-Q.R $syn5 $syn5
taskset -c 0-23 Rscript P2.16_S-S-RW.R $syn5 $syn5
taskset -c 0-23 Rscript P2.16_S-S-Q.R $syn6 $syn6
taskset -c 0-23 Rscript P2.16_S-S-RW.R $syn6 $syn6



#P2.18
taskset -c 0-23 Rscript P2.18_R-S-Q.R $AL1 $syn3
taskset -c 0-23 Rscript P2.18_R-S-RW.R $AL1 $syn3
taskset -c 0-23 Rscript P2.18_R-R-Q.R $AL2 $AL2
taskset -c 0-23 Rscript P2.18_R-R-RW.R $AL2 $AL2
taskset -c 0-23 Rscript P2.18_R-S-Q.R $NL1 $syn3
taskset -c 0-23 Rscript P2.18_R-S-RW.R $NL1 $syn3
taskset -c 0-23 Rscript P2.18_R-R-Q.R $NL2 $NL2
taskset -c 0-23 Rscript P2.18_R-R-RW.R $NL2 $NL2
taskset -c 0-23 Rscript P2.18_S-S-Q.R $syn3 $syn3
taskset -c 0-23 Rscript P2.18_S-S-RW.R $syn3 $syn3
taskset -c 0-23 Rscript P2.18_S-S-Q.R $syn4 $syn4
taskset -c 0-23 Rscript P2.18_S-S-RW.R $syn4 $syn4
