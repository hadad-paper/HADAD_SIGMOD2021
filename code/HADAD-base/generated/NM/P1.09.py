import numpy as np
from numpy import genfromtxt
b_0=genfromtxt("syn5d.csv", delimiter=',')
RW1=(np.linalg.det(b_0))