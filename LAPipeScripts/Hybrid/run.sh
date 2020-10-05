#Datasets Path
DATA_PATH_SYN="../../../../data/synthetic/"
DATA_PATH_REAL="../../../../data/real-data/"
#Synthetic

syn8="matrix-50000-1-1.0.csv"
syn9="matrix-100000-1-1.0.csv"

#Absolute Paths (Syn)
syn8=$(cd $(dirname "$DATA_PATH_SYN$syn8"); pwd)/$(basename "$DATA_PATH_SYN$syn8")
syn9=$(cd $(dirname "$DATA_PATH_SYN$syn9"); pwd)/$(basename "$DATA_PATH_SYN$syn9")

#JSON Data
JSONData="AmazonProcessed.json"
JSONData=$(cd $(dirname "$DATA_PATH_REAL$JSONData"); pwd)/$(basename "$DATA_PATH_REAL$JSONData")

#CSV Data
CSVData ="NetFlixProcessed.csv"
CSVData=$(cd $(dirname "$DATA_PATH_REAL$CSVData"); pwd)/$(basename "$DATA_PATH_REAL$CSVData")


#Views
V1Amazon="V1AmazonRelational.csv"
V1Amazon=$(cd $(dirname "$DATA_PATH_REAL$V1Amazon"); pwd)/$(basename "$DATA_PATH_REAL$V1Amazon")

# Load in Solr V2AmazonText 
# Requirements:
# Install solr-6.0.0
# Create a collection "amazonBookReview"
#  ./solr start -e cloud
# Upload "V2AmazonText.csv" to "amazonBookReview" collection
# curl --max-time 0 'http://localhost:8983/solr/amazonBookReview/update' --data-binary @../../data/real-data/V2AmazonText.csv -H 'Content-type:application/csv'
# spark-solr-3.9.0-SNAPSHOT-shaded.jar is in provided google drive link

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,spark-solr-3.9.0-SNAPSHOT-shaded.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i HybridAmazon.scala --conf "spark.driver.args=$JSONData,$syn9,$syn8"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,spark-solr-3.9.0-SNAPSHOT-shaded.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i HybridAmazonRW.scala --conf "spark.driver.args=$V1Amazon,$syn9,$syn8"

spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,spark-solr-3.9.0-SNAPSHOT-shaded.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i HybridNetFlix.scala --conf "spark.driver.args=$CSVData,$syn9,$syn8"
spark-shell --conf "spark.driver.memory=115g" --conf "spark.executor.cores=24" --jars ../../../../bin/systemml-1.2.0-bin/lib/systemml-1.2.0.jar,spark-solr-3.9.0-SNAPSHOT-shaded.jar --master local[*] --conf "spark.executor.heartbeatInterval=3600s" --conf "spark.network.timeout=4000s"  -i HybridNetFlixRW.scala --conf "spark.driver.args=$CSVData,$syn9,$syn8"

