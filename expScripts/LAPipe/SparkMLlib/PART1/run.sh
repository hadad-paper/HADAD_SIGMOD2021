#Datasets Path
DATA_PATH_SYN="../../../../data/synthetic/"
DATA_PATH_REAL="../../../../data/real-data/"
#Synthetic
syn1="matrix-50000-100-1.0.csv"
syn2="matrix-100-50000-1.0.csv"
syn3="1000000,100"
syn4="5000000,100"
syn5="10000,10000"
syn6="20000,20000"
syn7="100,1"
syn8="50000,1"
syn9="100000,1"
syn10="100,100"

#Absolute Paths (Syn)
# syn1=$(cd $(dirname "$DATA_PATH_SYN$syn1"); pwd)/$(basename "$DATA_PATH_SYN$syn1")
# syn2=$(cd $(dirname "$DATA_PATH_SYN$syn2"); pwd)/$(basename "$DATA_PATH_SYN$syn2")
# syn3=$(cd $(dirname "$DATA_PATH_SYN$syn3"); pwd)/$(basename "$DATA_PATH_SYN$syn3")
# syn4=$(cd $(dirname "$DATA_PATH_SYN$syn4"); pwd)/$(basename "$DATA_PATH_SYN$syn4")
# syn5=$(cd $(dirname "$DATA_PATH_SYN$syn5"); pwd)/$(basename "$DATA_PATH_SYN$syn5")
# syn6=$(cd $(dirname "$DATA_PATH_SYN$syn6"); pwd)/$(basename "$DATA_PATH_SYN$syn6")
# syn7=$(cd $(dirname "$DATA_PATH_SYN$syn7"); pwd)/$(basename "$DATA_PATH_SYN$syn7")
# syn8=$(cd $(dirname "$DATA_PATH_SYN$syn8"); pwd)/$(basename "$DATA_PATH_SYN$syn8")
# syn9=$(cd $(dirname "$DATA_PATH_SYN$syn9"); pwd)/$(basename "$DATA_PATH_SYN$syn9")
# syn10=$(cd $(dirname "$DATA_PATH_SYN$syn10"); pwd)/$(basename "$DATA_PATH_SYN$syn10")


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

export LD_PRELOAD=/opt/OpenBLAS/lib/libopenblas.so
#P1.2 (4)
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.2_R-R-Q.scala --conf "spark.driver.args=$AL2,$AL2"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.2_R-R-RW.scala --conf "spark.driver.args=$AL2,$AL2"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.2_R-S-Q.scala --conf "spark.driver.args=$AL1,$syn3"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.2_R-S-RW.scala --conf "spark.driver.args=$AL1,$syn3"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.2_S-S-Q.scala --conf "spark.driver.args=$syn3,$syn3"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.2_S-S-RW.scala --conf "spark.driver.args=$syn3,$syn3"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.2_S-S-Q.scala --conf "spark.driver.args=$syn4,$syn4"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.2_S-S-RW.scala --conf "spark.driver.args=$syn4,$syn4"

#P1.4 (4)
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.4_R-R-Q.scala --conf "spark.driver.args=$AL2,$AL2,$syn7"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.4_R-R-RW.scala --conf "spark.driver.args=$AL2,$AL2,$syn7"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.4_R-S-Q.scala --conf "spark.driver.args=$AL1,$syn3,$syn7"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.4_R-S-RW.scala --conf "spark.driver.args=$AL1,$syn3,$syn7"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.4_S-S-Q.scala --conf "spark.driver.args=$syn3,$syn3,$syn7"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.4_S-S-RW.scala --conf "spark.driver.args=$syn3,$syn3,$syn7"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.4_S-S-Q.scala --conf "spark.driver.args=$syn4,$syn4,$syn7"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.4_S-S-RW.scala --conf "spark.driver.args=$syn4,$syn4,$syn7"

# #P1.6 (4)
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.6_S-S-Q.scala --conf "spark.driver.args=$syn5"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.6_S-S-RW.scala --conf "spark.driver.args=$syn5"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.6_S-S-Q.scala --conf "spark.driver.args=$syn6"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.6_S-S-RW.scala --conf "spark.driver.args=$syn6"

#P1.7 (4)
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.7_R-Q.scala --conf "spark.driver.args=$AL2"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.7_R-RW.scala --conf "spark.driver.args=$AL2"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.7_R-Q.scala --conf "spark.driver.args=$AL1"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.7_R-RW.scala --conf "spark.driver.args=$AL1"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.7_S-Q.scala --conf "spark.driver.args=$syn3"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.7_S-RW.scala --conf "spark.driver.args=$syn3"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.7_S-Q.scala --conf "spark.driver.args=$syn4"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.7_S-RW.scala --conf "spark.driver.args=$syn4"

#P1.8 (4)
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.8_R-Q.scala --conf "spark.driver.args=$AL2"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.8_R-RW.scala --conf "spark.driver.args=$AL2"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.8_R-Q.scala --conf "spark.driver.args=$AL1"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.8_R-RW.scala --conf "spark.driver.args=$AL1"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.8_S-Q.scala --conf "spark.driver.args=$syn3"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.8_S-RW.scala --conf "spark.driver.args=$syn3"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.8_S-Q.scala --conf "spark.driver.args=$syn4"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.8_S-RW.scala --conf "spark.driver.args=$syn4"

#P1.10 (4)
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.10_R-Q.scala --conf "spark.driver.args=$AL2"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.10_R-RW.scala --conf "spark.driver.args=$AL2"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.10_R-Q.scala --conf "spark.driver.args=$AL1"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.10_R-RW.scala --conf "spark.driver.args=$AL1"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.10_S-Q.scala --conf "spark.driver.args=$syn3"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.10_S-RW.scala --conf "spark.driver.args=$syn3"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.10_S-Q.scala --conf "spark.driver.args=$syn4"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.10_S-RW.scala --conf "spark.driver.args=$syn4"

#P1.11 (4)
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.11_R-R-Q.scala --conf "spark.driver.args=$AL2,$AL2"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.11_R-R-RW.scala --conf "spark.driver.args=$AL2,$AL2"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.11_R-S-Q.scala --conf "spark.driver.args=$AL1,$syn3"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.11_R-S-RW.scala --conf "spark.driver.args=$AL1,$syn3"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.11_S-S-Q.scala --conf "spark.driver.args=$syn3,$syn3"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.11_S-S-RW.scala --conf "spark.driver.args=$syn3,$syn3"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.11_S-S-Q.scala --conf "spark.driver.args=$syn4,$syn4"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.11_S-S-RW.scala --conf "spark.driver.args=$syn4,$syn4"


#P1.15 (4)
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.15_R-S-Q.scala --conf "spark.driver.args=$AS,$syn2"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.15_R-S-RW.scala --conf "spark.driver.args=$AS,$syn2"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.15_S-S-Q.scala --conf "spark.driver.args=$syn1,$syn2"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.15_S-S-RW.scala --conf "spark.driver.args=$syn1,$syn2"

#P1.16 (4)
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.16_R-Q.scala --conf "spark.driver.args=$AL2"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.16_R-RW.scala --conf "spark.driver.args=$AL2"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.16_R-Q.scala --conf "spark.driver.args=$AL1"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.16_R-RW.scala --conf "spark.driver.args=$AL1"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.16_S-Q.scala --conf "spark.driver.args=$syn3"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.16_S-RW.scala --conf "spark.driver.args=$syn3"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.16_S-Q.scala --conf "spark.driver.args=$syn4"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.16_S-RW.scala --conf "spark.driver.args=$syn4"

#P1.18 (4)
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.18_R-Q.scala --conf "spark.driver.args=$AL2"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.18_R-RW.scala --conf "spark.driver.args=$AL2"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.18_R-Q.scala --conf "spark.driver.args=$AL1"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.18_R-RW.scala --conf "spark.driver.args=$AL1"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.18_S-Q.scala --conf "spark.driver.args=$syn3"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.18_S-RW.scala --conf "spark.driver.args=$syn3"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.18_S-Q.scala --conf "spark.driver.args=$syn4"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.18_S-RW.scala --conf "spark.driver.args=$syn4"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.18_S-Q.scala --conf "spark.driver.args=$syn4"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.18_S-RW.scala --conf "spark.driver.args=$syn4"

