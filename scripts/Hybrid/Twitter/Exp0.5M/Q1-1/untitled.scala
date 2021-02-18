val sqlContext = new org.apache.spark.sql.SQLContext(sc)


val df = spark.read.json(s"${tweets}")
df.createOrReplaceTempView("TweetJSON")
val SJDF = spark.sql("""SELECT id
                        FROM TweetJSON
                        WHERE text LIKE '%Election%'""")

SJDF.createOrReplaceTempView("SJDF")
spark.time(SJDF.count())

//Preprocessing M
val user = sqlContext.read.format("csv").option("header", "true").load(s"${User}");
user.createOrReplaceTempView("User")

val tweet = sqlContext.read.format("csv").option("header", "true").load(s"${Tweet}");
tweet.createOrReplaceTempView("TWeet")

val M = spark.sql("""SELECT * 
                     FROM User as U, TWeet as T 
                     WHERE  T.id = U.id""")
val M2 = M.drop("id")
println(M2.count())
constructMatirx (M2,"M.csv");


//Preprocessing  (N)
val tweetIDs = sqlContext.read.format("csv").option("header", "true").load(s"${TweetIDs}");
tweetIDs.createOrReplaceTempView("TweetIDs")

val hashtageIDs = sqlContext.read.format("csv").option("header", "true").load(s"${HashtageIDs}");
hashtageIDs.createOrReplaceTempView("HashtageIDs")

//Explode Hashtags
val Hashtags = spark.sql("""SELECT explode(entities.hashtags.text) as hashtag , id
                            FROM TweetJSON 
                            where entities.hashtags is not null""")

Hashtags.createOrReplaceTempView("Hashtags")

spark.time(Hashtags.count())
val  results = spark.sql("""SELECT t2.idIn, hID.id, t1.filter_level  
                            FROM TweetJSON as t1, TweetIDs as t2, HashtageIDs as hID,
                                 Hashtags as h, SJDF as SD
                            WHERE t1.id=t2.id  AND
                                  t1.id = h.id AND
                                  SD.id = t2.idIn AND
                                  hID.hashtag = h.hashtag AND
                                  t1.place.country_code ='US' AND 
                                  t2.idIn <=538000 AND
                                  hID.id <=1000
                        """)
val results2 = results.dropDuplicates();
constructSparseMatirx (538000,1000,results2,"N.mtx");