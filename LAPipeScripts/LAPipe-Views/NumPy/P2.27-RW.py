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
            print(res[1,1])
            stop = time.time()
            times.append(stop-start)
        except MemoryError:
            return np.nan
        if cleanup is not None:
            eval(cleanup)
    return times

def RW_Call(V1,V2): 
    return np.matmul(np.transpose(V1),V2)

path = 'results.out'
colnames = ['Query','time1','time2','time3','time4','time5']
runTimes = pd.DataFrame(np.zeros((1,len(colnames))))
runTimes.columns = colnames

V9 = genfromtxt(str(sys.argv[1]), delimiter=',')
V5 = genfromtxt(str(sys.argv[2]), delimiter=',')


RW = 'RW_Call(V9,V5)'
runTimes.ix[:,'Query'] = "P2.27RW"
runTimes.ix[:,1:] = timeOp(RW)
print(runTimes)
writeHeader = not os.path.exists(path)
runTimes.to_csv(path, index=False, header = writeHeader, mode = 'a')
