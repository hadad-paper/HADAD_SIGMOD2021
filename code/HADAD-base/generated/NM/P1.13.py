import numpy as np
from numpy import genfromtxt
b_0=genfromtxt("syn3a.csv", delimiter=',')
b_1=genfromtxt("syn3b.csv", delimiter=',')
RW3=((sum(b_1))+(sum(b_0)))