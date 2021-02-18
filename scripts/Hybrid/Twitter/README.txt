Requirement
* Install solr-6.0.0
* Build spark-solr connector from the source: 
	- git clone https://github.com/lucidworks/spark-solr.git
	- cd spark-solr 
	- mvn clean package -DskipTests
	- Place target/spark-solr-3.9.0-SNAPSHOT-shaded.jar under HADAD/bin/

* Loading Text View in Solr 
	- ./solr start -e cloud
	- Create a collection "tweetText"
	- Place solrSchema/managed-schema under server/solr/configsets/basic_configs/conf/
	- Upload HADAD/data/real-data/V2TwitterText.csv to "tweetText" collection
		# curl --max-time 0 'http://localhost:8983/solr/tweetText/update' --data-binary @HADAD/data/real-data/V2TwitterText.csv -H 'Content-type:application/csv'