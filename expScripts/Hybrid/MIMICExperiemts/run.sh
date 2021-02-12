DataPath1="../../../../../data/real-data/"
DataPath2="../../../../../data/synthetic/"
patients="patients_numeric.csv"
admissions="admission_numeric.csv"
services="services.csv"
callouts="callout_numeric.csv"

patients=$(cd $(dirname "$DataPath1$patients"); pwd)/$(basename "$DataPath1$patients")
admissions=$(cd $(dirname "$DataPath1$admissions"); pwd)/$(basename "$DataPath1$admissions")
services=$(cd $(dirname "$DataPath1$services"); pwd)/$(basename "$DataPath1$services")
callouts=$(cd $(dirname "$DataPath1$callouts"); pwd)/$(basename "$DataPath1$callouts")


# 4K 
#Q1-1
syn1="matrix-35000-1-1.0.csv"
syn2="matrix-48612-1-1.0.csv"
syn3="matrix-35000-48612-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")
syn3=$(cd $(dirname "$DataPath2$syn3"); pwd)/$(basename "$DataPath2$syn3")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp40K/Q1-1/Hybrid01-Q.scala --conf "spark.driver.args=$patients,$admissions,$services,$callouts,$syn1,$syn2,$syn3" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp40K/Q1-1/Hybrid01-RW.scala --conf "spark.driver.args=$services,$callouts,$syn1,$syn2,$syn3" 

#Q1-2
syn1="matrix-48612-1-1.0.csv"
syn2="matrix-35000-48612-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp40K/Q1-2/Hybrid01-Q.scala --conf "spark.driver.args=$patients,$admissions,$services,$callouts,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp40K/Q1-2/Hybrid01-RW.scala --conf "spark.driver.args=$services,$callouts,$syn1,$syn2" 

#Q1-3

syn1="matrix-48612-35000-1.0.csv"
syn2="matrix-35000-1-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp40K/Q1-3/Hybrid01-Q.scala --conf "spark.driver.args=$patients,$admissions,$services,$callouts,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp40K/Q1-3/Hybrid01-RW.scala --conf "spark.driver.args=$services,$callouts,$syn1,$syn2" 

#Q1-4

syn1="matrix-35000-48612-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp40K/Q1-4/Hybrid01-Q.scala --conf "spark.driver.args=$patients,$admissions,$services,$callouts,$syn1"  
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp40K/Q1-4/Hybrid01-RW.scala --conf "spark.driver.args=$services,$callouts,$syn1" 

#Q1-5
syn1="matrix-48612-1-1.0.csv"
syn2="matrix-82-35000-1.0.csv"
syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp40K/Q1-5/Hybrid01-Q.scala --conf "spark.driver.args=$patients,$admissions,$services,$callouts,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp40K/Q1-5/Hybrid01-RW.scala --conf "spark.driver.args=$services,$callouts,$syn1,$syn2" 
 
#Q1-6
syn1="matrix-48612-1-1.0.csv"
syn2="matrix-35000-1-1.0.csv"
syn3="matrix-82-48612-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")
syn3=$(cd $(dirname "$DataPath2$syn3"); pwd)/$(basename "$DataPath2$syn3")


spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp40K/Q1-6/Hybrid01-Q.scala --conf "spark.driver.args=$patients,$admissions,$services,$callouts,$syn1,$syn2,$syn3" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp40K/Q1-6/Hybrid01-RW.scala --conf "spark.driver.args=$services,$callouts,$syn1,$syn2,$syn3" 

#Q1-7
syn1="matrix-82-48612-1.0.csv"
syn2="matrix-35000-1-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp40K/Q1-7/Hybrid01-Q.scala --conf "spark.driver.args=$patients,$admissions,$services,$callouts,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp40K/Q1-7/Hybrid01-RW.scala --conf "spark.driver.args=$services,$callouts,$syn1,$syn2" 

#Q1-8

syn1="matrix-82-35000-1.0.csv"
syn2="matrix-35000-48612-1.0.csv"
syn3="matrix-35000-1-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")
syn3=$(cd $(dirname "$DataPath2$syn3"); pwd)/$(basename "$DataPath2$syn3")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp40K/Q1-8/Hybrid01-Q.scala --conf "spark.driver.args=$patients,$admissions,$services,$callouts,$syn1,$syn2,$syn3" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp40K/Q1-8/Hybrid01-RW.scala --conf "spark.driver.args=$services,$callouts,$syn1,$syn2,$syn3" 

#Q1-9
syn1="matrix-35000-48612-1.0.csv"
syn2="matrix-48612-35000-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp40K/Q1-9/Hybrid01-Q.scala --conf "spark.driver.args=$patients,$admissions,$services,$callouts,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp40K/Q1-9/Hybrid01-RW.scala --conf "spark.driver.args=$services,$callouts,$syn1,$syn2" 

#Q1-10
syn1="matrix-35000-48612-1.0.csv"
syn2="matrix-48612-35000-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp40K/Q1-10/Hybrid01-Q.scala --conf "spark.driver.args=$patients,$admissions,$services,$callouts,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp40K/Q1-10/Hybrid01-RW.scala --conf "spark.driver.args=$services,$callouts,$syn1,$syn2" 
 
#20 k
#Q1-1
syn1="matrix-35000-1-1.0.csv"
syn2="matrix-28000-1-1.0.csv"
syn3="matrix-35000-48612-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")
syn3=$(cd $(dirname "$DataPath2$syn3"); pwd)/$(basename "$DataPath2$syn3")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp20K/Q1-1/Hybrid01-Q.scala --conf "spark.driver.args=$patients,$admissions,$services,$callouts,$syn1,$syn2,$syn3" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp20K/Q1-1/Hybrid01-RW.scala --conf "spark.driver.args=$services,$callouts,$syn1,$syn2,$syn3" 

#Q1-2
syn1="matrix-28000-1-1.0.csv"
syn2="matrix-35000-48612-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp20K/Q1-2/Hybrid01-Q.scala --conf "spark.driver.args=$patients,$admissions,$services,$callouts,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp20K/Q1-2/Hybrid01-RW.scala --conf "spark.driver.args=$services,$callouts,$syn1,$syn2" 

#Q1-3

syn1="matrix-28000-35000-1.0.csv"
syn2="matrix-35000-1-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp20K/Q1-3/Hybrid01-Q.scala --conf "spark.driver.args=$patients,$admissions,$services,$callouts,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp20K/Q1-3/Hybrid01-RW.scala --conf "spark.driver.args=$services,$callouts,$syn1,$syn2" 

#Q1-4

syn1="matrix-35000-48612-1.0.csv"
syn2="matrix-28000-35000-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp20K/Q1-4/Hybrid01-Q.scala --conf "spark.driver.args=$patients,$admissions,$services,$callouts,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp20K/Q1-4/Hybrid01-RW.scala --conf "spark.driver.args=$services,$callouts,$syn1,$syn2" 

#Q1-5
syn1="matrix-28000-1-1.0.csv"
syn2="matrix-82-35000-1.0.csv"
syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp20K/Q1-5/Hybrid01-Q.scala --conf "spark.driver.args=$patients,$admissions,$services,$callouts,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp20K/Q1-5/Hybrid01-RW.scala --conf "spark.driver.args=$services,$callouts,$syn1,$syn2" 

#Q1-6
syn1="matrix-28000-1-1.0.csv"
syn2="matrix-35000-1-1.0.csv"
syn3="matrix-82-28000-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")
syn3=$(cd $(dirname "$DataPath2$syn3"); pwd)/$(basename "$DataPath2$syn3")


spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp20K/Q1-6/Hybrid01-Q.scala --conf "spark.driver.args=$patients,$admissions,$services,$callouts,$syn1,$syn2,$syn3" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp20K/Q1-6/Hybrid01-RW.scala --conf "spark.driver.args=$services,$callouts,$syn1,$syn2,$syn3" 

#Q1-7
syn1="matrix-82-28000-1.0.csv"
syn2="matrix-35000-1-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp20K/Q1-7/Hybrid01-Q.scala --conf "spark.driver.args=$patients,$admissions,$services,$callouts,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp20K/Q1-7/Hybrid01-RW.scala --conf "spark.driver.args=$services,$callouts,$syn1,$syn2" 

#Q1-8

syn1="matrix-82-35000-1.0.csv"
syn2="matrix-35000-28000-1.0.csv"
syn3="matrix-35000-1-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")
syn3=$(cd $(dirname "$DataPath2$syn3"); pwd)/$(basename "$DataPath2$syn3")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp20K/Q1-8/Hybrid01-Q.scala --conf "spark.driver.args=$patients,$admissions,$services,$callouts,$syn1,$syn2,$syn3" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp20K/Q1-8/Hybrid01-RW.scala --conf "spark.driver.args=$services,$callouts,$syn1,$syn2,$syn3" 

#Q1-9
syn1="matrix-35000-28000-1.0.csv"
syn2="matrix-28000-35000-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp20K/Q1-9/Hybrid01-Q.scala --conf "spark.driver.args=$patients,$admissions,$services,$callouts,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp20K/Q1-9/Hybrid01-RW.scala --conf "spark.driver.args=$services,$callouts,$syn1,$syn2" 

#Q1-10
syn1="matrix-35000-28000-1.0.csv"
syn2="matrix-28000-35000-1.0.csv"

syn1=$(cd $(dirname "$DataPath2$syn1"); pwd)/$(basename "$DataPath2$syn1")
syn2=$(cd $(dirname "$DataPath2$syn2"); pwd)/$(basename "$DataPath2$syn2")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp20K/Q1-10/Hybrid01-Q.scala --conf "spark.driver.args=$patients,$admissions,$services,$callouts,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp20K/Q1-10/Hybrid01-RW.scala --conf "spark.driver.args=$services,$callouts,$syn1,$syn2" 



#10 k
#Q1-1
syn1="matrix-35000-1-1.0.csv"
syn2="matrix-11000-1-1.0.csv"
syn3="matrix-35000-48612-1.0.csv"

syn1=$(cd $(dirname "$DataPath$syn1"); pwd)/$(basename "$DataPath$syn1")
syn2=$(cd $(dirname "$DataPath$syn2"); pwd)/$(basename "$DataPath$syn2")
syn3=$(cd $(dirname "$DataPath$syn3"); pwd)/$(basename "$DataPath$syn3")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp10K/Q1-1/Hybrid01-Q.scala --conf "spark.driver.args=$patients,$admissions,$services,$callouts,$syn1,$syn2,$syn3" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp10K/Q1-1/Hybrid01-RW.scala --conf "spark.driver.args=$services,$callouts,$syn1,$syn2,$syn3" 

#Q1-2
syn1="matrix-11000-1-1.0.csv"
syn2="matrix-35000-48612-1.0.csv"

syn1=$(cd $(dirname "$DataPath$syn1"); pwd)/$(basename "$DataPath$syn1")
syn2=$(cd $(dirname "$DataPath$syn2"); pwd)/$(basename "$DataPath$syn2")
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp10K/Q1-2/Hybrid01-Q.scala --conf "spark.driver.args=$patients,$admissions,$services,$callouts,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp10K/Q1-2/Hybrid01-RW.scala --conf "spark.driver.args=$services,$callouts,$syn1,$syn2" 

#Q1-3

syn1="matrix-11000-35000-1.0.csv"
syn2="matrix-35000-1-1.0.csv"

syn1=$(cd $(dirname "$DataPath$syn1"); pwd)/$(basename "$DataPath$syn1")
syn2=$(cd $(dirname "$DataPath$syn2"); pwd)/$(basename "$DataPath$syn2")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp10K/Q1-3/Hybrid01-Q.scala --conf "spark.driver.args=$patients,$admissions,$services,$callouts,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24"  --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp10K/Q1-3/Hybrid01-RW.scala --conf "spark.driver.args=$services,$callouts,$syn1,$syn2" 

#Q1-4

syn1="matrix-35000-48612-1.0.csv"
syn2="matrix-11000-35000-1.0.csv"

syn1=$(cd $(dirname "$DataPath$syn1"); pwd)/$(basename "$DataPath$syn1")
syn2=$(cd $(dirname "$DataPath$syn2"); pwd)/$(basename "$DataPath$syn2")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp10K/Q1-4/Hybrid01-Q.scala --conf "spark.driver.args=$patients,$admissions,$services,$callouts,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp10K/Q1-4/Hybrid01-RW.scala --conf "spark.driver.args=$services,$callouts,$syn1,$syn2" 

#Q1-5
syn1="matrix-11000-1-1.0.csv"
syn2="matrix-82-35000-1.0.csv"
syn1=$(cd $(dirname "$DataPath$syn1"); pwd)/$(basename "$DataPath$syn1")
syn2=$(cd $(dirname "$DataPath$syn2"); pwd)/$(basename "$DataPath$syn2")
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp10K/Q1-5/Hybrid01-Q.scala --conf "spark.driver.args=$patients,$admissions,$services,$callouts,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp10K/Q1-5/Hybrid01-RW.scala --conf "spark.driver.args=$services,$callouts,$syn1,$syn2" 

#Q1-6
syn1="matrix-11000-1-1.0.csv"
syn2="matrix-35000-1-1.0.csv"
syn3="matrix-82-11000-1.0.csv"

syn1=$(cd $(dirname "$DataPath$syn1"); pwd)/$(basename "$DataPath$syn1")
syn2=$(cd $(dirname "$DataPath$syn2"); pwd)/$(basename "$DataPath$syn2")
syn3=$(cd $(dirname "$DataPath$syn3"); pwd)/$(basename "$DataPath$syn3")


spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp10K/Q1-6/Hybrid01-Q.scala --conf "spark.driver.args=$patients,$admissions,$services,$callouts,$syn1,$syn2,$syn3" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp10K/Q1-6/Hybrid01-RW.scala --conf "spark.driver.args=$services,$callouts,$syn1,$syn2,$syn3" 

#Q1-7
syn1="matrix-82-11000-1.0.csv"
syn2="matrix-35000-1-1.0.csv"

syn1=$(cd $(dirname "$DataPath$syn1"); pwd)/$(basename "$DataPath$syn1")
syn2=$(cd $(dirname "$DataPath$syn2"); pwd)/$(basename "$DataPath$syn2")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp10K/Q1-7/Hybrid01-Q.scala --conf "spark.driver.args=$patients,$admissions,$services,$callouts,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp10K/Q1-7/Hybrid01-RW.scala --conf "spark.driver.args=$services,$callouts,$syn1,$syn2" 

#Q1-8

syn1="matrix-82-35000-1.0.csv"
syn2="matrix-35000-11000-1.0.csv"
syn3="matrix-35000-1-1.0.csv"

syn1=$(cd $(dirname "$DataPath$syn1"); pwd)/$(basename "$DataPath$syn1")
syn2=$(cd $(dirname "$DataPath$syn2"); pwd)/$(basename "$DataPath$syn2")
syn3=$(cd $(dirname "$DataPath$syn3"); pwd)/$(basename "$DataPath$syn3")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp10K/Q1-8/Hybrid01-Q.scala --conf "spark.driver.args=$patients,$admissions,$services,$callouts,$syn1,$syn2,$syn3" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp10K/Q1-8/Hybrid01-RW.scala --conf "spark.driver.args=$services,$callouts,$syn1,$syn2,$syn3" 
 
#Q1-9
syn1="matrix-35000-11000-1.0.csv"
syn2="matrix-11000-35000-1.0.csv"

syn1=$(cd $(dirname "$DataPath$syn1"); pwd)/$(basename "$DataPath$syn1")
syn2=$(cd $(dirname "$DataPath$syn2"); pwd)/$(basename "$DataPath$syn2")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp10K/Q1-9/Hybrid01-Q.scala --conf "spark.driver.args=$patients,$admissions,$services,$callouts,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp10K/Q1-9/Hybrid01-RW.scala --conf "spark.driver.args=$services,$callouts,$syn1,$syn2"

# #Q1-10
syn1="matrix-35000-11000-1.0.csv"
syn2="matrix-11000-35000-1.0.csv"

syn1=$(cd $(dirname "$DataPath$syn1"); pwd)/$(basename "$DataPath$syn1")
syn2=$(cd $(dirname "$DataPath$syn2"); pwd)/$(basename "$DataPath$syn2")

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp10K/Q1-10/Hybrid01-Q.scala --conf "spark.driver.args=$patients,$admissions,$services,$callouts,$syn1,$syn2" 
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --conf "spark.local.dir=/local/ralotaib/estocada-LA/SingleNode-Synthetic/HybridExperiments" --jars ../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar  --master local[15] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i Exp10K/Q1-10/Hybrid01-RW.scala --conf "spark.driver.args=$services,$callouts,$syn1,$syn2" 
