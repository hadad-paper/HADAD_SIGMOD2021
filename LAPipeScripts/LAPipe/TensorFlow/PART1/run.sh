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


#P1.1
taskset -c 0-23 python2.7 P1.1_S-S-Q.py $syn1 $syn2
taskset -c 0-23 python2.7 P1.1_S-S-RW.py $syn1 $syn2

#P1.2
taskset -c 0-23 python2.7 P1.2_S-S-Q.py $syn3 $syn3
taskset -c 0-23 python2.7 P1.2_S-S-RW.py $syn3 $syn3
taskset -c 0-23 python2.7 P1.2_S-S-Q.py $syn4 $syn4
taskset -c 0-23 python2.7 P1.2_S-S-RW.py $syn4 $syn4

#P1.3
taskset -c 0-23 python2.7s P1.3_S-S-Q.py $syn5 $syn5
taskset -c 0-23 python2.7s P1.3_S-S-RW.py $syn5 $syn5
taskset -c 0-23 python2.7 P1.3_S-S-Q.py $syn6 $syn6
taskset -c 0-23 python2.7 P1.3_S-S-Q-RW.py $syn6 $syn6

#P1.4
taskset -c 0-23 python2.7 P1.4_S-S-Q.py $syn3 $syn3 $syn7
taskset -c 0-23 python2.7 P1.4_S-S-RW.py $syn3 $syn3 $syn7
taskset -c 0-23 python2.7 P1.4_S-S-Q.py $syn4 $syn4 $syn7
taskset -c 0-23 python2.7 P1.4_S-S-RW.py $syn4 $syn4 $syn7

#P1.5
taskset -c 0-23 python2.7 P1.5_S-S-Q.py $syn5
taskset -c 0-23 python2.7 P1.5_S-S-RW.py $syn5
taskset -c 0-23 python2.7 P1.5_S-S-Q.py $syn6
taskset -c 0-23 python2.7 P1.5_S-S-RW.py $syn6

#P1.6
taskset -c 0-23 python2.7 P1.6_S-S-Q.py $syn5
taskset -c 0-23 python2.7 P1.6_S-S-RW.py $syn5
taskset -c 0-23 python2.7 P1.6_S-S-Q.py $syn6
taskset -c 0-23 python2.7 P1.6_S-S-RW.py $syn6

#P1.7
taskset -c 0-23 python2.7 P1.7_S-S-Q.py $syn3
taskset -c 0-23 python2.7 P1.7_S-S-RW.py $syn3
taskset -c 0-23 python2.7 P1.7_S-S-Q.py $syn4
taskset -c 0-23 python2.7 P1.7_S-S-Q-RW.py $syn4

#P1.8
taskset -c 0-23 python2.7 P1.8_S-Q.py $syn3
taskset -c 0-23 python2.7 P1.8_S-RW.py $syn3
taskset -c 0-23 python2.7 P1.8_S-Q.py $syn4
taskset -c 0-23 python2.7 P1.8_S-RW.py $syn4

#P1.9
taskset -c 0-23 python2.7 P1.9_S-Q.py $syn5
taskset -c 0-23 python2.7 P1.9_S-RW.py $syn5
taskset -c 0-23 python2.7 P1.9_S-Q.py $syn6
taskset -c 0-23 python2.7 P1.9_S-RW.py $syn6


#P1.10
taskset -c 0-23 python2.7 P1.10_S-Q.py $syn3
taskset -c 0-23 python2.7 P1.10_S-RW.py $syn3
taskset -c 0-23 python2.7 P1.10_S-Q.py $syn4
taskset -c 0-23 python2.7 P1.10_S-RW.py $syn4

#P1.11
taskset -c 0-23 python2.7 P1.11_S-S-Q.py $syn3 $syn3
taskset -c 0-23 python2.7 P1.11_S-S-RW.py $syn3 $syn3
taskset -c 0-23 python2.7 P1.11_S-S-Q.py $syn4 $syn4
taskset -c 0-23 python2.7 P1.11_S-S-RW.py $syn4 $syn4

#P1.12
taskset -c 0-23 python2.7 P1.12_S-S-Q.py $syn1 $syn2
taskset -c 0-23 python2.7 P1.12_S-S-RW.py $syn1 $syn2

#P1.13
taskset -c 0-23 python2.7 P1.13_S-S-Q.py $syn1 $syn2
taskset -c 0-23 python2.7 P1.13_S-S-RW.py $syn1 $syn2

#P1.14
taskset -c 0-23 python2.7 P1.14_S-S-Q.py $syn1 $syn2
taskset -c 0-23 python2.7 P1.14_S-S-RW.py $syn1 $syn2

#P1.15
taskset -c 0-23 python2.7 P1.15_S-S-Q.py $syn1 $syn2
taskset -c 0-23 python2.7 P1.15_S-S-RW.py $syn1 $syn2

#P1.16
taskset -c 0-23 python2.7 P1.16_S-Q.py $syn1 $syn2
taskset -c 0-23 python2.7 P1.16_S-RW.py $syn1 $syn2

#P1.17
taskset -c 0-23 python2.7 P1.17_S-S-Q.py $syn5
taskset -c 0-23 python2.7 P1.17_S-S-RW.py $syn5
taskset -c 0-23 python2.7 P1.17_S-S-Q.py $syn6
taskset -c 0-23 python2.7 P1.17_S-S-RW.py $syn6

#P1.18
taskset -c 0-23 python2.7 P1.17_S-S-Q.py $syn5
taskset -c 0-23 python2.7 P1.17_S-S-RW.py $syn5
taskset -c 0-23 python2.7 P1.17_S-S-Q.py $syn6
taskset -c 0-23 python2.7 P1.17_S-S-RW.py $syn6

#P1.25
taskset -c 0-23 python2.7 P1.25_S-Q.py $syn1 $syn2
taskset -c 0-23 python2.7 P1.25_S-RW.py $syn1 $syn2