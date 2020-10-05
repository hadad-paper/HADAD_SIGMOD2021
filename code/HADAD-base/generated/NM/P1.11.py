import numpy as np
from numpy import genfromtxt
b_1=genfromtxt("syn3a.csv", delimiter=',')
RW3=(np.transpose((sum((np.add(b_1,b_1))))))