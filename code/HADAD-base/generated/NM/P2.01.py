import numpy as np
from numpy import genfromtxt
b_0=genfromtxt("syn5c.csv", delimiter=',')
b_1=genfromtxt("syn5d.csv", delimiter=',')
RW3=((np.trace(b_0))+(np.trace(b_1)))