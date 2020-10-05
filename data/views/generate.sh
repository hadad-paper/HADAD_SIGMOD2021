#Datasets Path
DATA_PATH_SYN="../synthetic/"
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


taskset -c 0-23 python2.7 generate-views.py 1 $syn5
taskset -c 0-23 python2.7 generate-views.py 2 $syn5
taskset -c 0-23 python2.7 generate-views.py 3 $syn1 $syn2
taskset -c 0-23 python2.7 generate-views.py 5 $syn5 $syn5 A
taskset -c 0-23 python2.7 generate-views.py 5 $syn6 $syn6 B
taskset -c 0-23 python2.7 generate-views.py 6 $syn3 $syn3 A
taskset -c 0-23 python2.7 generate-views.py 6 $syn4 $syn4 B
taskset -c 0-23 python2.7 generate-views.py 9 $syn5 $syn5
taskset -c 0-23 python2.7 generate-views.py 10 $syn5 $syn5
taskset -c 0-23 python2.7 generate-views.py 11 $syn5 $syn5
taskset -c 0-23 python2.7 generate-views.py 12 $syn5 $syn5 A
taskset -c 0-23 python2.7 generate-views.py 12 $syn6 $syn6 B