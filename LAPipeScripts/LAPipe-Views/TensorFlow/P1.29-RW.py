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


pathOut   = 'results.out'
colnames = ['Query','time1','time2','time3','time4','time5','avg']
runTimes = pd.DataFrame(np.zeros((1,len(colnames))))
runTimes.columns = colnames

C = genfromtxt(str(sys.argv[1]), delimiter=',')
C = C.astype(np.float64)
V5 = genfromtxt(str(sys.argv[2]), delimiter=',')
V5 = V5.astype(np.float64)


avg=0
def timeOp(string,cleanup=None):
    times = []
    time_stamp = datetime.datetime.fromtimestamp(
        time.time()).strftime('%Y%m%d%H%M%S')
    logname = 'log/P1.29LogFile{}.log'.format(time_stamp)
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

def Query_Call(Ddata,Cdata):
    G = tf.Graph()
    with G.as_default():
        C = tf.placeholder(tf.float64, shape=Cdata.shape)
        D = tf.placeholder(tf.float64, shape=Ddata.shape)
        pipe =tf.matmul(tf.matmul(tf.matmul(tf.matmul(tf.matmul(D,C),C),C)),C)
        init = tf.global_variables_initializer()
        with tf.Session() as sess:
            sess.run(init)
            res = sess.run(pipe, feed_dict={D: Ddata, C: Cdata})
            logging.info('QueryResult: {}'.format(pd.DataFrame(res).at[0,1]))

    return res


def RW_Call(Vdata,Cdata):
    G = tf.Graph()
    with G.as_default():
        V = tf.placeholder(tf.float64, shape=Vdata.shape)
        C = tf.placeholder(tf.float64, shape=Cdata.shape)
        pipe =tf.matmul(tf.matmul(tf.matmul(V,C),C))
        init = tf.global_variables_initializer()
        with tf.Session() as sess:
            sess.run(init)
            res = sess.run(pipe, feed_dict={V: Vdata, C: Cdata})
            logging.info('RWResult: {}'.format(pd.DataFrame(res).at[0,1]))

    return res



RW = 'RW_Call(V5,C)'
runTimes.ix[:,'Query'] = "P1.29(RW"+str(sys.argv[1])+")"
runTimes.ix[:,1:] = timeOp(Query)
writeHeader = not os.path.exists(pathOut)
runTimes.to_csv(pathOut, index=False, header = writeHeader, mode = 'a')
