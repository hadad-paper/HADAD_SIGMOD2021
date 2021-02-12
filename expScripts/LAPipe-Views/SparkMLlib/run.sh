#Datasets Path
DATA_PATH_SYN="../../../data/synthetic/"
DATA_PATH_REAL="../../../data/real-data/"
DATA_PATH_VIEWS="../../../data/views/"
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
#Views
V1="V1.csv"
V2="V2.csv"
V3="V3.csv"
V4="V4.csv"
V5A="V5A.csv"
V5B="V5B.csv"
V6A="V6A.csv"
V6B="V6B.csv"
V7="V7.csv"
V8A="V8A.csv"
V8B="V8B.csv"
V9="V9.csv"
V10="V10.csv"
V11="V11.csv"
V12A="V12A.csv"
V12B="V12A.csv"
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

V1=$(cd $(dirname "$DATA_PATH_VIEWS$V1"); pwd)/$(basename "$DATA_PATH_VIEWS$V1")
V2=$(cd $(dirname "$DATA_PATH_VIEWS$V2"); pwd)/$(basename "$DATA_PATH_VIEWS$V2")
V3=$(cd $(dirname "$DATA_PATH_VIEWS$V3"); pwd)/$(basename "$DATA_PATH_VIEWS$V3")
V4=$(cd $(dirname "$DATA_PATH_VIEWS$V4"); pwd)/$(basename "$DATA_PATH_VIEWS$V4")
V5A=$(cd $(dirname "$DATA_PATH_VIEWS$V5A"); pwd)/$(basename "$DATA_PATH_VIEWS$V5A")
V5B=$(cd $(dirname "$DATA_PATH_VIEWS$V5B"); pwd)/$(basename "$DATA_PATH_VIEWS$V5B")
V6A=$(cd $(dirname "$DATA_PATH_VIEWS$V6A"); pwd)/$(basename "$DATA_PATH_VIEWS$V6A")
V6B=$(cd $(dirname "$DATA_PATH_VIEWS$V6B"); pwd)/$(basename "$DATA_PATH_VIEWS$V6B")
V7=$(cd $(dirname "$DATA_PATH_VIEWS$V7"); pwd)/$(basename "$DATA_PATH_VIEWS$V7")
V8A=$(cd $(dirname "$DATA_PATH_VIEWS$V8A"); pwd)/$(basename "$DATA_PATH_VIEWS$V8A")
V8B=$(cd $(dirname "$DATA_PATH_VIEWS$V8B"); pwd)/$(basename "$DATA_PATH_VIEWS$V8B")
V9=$(cd $(dirname "$DATA_PATH_VIEWS$V9"); pwd)/$(basename "$DATA_PATH_VIEWS$V9")
V10=$(cd $(dirname "$DATA_PATH_VIEWS$V10"); pwd)/$(basename "$DATA_PATH_VIEWS$V10")
V11=$(cd $(dirname "$DATA_PATH_VIEWS$V11"); pwd)/$(basename "$DATA_PATH_VIEWS$V11")
V12A=$(cd $(dirname "$DATA_PATH_VIEWS$V12A"); pwd)/$(basename "$DATA_PATH_VIEWS$V12A")
V12B=$(cd $(dirname "$DATA_PATH_VIEWS$V12B"); pwd)/$(basename "$DATA_PATH_VIEWS$V12B")

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
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.2-Q.scala --conf "spark.driver.args=$syn3,$syn3"
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.2-RW.scala --conf "spark.driver.args=$V6A"
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.2-Q.scala --conf "spark.driver.args=$syn4,$syn4"
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.2-RW.scala --conf "spark.driver.args=$V6B"

../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.3-Q.scala --conf "spark.driver.args=$syn5,$syn5"
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.3-RW.scala --conf "spark.driver.args=$V1,$V7"
#P1.4 (4)
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.4-Q.scala --conf "spark.driver.args=$syn3,$syn3,$syn7"
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.4-RW.scala --conf "spark.driver.args=$V6A,$syn7"
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.4-Q.scala --conf "spark.driver.args=$syn4,$syn4,$syn7"
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.4-RW.scala --conf "spark.driver.args=$V6B,$syn7"

#P1.11 (4)
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.11-Q.scala --conf "spark.driver.args=$syn3,$syn3"
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.11-RW.scala --conf "spark.driver.args=$V6A"
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.11-Q.scala --conf "spark.driver.args=$syn4,$syn4"
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.11-RW.scala --conf "spark.driver.args=$V6B"

#P1.17 (4)
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.17-Q.scala --conf "spark.driver.args=$syn5,$syn5"
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.17-RW.scala --conf "spark.driver.args=$syn5"

#P1.19 (4)
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.19-Q.scala --conf "spark.driver.args=$syn5"
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.19-RW.scala --conf "spark.driver.args=$V7"


#P1.20 (4)
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.20-Q.scala --conf "spark.driver.args=$syn5"
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.20-RW.scala --conf "spark.driver.args=$V7"

#P1.21 (4)
#../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.21-Q.scala --conf "spark.driver.args=$syn5,$syn5"
#../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.21-RW.scala --conf "spark.driver.args=$syn5,$V1"

#P1.22 (4)
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.22-Q.scala --conf "spark.driver.args=$syn5,$syn5"
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.22-RW.scala --conf "spark.driver.args=$V9"

#P1.23 (4)
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.23-Q.scala --conf "spark.driver.args=$syn5,$syn5"
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.23-RW.scala --conf "spark.driver.args=$syn5,$V1,$V7"

#P1.24 (4)
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.24-Q.scala --conf "spark.driver.args=$syn5,$syn5"
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.24-RW.scala --conf "spark.driver.args=$syn5,$V1,$V7"


#P1.29 (4)
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.29-Q.scala --conf "spark.driver.args=$syn5,$syn5"
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.29-RW.scala --conf "spark.driver.args=$syn5,$V5A"
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.29-Q.scala --conf "spark.driver.args=$syn6,$syn6"
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P1.29-RW.scala --conf "spark.driver.args=$syn6,$V5B"


#P2.2 (4)
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.2-Q.scala --conf "spark.driver.args=$syn5"
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.2-RW.scala --conf "spark.driver.args=$V1"

#P2.4
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.4-Q.scala --conf "spark.driver.args=$syn3,$syn3"
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.4-RW.scala --conf "spark.driver.args=$V6A"
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.4-Q.scala --conf "spark.driver.args=$syn4,$syn4"
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.4-RW.scala --conf "spark.driver.args=$V6B"

#P2.5
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.5-Q.scala --conf "spark.driver.args=$syn5,$syn5"
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.5-RW.scala --conf "spark.driver.args=$V9"

#P2.9
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.9-Q.scala --conf "spark.driver.args=$syn5,$syn5"
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.9-RW.scala --conf "spark.driver.args=$syn5,$V12A"
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.9-Q.scala --conf "spark.driver.args=$syn6,$syn6"
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.9-RW.scala --conf "spark.driver.args=$syn6,$V12B"

#P2.11
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.11-Q.scala --conf "spark.driver.args=$syn3,$syn3"
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.11-RW.scala --conf "spark.driver.args=$V6A"
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.11-Q.scala --conf "spark.driver.args=$syn4,$syn4"
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.11-RW.scala --conf "spark.driver.args=$V6B"

#P2.13
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.13-Q.scala --conf "spark.driver.args=$syn1,$syn2"
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.13-RW.scala --conf "spark.driver.args=$syn1,$V3"

#P2.16
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.16-Q.scala --conf "spark.driver.args=$syn5,$syn5"
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.16-RW.scala --conf "spark.driver.args=$syn5,$V1,$V7"

#P2.18
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.18-Q.scala --conf "spark.driver.args=$syn3,$syn3"
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.18-RW.scala --conf "spark.driver.args=$V6A"

../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.18-Q.scala --conf "spark.driver.args=$syn4,$syn4"
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.18-RW.scala --conf "spark.driver.args=$V6B"

#P2.20
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.20-Q.scala --conf "spark.driver.args=$syn1,$syn2"
../../../bin/spark-2.4.6/bin/spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i P2.20-RW.scala --conf "spark.driver.args=$syn1,$V3"

