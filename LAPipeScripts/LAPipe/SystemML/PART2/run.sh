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
#P2.1 (4)
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.1_S-S-Q.scala --conf "spark.driver.args=$syn5,$syn5"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.1_S-S-RW.scala --conf "spark.driver.args=$syn5,$syn5"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.1_S-S-Q.scala --conf "spark.driver.args=$syn6,$syn6"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.1_S-S-RW.scala --conf "spark.driver.args=$syn6,$syn6"

#P2.3 (4)
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.3_S-Q.scala --conf "spark.driver.args=$syn5"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.3_S-RW.scala --conf "spark.driver.args=$syn5"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.3_S-Q.scala --conf "spark.driver.args=$syn6"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.3_S-RW.scala --conf "spark.driver.args=$syn6"

#P2.4 (4)
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.4_R-R-Q.scala --conf "spark.driver.args=$AL2,$AL2"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.4_R-R-RW.scala --conf "spark.driver.args=$AL2,$AL2"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.4_R-S-Q.scala --conf "spark.driver.args=$AL1,$syn3"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.4_R-S-RW.scala --conf "spark.driver.args=$AL1,$syn3"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.4_R-R-Q.scala --conf "spark.driver.args=$NL2,$NL2"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.4_R-R-RW.scala --conf "spark.driver.args=$NL2,$NL2"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.4_R-S-Q.scala --conf "spark.driver.args=$NL1,$syn3"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.4_R-S-RW.scala --conf "spark.driver.args=$NL1,$syn3"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.4_S-S-Q.scala --conf "spark.driver.args=$syn3,$syn3"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.4_S-S-RW.scala --conf "spark.driver.args=$syn3,$syn3"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.4_S-S-Q.scala --conf "spark.driver.args=$syn4,$syn4"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.4_S-S-RW.scala --conf "spark.driver.args=$syn4,$syn4"

#P2.6 (4)
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.6_S-S-Q.scala --conf "spark.driver.args=$syn5,$syn5"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.6_S-S-RW.scala --conf "spark.driver.args=$syn5,$syn5"

#P2.9(4)
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.9_S-S-Q.scala --conf "spark.driver.args=$syn5,$syn5"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.9_S-S-RW.scala --conf "spark.driver.args=$syn5,$syn5"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.9_S-S-Q.scala --conf "spark.driver.args=$syn6,$syn6"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.9_S-S-RW.scala --conf "spark.driver.args=$syn6,$syn6"

#P2.10(4)
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.10_R-S-Q.scala --conf "spark.driver.args=$AS,$syn2"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.10_R-S-RW.scala --conf "spark.driver.args=$AS,$syn2"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.10_R-S-Q.scala --conf "spark.driver.args=$NS,$syn2"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.10_R-S-RW.scala --conf "spark.driver.args=$NS,$syn2"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.10_S-S-Q.scala --conf "spark.driver.args=$syn1,$syn2"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.10_S-S-RW.scala --conf "spark.driver.args=$syn1,$syn2"

#P2.11(2)
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.11_R-R-Q.scala --conf "spark.driver.args=$AL2,$AL2"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.11_R-R-RW.scala --conf "spark.driver.args=$AL2,$AL2"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.11_R-S-Q.scala --conf "spark.driver.args=$AL1,$syn3"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.11_R-S-RW.scala --conf "spark.driver.args=$AL1,$syn3"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.11_R-R-Q.scala --conf "spark.driver.args=$NL2,$NL2"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.11_R-R-RW.scala --conf "spark.driver.args=$NL2,$NL2"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.11_R-S-Q.scala --conf "spark.driver.args=$NL1,$syn3"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.11_R-S-RW.scala --conf "spark.driver.args=$NL1,$syn3"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.11_S-S-Q.scala --conf "spark.driver.args=$syn3,$syn3"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.11_S-S-RW.scala --conf "spark.driver.args=$syn3,$syn3"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.11_S-S-Q.scala --conf "spark.driver.args=$syn4,$syn4"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.11_S-S-RW.scala --conf "spark.driver.args=$syn4,$syn4"

#P2.12 (4)
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.12_R-S-Q.scala --conf "spark.driver.args=$AS,$syn2"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.12_R-S-RW.scala --conf "spark.driver.args=$AS,$syn2"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.12_R-S-Q.scala --conf "spark.driver.args=$NS,$syn2"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.12_R-S-RW.scala --conf "spark.driver.args=$NS,$syn2"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.12_S-S-Q.scala --conf "spark.driver.args=$syn1,$syn2"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.12_S-S-RW.scala --conf "spark.driver.args=$syn1,$syn2"

#P2.13 (4)
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.13_R-S-Q.scala --conf "spark.driver.args=$AS,$syn2"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.13_R-S-RW.scala --conf "spark.driver.args=$AS,$syn2"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.13_R-S-Q.scala --conf "spark.driver.args=$NS,$syn2"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.13_R-S-RW.scala --conf "spark.driver.args=$NS,$syn2"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.13_S-S-Q.scala --conf "spark.driver.args=$syn1,$syn2"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.13_S-S-RW.scala --conf "spark.driver.args=$syn1,$syn2"

#P2.15 (4)
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.15_R-Q.scala --conf "spark.driver.args=$AL2"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.15_R-RW.scala --conf "spark.driver.args=$AL2"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.15_R-Q.scala --conf "spark.driver.args=$AL1"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.15_R-RW.scala --conf "spark.driver.args=$AL1"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.15_R-Q.scala --conf "spark.driver.args=$NL2"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.15_R-RW.scala --conf "spark.driver.args=$NL2"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.15_R-Q.scala --conf "spark.driver.args=$NL1"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.15_R-RW.scala --conf "spark.driver.args=$NL1"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.15_S-Q.scala --conf "spark.driver.args=$syn3"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.15_S-RW.scala --conf "spark.driver.args=$syn3"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.15_S-Q.scala --conf "spark.driver.args=$syn4"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.15_S-RW.scala --conf "spark.driver.args=$syn4"

#P2.18 (4)
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.18_R-R-Q.scala --conf "spark.driver.args=$AL2,$AL2"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.18_R-R-RW.scala --conf "spark.driver.args=$AL2,$AL2"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.18_R-S-Q.scala --conf "spark.driver.args=$AL1,$syn3"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.18_R-S-RW.scala --conf "spark.driver.args=$AL1,$syn3"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.18_R-R-Q.scala --conf "spark.driver.args=$NL2,$NL2"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.18_R-R-RW.scala --conf "spark.driver.args=$NL2,$NL2"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.18_R-S-Q.scala --conf "spark.driver.args=$NL1,$syn3"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.18_R-S-RW.scala --conf "spark.driver.args=$NL1,$syn3"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.18_S-S-Q.scala --conf "spark.driver.args=$syn3,$syn3"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.18_S-S-RW.scala --conf "spark.driver.args=$syn3,$syn3"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.18_S-S-Q.scala --conf "spark.driver.args=$syn4,$syn4"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.18_S-S-RW.scala --conf "spark.driver.args=$syn4,$syn4"
