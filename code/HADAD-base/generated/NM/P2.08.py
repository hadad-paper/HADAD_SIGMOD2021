import numpy as np
from numpy import genfromtxt
b_0=genfromtxt("syn5c.csv", delimiter=',')
b_1=genfromtxt("syn5d.csv", delimiter=',')
RW8=((np.linalg.det(b_0))np.multiply(np.linalg.det(b_1)))