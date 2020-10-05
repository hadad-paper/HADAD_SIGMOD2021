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
#P2.1 (4)
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.1_S-S-Q.scala --conf "spark.driver.args=$syn5,$syn5"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.1_S-S-RW.scala --conf "spark.driver.args=$syn5,$syn5"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.1_S-S-Q.scala --conf "spark.driver.args=$syn6,$syn6"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.1_S-S-RW.scala --conf "spark.driver.args=$syn6,$syn6"

#P2.3 (4)
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.3_S-Q.scala --conf "spark.driver.args=$syn5"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.3_S-RW.scala --conf "spark.driver.args=$syn5"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.3_S-Q.scala --conf "spark.driver.args=$syn6"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.3_S-RW.scala --conf "spark.driver.args=$syn6"

#P2.4 (4)
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.4_R-R-Q.scala --conf "spark.driver.args=$AL2,$AL2"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.4_R-R-RW.scala --conf "spark.driver.args=$AL2,$AL2"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.4_R-S-Q.scala --conf "spark.driver.args=$AL1,$syn3"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.4_R-S-RW.scala --conf "spark.driver.args=$AL1,$syn3"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.4_S-S-Q.scala --conf "spark.driver.args=$syn3,$syn3"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.4_S-S-RW.scala --conf "spark.driver.args=$syn3,$syn3"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.4_S-S-Q.scala --conf "spark.driver.args=$syn4,$syn4"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.4_S-S-RW.scala --conf "spark.driver.args=$syn4,$syn4"

#P2.5 (4)
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.5_S-S-Q.scala --conf "spark.driver.args=$syn5"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.5_S-S-RW.scala --conf "spark.driver.args=$syn5"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.5_S-S-Q.scala --conf "spark.driver.args=$syn6"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.5_S-S-RW.scala --conf "spark.driver.args=$syn6"


#P2.6 (4)
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.6_S-S-Q.scala --conf "spark.driver.args=$syn5,$syn5"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.6_S-S-RW.scala --conf "spark.driver.args=$syn5,$syn5"

#P2.8 (4)
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.8_S-S-Q.scala --conf "spark.driver.args=$syn5,$syn5"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.8_S-S-RW.scala --conf "spark.driver.args=$syn5,$syn5"

#P2.11(2)
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.11_S-S-Q.scala --conf "spark.driver.args=$syn3,$syn3"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.11_S-S-RW.scala --conf "spark.driver.args=$syn3,$syn3"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.11_S-S-Q.scala --conf "spark.driver.args=$syn4,$syn4"
../../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.11_S-S-RW.scala --conf "spark.driver.args=$syn4,$syn4"
