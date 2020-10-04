# HADADA
<meta name="robots" content="noindex">
Hybrid complex analytics workloads typically include (i) data management tasks (joins, filters, etc. ), easily expressed using relational algebra (RA)-based languages, and (ii) complex analytics tasks (regressions , matrix decompositions, etc.), mostly expressed in linear algebra (LA) expressions. Such workloads are common in a number of areas, including scientific computing, web analytics, business recommendation, natural language processing, speech recognition. Existing solutions for evaluating hybrid complex analytics queries – ranging from LA-oriented systems, to relational systems (extended to handle LA operations), to hybrid systems – fail to provide a unified optimization framework for such a hybrid setting. These systems either optimize data management and complex analytics tasks separately, or exploit RA properties only while leaving LA-specific
 optimization opportunities unexplored. Finally, they are not able to exploit precomputed (materialized) results to avoid computing again (part of) a given mixed (LA and RA) computation.

We present HADAD, an extensible lightweight approach for optimizing hybrid complex analytics queries, based on a common abstraction that facilitates unified reasoning: a relational model endowed with integrity constraints, which can be used to express the properties of the two computation formalisms. Our approach enables exploration of LA properties and rewrites, as well as semantic query optimization. 

# Handy Links
* [Paper Extened Version ](#paper-extended-version)
* [Datasets/Views](#datasets)
* [Requirements and Code Build](#requirements-and-code-build)
* [Running Piplelines](#directory-structure)
* [Figures](#figures)

## Checking out HDADA
```
 $ git clone https://github.com/hadad-paper/HADAD_SIGMOD2021.git
```
## Paper Extended Version
You can find  the extended version of the paper **HADAD_EXTENDED.pdf**  with additional results under **extendedVersion** folder 
```bash
cd extendedVersion/
```
## Datasets 
We used a set of dense synthetic matrices and real-world sparse matrices. 

### Synthetic
```data/synthetic```  : this directory generates dense synthetic datasets. 
```bash
# Requirement: python2.7
$ cd data/synthetic 
$ chmod +x generate-synthetic.sh 
$./generate-synthetic.sh 
```
### Real-wrold
TOADD
### Views
```data/views```  : this directory generates the views. 
```bash
# Requirement: python2.7 
$ cd data/views
$ chmod +x generate.sh
$./generate.sh
```
##  Requirements and Code Build

###  Requirements
* A Unix-ish environment (Linux, OS X). **NOTE**: the code build was tested on OS X and CentOS7 Linux.
* Apache Maven 3.6.1 or newer ([Download and Intsall](https://maven.apache.org/))
* Java version 8
### Instructions for the code build 
The directory ``code`` contains three **main components**:
* HADAD-commons
* HADAD-PACB
* HADAD-base

Code build (skipping tests). This will autimatically build the source code and all related dependencies.   
```bash
$ cd code/
$ chmod +x build-skip-tests.sh 
$./build-skip-tests.sh 
```
Code build (enable tests)
```bash
$ cd code/
$ chmod +x build-skip-tests.sh 
$./build-tests.sh 
```

##  Running Pipelines

##  Figures 
For plotting the results,  the directory ``figures`` contains two folders ``LAPipe`` (to plot the results of LA-based pipelines experiments)  and ``LAViews`` ( to plot the results of LA-views based pipelines experiments). 
*  Requiremnts 
	* pyhton3.7 
	* Gnuplot  5.2 patchlevel 6
* LAPipe Example 
 ```bash
 cd figures/LAPipe/MNC/
 # PART1 LA pipelines results (results_1.csv)
 # This command reads results from results_1.csv file and generates a set of Gnuplot scripts.
 $ python3.7 generateGnuPlot.py results_1.csv 
 # This command runs the generated Gnuplot scripts and outputs the figures under /figures folder.
 $ chmod +x run.sh
 $ ./run.sh
 ```
 
* LAViews Example 
 ```bash
 cd figures/LAViews/Naive/
 # LA-views pipelines results (results_views.csv)
 $ python3.7 generateGnuPlot.py results_views.csv 
 $ chmod +x run.sh
 $ ./run.sh
 ```

