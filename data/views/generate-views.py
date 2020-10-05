with open(__file__) as fh: print fh.read()
import os
import sys
import datetime
import time
import numpy as np
import numpy.linalg as alg
import pandas as pd
from numpy import genfromtxt

def Create_View1(D):
    res=alg.inv(D)
    results=pd.DataFrame(res)
    results.to_csv('V1.csv',index=False, header = False)
    results.to_csv('V7.csv',index=False, header = False)


def Create_View2(C):
    res=alg.inv(np.transpose(C))
    results=pd.DataFrame(res)
    results.to_csv('V2.csv',index=False, header = False)

def Create_View3(M,N):
    res=np.matmul(N,M)
    results=pd.DataFrame(res)
    results.to_csv('V3.csv',index=False, header = False)

def Create_View4(X,v):
    res=np.matmul(X,v)
    results=pd.DataFrame(res)
    results.to_csv('V4.csv',index=False, header = False)

def Create_View5(D,C,flag):
    res=np.matmul(D,C)
    results=pd.DataFrame(res)
    if flag is 'A':
        results.to_csv('V5A.csv',index=False, header = False)
    if flag is 'B':
        results.to_csv('V5B.csv',index=False, header = False)

def Create_View6(A,B,flag):
    res=A+B
    results=pd.DataFrame(res)
    if flag is 'A':
        results.to_csv('V6A.csv',index=False, header = False)
    if flag is 'B':
        results.to_csv('V6B.csv',index=False, header = False)

def Create_View9(C,D):
    res=alg.inv(C+D)
    results=pd.DataFrame(res)
    results.to_csv('V9.csv',index=False, header = False)

def Create_View10(C,D):
    res=alg.det(np.matmul(C,D))
    results = open("V10.csv", "w") 
    results.write(res)
    results.close()

def Create_View11(C,D):
    res=alg.det(np.matmul(D,C))
    results = open("V11.csv", "w") 
    results.write(res)
    results.close()


def Create_View12(C,D,flag):
    res=np.transpose(np.matmul(C,D))
    results=pd.DataFrame(res)
    if flag is'A':
        results.to_csv('V12A.csv',index=False, header = False)
    if flag is 'B':
        results.to_csv('V12B.csv',index=False, header = False)

viewNumber = int(sys.argv[1])

if viewNumber==1:
    D = genfromtxt(str(sys.argv[2]), delimiter=',')
    Query = 'Create_View1(D)'
    eval(Query)

if viewNumber==2:
    C = genfromtxt(str(sys.argv[2]), delimiter=',')
    Query = 'Create_View2(C)'
    eval(Query)

if viewNumber==3:
    M = genfromtxt(str(sys.argv[2]), delimiter=',')
    N = genfromtxt(str(sys.argv[3]), delimiter=',')
    Query = 'Create_View3(M,N)'
    eval(Query)

if viewNumber==4:
    X = genfromtxt(str(sys.argv[2]), delimiter=',')
    v = genfromtxt(str(sys.argv[3]), delimiter=',')
    Query = 'Create_View4(X,v)'
    eval(Query)

if viewNumber==5:
    D = genfromtxt(str(sys.argv[2]), delimiter=',')
    C = genfromtxt(str(sys.argv[3]), delimiter=',')
    flag = str(sys.argv[4])
    Query = 'Create_View5(D,C,flag)'
    eval(Query)

if viewNumber==6:
    A = genfromtxt(str(sys.argv[2]), delimiter=',')
    B = genfromtxt(str(sys.argv[3]), delimiter=',')
    flag = str(sys.argv[4])
    Query = 'Create_View6(A,B,flag)'
    eval(Query)

if viewNumber==9:
    D = genfromtxt(str(sys.argv[2]), delimiter=',')
    C = genfromtxt(str(sys.argv[3]), delimiter=',')
    Query = 'Create_View9(C,D)'
    eval(Query)

if viewNumber==10:
    D = genfromtxt(str(sys.argv[2]), delimiter=',')
    C = genfromtxt(str(sys.argv[3]), delimiter=',')
    Query = 'Create_View10(C,D)'
    eval(Query)

if viewNumber==11:
    D = genfromtxt(str(sys.argv[2]), delimiter=',')
    C = genfromtxt(str(sys.argv[3]), delimiter=',')
    Query = 'Create_View11(C,D)'
    eval(Query)

if viewNumber==12:
    D = genfromtxt(str(sys.argv[2]), delimiter=',')
    C = genfromtxt(str(sys.argv[3]), delimiter=',')
    flag = str(sys.argv[4])
    Query = 'Create_View12(C,D,flag)'
    eval(Query)