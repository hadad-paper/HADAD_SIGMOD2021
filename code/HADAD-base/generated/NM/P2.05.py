import numpy as np
from numpy import genfromtxt
b_0=genfromtxt("syn5c.csv", delimiter=',')
b_1=genfromtxt("syn5d.csv", delimiter=',')
RW3=(1/((np.linalg.det((np.add(b_1,b_0))))))