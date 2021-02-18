DataPath1="../../../data/real-data/"
DataPath2="../../../data/synthetic/"
tweets="tweets/"
User="User.csv"
Tweet="Tweet.csv"
TweetIDs="TweetIDs.csv"
HashtageIDs="HashtagIDs.csv"
VV2="VV2.csv"

tweets=$(cd $(dirname "$DataPath1$tweets"); pwd)/$(basename "$DataPath1$tweets")
User=$(cd $(dirname "$DataPath1$User"); pwd)/$(basename "$DataPath1$User")
Tweet=$(cd $(dirname "$DataPath1$Tweet"); pwd)/$(basename "$DataPath1$Tweet")
TweetIDs=$(cd $(dirname "$DataPath1$TweetIDs"); pwd)/$(basename "$DataPath1$TweetIDs")
HashtageIDs=$(cd $(dirname "$DataPath1$HashtageIDs"); pwd)/$(basename "$DataPath1$HashtageIDs")
VV2=$(cd $(dirname "$DataPath1$VV2"); pwd)/$(basename "$DataPath1$VV2")

# 2M 
#Q1-1
syn1="matrix-1000-1-1.0.csv"
syn2="matrix-2380000-1-1.0.csv"
syn3="matrix-1000-2380000-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")
syn3=$(cd $(dirname "$DataPath2$syn3"); pwd)/$(basename "$DataPath2$syn3")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp2M/Q1-1/Hybrid01-Q.scala --conf "spark.driver.args=$tweets,$tweets,$User,$Tweet,$TweetIDs,$HashtageIDs,$syn1,$syn2,$syn3" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp2M/Q1-1/Hybrid01-RW.scala --conf "spark.driver.args=$tweets,$TweetIDs,$HashtageIDs,$VV2,$syn1,$syn2,$syn3" 

#Q1-2
syn1="matrix-2380000-1-1.0.csv"
syn2="matrix-1000-2380000-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp2M/Q1-2/Hybrid01-Q.scala --conf "spark.driver.args=$tweets,$tweets,$User,$Tweet,$TweetIDs,$HashtageIDs,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp2M/Q1-2/Hybrid01-RW.scala --conf "spark.driver.args=$tweets,$TweetIDs,$HashtageIDs,$VV2,$syn1,$syn2" 

#Q1-3

syn1="matrix-2380000-1000-1.0.csv"
syn2="matrix-1000-1-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp2M/Q1-3/Hybrid01-Q.scala --conf "spark.driver.args=$tweets,$User,$Tweet,$TweetIDs,$HashtageIDs,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp2M/Q1-3/Hybrid01-RW.scala --conf "spark.driver.args=$TweetIDs,$HashtageIDs,$VV2,$syn1,$syn2" 

#Q1-4

syn1="matrix-1000-2380000-1.0.csv"
syn2="matrix-2380000-1000-1.0.csv"
syn3="matrix-1-1000-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")
syn3=$(cd $(dirname "$DataPath2$syn3"); pwd)/$(basename "$DataPath2$syn3")


spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp2M/Q1-4/Hybrid01-Q.scala --conf "spark.driver.args=$tweets,$User,$Tweet,$TweetIDs,$HashtageIDs,$syn1,$syn2,$syn3"  
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp2M/Q1-4/Hybrid01-RW.scala --conf "spark.driver.args=$tweets,$TweetIDs,$HashtageIDs,$VV2,$syn1,$syn2,$syn3" 

#Q1-5
syn1="matrix-2380000-1-1.0.csv"
syn2="matrix-12-1000-1.0.csv"
syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp2M/Q1-5/Hybrid01-Q.scala --conf "spark.driver.args=$tweets,$User,$Tweet,$TweetIDs,$HashtageIDs,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp2M/Q1-5/Hybrid01-RW.scala --conf "spark.driver.args=$tweets,$TweetIDs,$HashtageIDs,$VV2,$syn1,$syn2" 
 
#Q1-6
syn1="matrix-2380000-1-1.0.csv"
syn2="matrix-1000-1-1.0.csv"
syn3="matrix-12-2380000-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")
syn3=$(cd $(dirname "$DataPath2$syn3"); pwd)/$(basename "$DataPath2$syn3")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp2M/Q1-6/Hybrid01-Q.scala --conf "spark.driver.args=$tweets,$User,$Tweet,$TweetIDs,$HashtageIDs,$syn1,$syn2,$syn3" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp2M/Q1-6/Hybrid01-RW.scala --conf "spark.driver.args=$tweets,$TweetIDs,$HashtageIDs,$VV2,$syn1,$syn2,$syn3" 

#Q1-7
syn1="matrix-12-2380000-1.0.csv"
syn2="matrix-1000-1-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp2M/Q1-7/Hybrid01-Q.scala --conf "spark.driver.args=$tweets,$User,$Tweet,$TweetIDs,$HashtageIDs,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp2M/Q1-7/Hybrid01-RW.scala --conf "spark.driver.args=$tweets,$TweetIDs,$HashtageIDs,$VV2,$syn1,$syn2" 

#Q1-8

syn1="matrix-20000-20000-1.0.csv"
syn2="matrix-20000-1-1.0.csv"
syn3="matrix-12-20000-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")
syn3=$(cd $(dirname "$DataPath2$syn3"); pwd)/$(basename "$DataPath2$syn3")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp2M/Q1-8/Hybrid01-Q.scala --conf "spark.driver.args=$tweets,$User,$Tweet,$TweetIDs,$HashtageIDs,$syn1,$syn2,$syn3" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp2M/Q1-8/Hybrid01-RW.scala --conf "spark.driver.args=$tweets,$TweetIDs,$HashtageIDs,$VV2,$syn1,$syn2,$syn3" 

#Q1-9
syn1="matrix-1000-2380000-1.0.csv"
syn2="matrix-2380000-1000-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp2M/Q1-9/Hybrid01-Q.scala --conf "spark.driver.args=$tweets,$User,$Tweet,$TweetIDs,$HashtageIDs,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp2M/Q1-9/Hybrid01-RW.scala --conf "spark.driver.args=$tweets,$TweetIDs,$HashtageIDs,$VV2,$syn1,$syn2" 

#Q1-10
syn1="matrix-1000-2380000-1.0.csv"
syn2="matrix-2380000-1000-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp2M/Q1-10/Hybrid01-Q.scala --conf "spark.driver.args=$tweets,$User,$Tweet,$TweetIDs,$HashtageIDs,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp2M/Q1-10/Hybrid01-RW.scala --conf "spark.driver.args=$tweets,$TweetIDs,$HashtageIDs,$VV2,$syn1,$syn2" 
 
#1M
# 2M 
#Q1-1
syn1="matrix-1000-1-1.0.csv"
syn2="matrix-1380000-1-1.0.csv"
syn3="matrix-1000-1380000-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")
syn3=$(cd $(dirname "$DataPath2$syn3"); pwd)/$(basename "$DataPath2$syn3")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp1M/Q1-1/Hybrid01-Q.scala --conf "spark.driver.args=$tweets,$tweets,$User,$Tweet,$TweetIDs,$HashtageIDs,$syn1,$syn2,$syn3" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp1M/Q1-1/Hybrid01-RW.scala --conf "spark.driver.args=$tweets,$TweetIDs,$HashtageIDs,$VV2,$syn1,$syn2,$syn3" 

#Q1-2
syn1="matrix-1380000-1-1.0.csv"
syn2="matrix-1000-1380000-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp1M/Q1-2/Hybrid01-Q.scala --conf "spark.driver.args=$tweets,$tweets,$User,$Tweet,$TweetIDs,$HashtageIDs,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp1M/Q1-2/Hybrid01-RW.scala --conf "spark.driver.args=$tweets,$TweetIDs,$HashtageIDs,$VV2,$syn1,$syn2" 

#Q1-3

syn1="matrix-1380000-1000-1.0.csv"
syn2="matrix-1000-1-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp1M/Q1-3/Hybrid01-Q.scala --conf "spark.driver.args=$tweets,$User,$Tweet,$TweetIDs,$HashtageIDs,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp1M/Q1-3/Hybrid01-RW.scala --conf "spark.driver.args=$TweetIDs,$HashtageIDs,$VV2,$syn1,$syn2" 

#Q1-4

syn1="matrix-1000-1380000-1.0.csv"
syn2="matrix-1380000-1000-1.0.csv"
syn3="matrix-1-1000-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")
syn3=$(cd $(dirname "$DataPath2$syn3"); pwd)/$(basename "$DataPath2$syn3")


spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp1M/Q1-4/Hybrid01-Q.scala --conf "spark.driver.args=$tweets,$User,$Tweet,$TweetIDs,$HashtageIDs,$syn1,$syn2,$syn3"  
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp1M/Q1-4/Hybrid01-RW.scala --conf "spark.driver.args=$tweets,$TweetIDs,$HashtageIDs,$VV2,$syn1,$syn2,$syn3" 

#Q1-5
syn1="matrix-1380000-1-1.0.csv"
syn2="matrix-12-1000-1.0.csv"
syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp1M/Q1-5/Hybrid01-Q.scala --conf "spark.driver.args=$tweets,$User,$Tweet,$TweetIDs,$HashtageIDs,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp1M/Q1-5/Hybrid01-RW.scala --conf "spark.driver.args=$tweets,$TweetIDs,$HashtageIDs,$VV2,$syn1,$syn2" 
 
#Q1-6
syn1="matrix-1380000-1-1.0.csv"
syn2="matrix-1000-1-1.0.csv"
syn3="matrix-12-1380000-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")
syn3=$(cd $(dirname "$DataPath2$syn3"); pwd)/$(basename "$DataPath2$syn3")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp1M/Q1-6/Hybrid01-Q.scala --conf "spark.driver.args=$tweets,$User,$Tweet,$TweetIDs,$HashtageIDs,$syn1,$syn2,$syn3" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp1M/Q1-6/Hybrid01-RW.scala --conf "spark.driver.args=$tweets,$TweetIDs,$HashtageIDs,$VV2,$syn1,$syn2,$syn3" 

#Q1-7
syn1="matrix-12-1380000-1.0.csv"
syn2="matrix-1000-1-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp1M/Q1-7/Hybrid01-Q.scala --conf "spark.driver.args=$tweets,$User,$Tweet,$TweetIDs,$HashtageIDs,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp1M/Q1-7/Hybrid01-RW.scala --conf "spark.driver.args=$tweets,$TweetIDs,$HashtageIDs,$VV2,$syn1,$syn2" 

#Q1-8

syn1="matrix-20000-20000-1.0.csv"
syn2="matrix-20000-1-1.0.csv"
syn3="matrix-12-20000-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")
syn3=$(cd $(dirname "$DataPath2$syn3"); pwd)/$(basename "$DataPath2$syn3")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp1M/Q1-8/Hybrid01-Q.scala --conf "spark.driver.args=$tweets,$User,$Tweet,$TweetIDs,$HashtageIDs,$syn1,$syn2,$syn3" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp1M/Q1-8/Hybrid01-RW.scala --conf "spark.driver.args=$tweets,$TweetIDs,$HashtageIDs,$VV2,$syn1,$syn2,$syn3" 

#Q1-9
syn1="matrix-1000-1380000-1.0.csv"
syn2="matrix-1380000-1000-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp1M/Q1-9/Hybrid01-Q.scala --conf "spark.driver.args=$tweets,$User,$Tweet,$TweetIDs,$HashtageIDs,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp1M/Q1-9/Hybrid01-RW.scala --conf "spark.driver.args=$tweets,$TweetIDs,$HashtageIDs,$VV2,$syn1,$syn2" 

#Q1-10
syn1="matrix-1000-1380000-1.0.csv"
syn2="matrix-1380000-1000-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp1M/Q1-10/Hybrid01-Q.scala --conf "spark.driver.args=$tweets,$User,$Tweet,$TweetIDs,$HashtageIDs,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp1M/Q1-10/Hybrid01-RW.scala --conf "spark.driver.args=$tweets,$TweetIDs,$HashtageIDs,$VV2,$syn1,$syn2" 
 

#0.5M
#Q1-1
syn1="matrix-1000-1-1.0.csv"
syn2="matrix-538000-1-1.0.csv"
syn3="matrix-1000-538000-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")
syn3=$(cd $(dirname "$DataPath2$syn3"); pwd)/$(basename "$DataPath2$syn3")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp0.5M/Q1-1/Hybrid01-Q.scala --conf "spark.driver.args=$tweets,$tweets,$User,$Tweet,$TweetIDs,$HashtageIDs,$syn1,$syn2,$syn3" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp0.5M/Q1-1/Hybrid01-RW.scala --conf "spark.driver.args=$tweets,$TweetIDs,$HashtageIDs,$VV2,$syn1,$syn2,$syn3" 

#Q1-2
syn1="matrix-538000-1-1.0.csv"
syn2="matrix-1000-538000-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp0.5M/Q1-2/Hybrid01-Q.scala --conf "spark.driver.args=$tweets,$tweets,$User,$Tweet,$TweetIDs,$HashtageIDs,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp0.5M/Q1-2/Hybrid01-RW.scala --conf "spark.driver.args=$tweets,$TweetIDs,$HashtageIDs,$VV2,$syn1,$syn2" 

#Q1-3

syn1="matrix-538000-1000-1.0.csv"
syn2="matrix-1000-1-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp0.5M/Q1-3/Hybrid01-Q.scala --conf "spark.driver.args=$tweets,$User,$Tweet,$TweetIDs,$HashtageIDs,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp0.5M/Q1-3/Hybrid01-RW.scala --conf "spark.driver.args=$TweetIDs,$HashtageIDs,$VV2,$syn1,$syn2" 

#Q1-4

syn1="matrix-1000-538000-1.0.csv"
syn2="matrix-538000-1000-1.0.csv"
syn3="matrix-1-1000-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")
syn3=$(cd $(dirname "$DataPath2$syn3"); pwd)/$(basename "$DataPath2$syn3")


spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp0.5M/Q1-4/Hybrid01-Q.scala --conf "spark.driver.args=$tweets,$User,$Tweet,$TweetIDs,$HashtageIDs,$syn1,$syn2,$syn3"  
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp0.5M/Q1-4/Hybrid01-RW.scala --conf "spark.driver.args=$tweets,$TweetIDs,$HashtageIDs,$VV2,$syn1,$syn2,$syn3" 

#Q1-5
syn1="matrix-538000-1-1.0.csv"
syn2="matrix-12-1000-1.0.csv"
syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp0.5M/Q1-5/Hybrid01-Q.scala --conf "spark.driver.args=$tweets,$User,$Tweet,$TweetIDs,$HashtageIDs,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp0.5M/Q1-5/Hybrid01-RW.scala --conf "spark.driver.args=$tweets,$TweetIDs,$HashtageIDs,$VV2,$syn1,$syn2" 
 
#Q1-6
syn1="matrix-538000-1-1.0.csv"
syn2="matrix-1000-1-1.0.csv"
syn3="matrix-12-538000-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")
syn3=$(cd $(dirname "$DataPath2$syn3"); pwd)/$(basename "$DataPath2$syn3")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp0.5M/Q1-6/Hybrid01-Q.scala --conf "spark.driver.args=$tweets,$User,$Tweet,$TweetIDs,$HashtageIDs,$syn1,$syn2,$syn3" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp0.5M/Q1-6/Hybrid01-RW.scala --conf "spark.driver.args=$tweets,$TweetIDs,$HashtageIDs,$VV2,$syn1,$syn2,$syn3" 

#Q1-7
syn1="matrix-12-538000-1.0.csv"
syn2="matrix-1000-1-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp0.5M/Q1-7/Hybrid01-Q.scala --conf "spark.driver.args=$tweets,$User,$Tweet,$TweetIDs,$HashtageIDs,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp0.5M/Q1-7/Hybrid01-RW.scala --conf "spark.driver.args=$tweets,$TweetIDs,$HashtageIDs,$VV2,$syn1,$syn2" 

#Q1-8

syn1="matrix-20000-20000-1.0.csv"
syn2="matrix-20000-1-1.0.csv"
syn3="matrix-12-20000-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")
syn3=$(cd $(dirname "$DataPath2$syn3"); pwd)/$(basename "$DataPath2$syn3")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp0.5M/Q1-8/Hybrid01-Q.scala --conf "spark.driver.args=$tweets,$User,$Tweet,$TweetIDs,$HashtageIDs,$syn1,$syn2,$syn3" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp0.5M/Q1-8/Hybrid01-RW.scala --conf "spark.driver.args=$tweets,$TweetIDs,$HashtageIDs,$VV2,$syn1,$syn2,$syn3" 

#Q1-9
syn1="matrix-1000-538000-1.0.csv"
syn2="matrix-538000-1000-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp0.5M/Q1-9/Hybrid01-Q.scala --conf "spark.driver.args=$tweets,$User,$Tweet,$TweetIDs,$HashtageIDs,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp0.5M/Q1-9/Hybrid01-RW.scala --conf "spark.driver.args=$tweets,$TweetIDs,$HashtageIDs,$VV2,$syn1,$syn2" 

#Q1-10
syn1="matrix-1000-538000-1.0.csv"
syn2="matrix-538000-1000-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp0.5M/Q1-10/Hybrid01-Q.scala --conf "spark.driver.args=$tweets,$User,$Tweet,$TweetIDs,$HashtageIDs,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,../../../bin/spark-solr-3.9.0-SNAPSHOT-shaded.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp0.5M/Q1-10/Hybrid01-RW.scala --conf "spark.driver.args=$tweets,$TweetIDs,$HashtageIDs,$VV2,$syn1,$syn2" 
 