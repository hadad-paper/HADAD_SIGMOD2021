import numpy as np
from numpy import genfromtxt
b_0=genfromtxt("syn1.csv", delimiter=',')
b_1=genfromtxt("syn2.csv", delimiter=',')
RW1=(np.matmul(b_0,(np.add(b_1,b_0))))