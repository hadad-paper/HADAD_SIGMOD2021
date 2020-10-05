import numpy as np
from numpy import genfromtxt
b_0=genfromtxt("syn5c.csv", delimiter=',')
b_1=genfromtxt("syn5d.csv", delimiter=',')
RW0=(np.linalg.inv((np.matmul((np.transpose(b_1)),b_0))))