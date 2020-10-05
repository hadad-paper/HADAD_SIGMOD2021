import numpy as np
from numpy import genfromtxt
b_0=genfromtxt("syn5c.csv", delimiter=',')
b_2=genfromtxt("syn5e.csv", delimiter=',')
b_1=genfromtxt("syn5d.csv", delimiter=',')
RW3=(np.trace((np.add(b_2,(np.linalg.inv((np.add(b_1,b_0))))))))