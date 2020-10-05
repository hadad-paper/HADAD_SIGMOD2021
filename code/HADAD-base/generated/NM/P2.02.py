import numpy as np
from numpy import genfromtxt
b_0=genfromtxt("syn5c.csv", delimiter=',')
RW1=(1/((np.linalg.det(b_0))))