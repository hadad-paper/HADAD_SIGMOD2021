import numpy as np
from numpy import genfromtxt
b_0=genfromtxt("syn5c.csv", delimiter=',')
RW0=(np.transpose((np.linalg.inv(b_0))))