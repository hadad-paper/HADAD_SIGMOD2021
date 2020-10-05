import numpy as np
from numpy import genfromtxt
b_0=genfromtxt("syn5c.csv", delimiter=',')
b_1=genfromtxt("syn5d.csv", delimiter=',')
RW3=(np.transpose((np.matmul((np.linalg.inv(b_1)),b_0))))