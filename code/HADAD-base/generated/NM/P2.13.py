import numpy as np
from numpy import genfromtxt
b_0=genfromtxt("syn1.csv", delimiter=',')
b_1=genfromtxt("syn2.csv", delimiter=',')
RW0=(np.matmul((np.add(b_0,b_1)),b_0))