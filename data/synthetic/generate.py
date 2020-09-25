#script for generating sparse and dense matrices 
import argparse
import scipy.sparse as sparse
import scipy.stats as stats
import numpy as np
import os.path
from os import path
import csv
import sys

#Arguments parser
parser = argparse.ArgumentParser()
parser.add_argument(
    '--nrow', default=100, type=str,
    help='Matirx rows number (default number is 100)')
parser.add_argument(
    '--ncol', default=100, type=str,
    help='Matirx columns number (default number is 100)')
parser.add_argument(
    '--sparsity', default="25%", type=str,
    help='Sparsity (default sparse matrix with density 0.25)')

#Create a sparse matrix with size (nrow x ncol), and density (sdensity)
def generateMatrix (sdensity,nrow,ncol):
    np.random.seed(42)
    sparse_matirx = sparse.random(nrow, ncol, sdensity)
    f = open('matrix-' + str(nrow) + '-' + str(ncol) + '-'+ str(sdensity)+'.csv', 'w')
    writer = csv.writer(f)
    writer.writerows(np.round(sparse_matirx.toarray(),4))

# make sure git ignores the csv file
with open('.gitignore', 'w') as fh:
    fh.write('*.csv')

args = parser.parse_args()
generateMatrix((float(args.sparsity.strip('%'))/100.0),int(args.nrow),int(args.ncol))
