#Commons Build
cd HADAD-commons/
cd conjunctivequery/
mvn clean install -DskipTests
cd ..
cd commons-db/
mvn clean install -DskipTests
cd ..
cd commons-miscellaneous1/
mvn clean install -DskipTests
cd ..
cd relationalschema/
mvn clean install -DskipTests
cd ..
cd commons-db-ontosql/
mvn clean install -DskipTests
cd ../..

#HADAD-PACB
cd HADAD-PACB/
cd Chase/
mvn clean install -DskipTests
cd ..
cd Backchase/
mvn clean install -DskipTests
cd ..
cd CB/
mvn clean install -DskipTests
cd ../..

#HADAD-base
cd HADAD-base/
mvn clean install -DskipTests
cd ..
