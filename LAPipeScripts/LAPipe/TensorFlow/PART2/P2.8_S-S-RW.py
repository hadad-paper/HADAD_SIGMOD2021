with open(__file__) as fh: print fh.read()
import os
import sys
import datetime
import time
import logging
import tensorflow as tf
import numpy as np
import numpy.linalg as alg
import pandas as pd
from numpy import genfromtxt


pathOut='results.out'
colnames = ['Query','time1','time2','time3','time4','time5','avg']
runTimes = pd.DataFrame(np.zeros((1,len(colnames))))
runTimes.columns = colnames
D = genfromtxt(str(sys.argv[1]), delimiter=',')
D = D.astype(np.float64)
C = genfromtxt(str(sys.argv[2]), delimiter=',')
C = C.astype(np.float64)


avg=0
def timeOp(string,cleanup=None):
    times = []
    time_stamp = datetime.datetime.fromtimestamp(
        time.time()).strftime('%Y%m%d%H%M%S')
    logname = 'log/P2.8-S-S-Q-RW-LogFile{}.log'.format(time_stamp)
    logging.basicConfig(filename=logname, level=logging.INFO)
    for ix in range(5):
        try:
            start = time.time()
            res = eval(string)
            stop = time.time()
            times.append(stop-start)
            logging.info('RAN: {} IN {} SECONDS'.format(
                 string.replace('\n',''), stop-start))
        except MemoryError:
            return np.nan
        if cleanup is not None:
            eval(cleanup)
    avg=(sum(times)/len(times))
    times.append(avg)
    return times

def RW_Call(Cdata,Ddata):
    G = tf.Graph()
    with G.as_default():
        D = tf.placeholder(tf.float64, shape=Ddata.shape)
        C = tf.placeholder(tf.float64, shape=Cdata.shape)
        pipe = tf.linalg.det(C)*tf.linalg.det(D)*tf.linalg.det(C)
        init = tf.global_variables_initializer()
        with tf.Session() as sess:
            sess.run(init)
            res = sess.run(pipe, feed_dict={D: Ddata,C: Cdata})
            logging.info('QueryResult: {}'.format(res))

    return res

RW = 'RW_Call(C,D)'
runTimes.ix[:,'Query'] = "P2.8(RW"+str(sys.argv[1])")"
runTimes.ix[:,1:] = timeOp(RW)
writeHeader = not os.path.exists(pathOut)
runTimes.to_csv(pathOut, index=False, header = writeHeader, mode = 'a')
