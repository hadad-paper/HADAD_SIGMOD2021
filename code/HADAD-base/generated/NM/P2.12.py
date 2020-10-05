import numpy as np
from numpy import genfromtxt
b_0=genfromtxt("syn3a.csv", delimiter=',')
b_1=genfromtxt("syn3b.csv", delimiter=',')
RW7=(sum((np.add(b_1,b_0))))