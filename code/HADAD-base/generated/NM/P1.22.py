import numpy as np
from numpy import genfromtxt
b_0=genfromtxt("syn5c.csv", delimiter=',')
b_1=genfromtxt("syn5d.csv", delimiter=',')
RW1=(np.trace((np.add((np.linalg.inv(b_1)),(np.linalg.inv(b_0))))))