with open(__file__) as fh: print fh.read()
import os
import sys
import datetime
import time
import numpy as np
import numpy.linalg as alg
import pandas as pd
from numpy import genfromtxt


def timeOp(string,cleanup=None):
    times = []
    time_stamp = datetime.datetime.fromtimestamp(
        time.time()).strftime('%Y%m%d%H%M%S')
    for ix in range(5):
        try:
            start = time.time()
            res = eval(string)
            print(res[1])
            stop = time.time()
            times.append(stop-start)
        except MemoryError:
            return np.nan
        if cleanup is not None:
            eval(cleanup)
    return times

def RW_Call(V,D,y): 
    return np.matmul(V,np.matmul(np.transpose(V),np.matmul(np.transpose(D),y)))

path = 'results.out'
colnames = ['Query','time1','time2','time3','time4','time5']
runTimes = pd.DataFrame(np.zeros((1,len(colnames))))
runTimes.columns = colnames

V1 = genfromtxt(str(sys.argv[1]), delimiter=',')
D = genfromtxt(str(sys.argv[2]), delimiter=',')
y = genfromtxt(str(sys.argv[3]), delimiter=',')

RW = 'RW_Call(V1,D,y)'
runTimes.ix[:,'Query'] = "P2.21RW"
runTimes.ix[:,1:] = timeOp(RW)
print(runTimes)
writeHeader = not os.path.exists(path)
runTimes.to_csv(path, index=False, header = writeHeader, mode = 'a')