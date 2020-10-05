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
            stop = time.time()
            times.append(stop-start)
        except MemoryError:
            return np.nan
        if cleanup is not None:
            eval(cleanup)
    return times


def Query_Call(A,B):
    return 2*A+2*B

path = 'results.out'
colnames = ['Query','time1','time2','time3','time4','time5']
runTimes = pd.DataFrame(np.zeros((1,len(colnames))))
runTimes.columns = colnames


A  = genfromtxt(str(sys.argv[1]), delimiter=',')
B  = genfromtxt(str(sys.argv[2]), delimiter=',')

Query = 'Query_Call(A,B)'

runTimes.ix[:,'Query'] = "P2.4Q"
runTimes.ix[:,1:] = timeOp(Query)
writeHeader = not os.path.exists(path)
runTimes.to_csv(path, index=False, header = writeHeader, mode = 'a')