#script for plotting figures
import argparse
import scipy.sparse as sparse
import scipy.stats as stats
import numpy as np
import os.path
from os import path
import csv
import sys

#generate plot files
def generatePlotFile (fName,output,xtics,maxExec,title, qData, RWData):
    gnuFile = open(fName,'w')
    gnuFile.write("set terminal pdf\n")
    gnuFile.write("set output \""+"figures/"+output+"\"\n")
    gnuFile.write("set size square 1.0,1.0"+"\n")
    gnuFile.write("set xtics ("+ xtics+ ")"+" font \", 16\"\n")
    gnuFile.write("set yrange [0.001:"+str(maxExec)+"]\n")
    gnuFile.write("set logscale y 10\n")
    gnuFile.write("set style fill solid border -1\n")
    gnuFile.write("set key off\n")
    gnuFile.write("set grid\n")
    gnuFile.write("set title \""+title +"\" font \", 18\"\n")
    gnuFile.write("num_of_ksptypes=2\n")
    gnuFile.write("set boxwidth 0.4/num_of_ksptypes\n")
    gnuFile.write("dx=0.5/num_of_ksptypes\n")
    gnuFile.write("offset=-0.1\n")
    gnuFile.write("set ytics font \", 14\"\n")
    gnuFile.write("set ylabel \"Total Execution Time (logscale) -[s]\" font \",16\"\n")
    gnuFile.write("plot \'gnudata/"+qData+"\'" +" using ($1+offset):2 title \"Q_{exec}\" linecolor rgb \"#0000CD\" with boxes fs pattern 18, \
         \'gnudata/"+RWData+"\' using ($1+offset+dx):($2+$3) title \"RW_{exec}\" linecolor rgb \"#A9A9A9\" with boxes fs pattern 19, \
         ''                   using ($1+offset+dx):3 title \"RW_{find}\" linecolor rgb \"#0000FF\" with boxes")

#generate Query and RW data files
def generateQRWDataFiles (row):
    #Query data file
    dataFileQ = open("gnudata/"+fName+'Q.dat', 'w')     
    sparseData = ["AS","AM","AL1","AL2","AL3","NS","NM","NL1","NL2","NL3"]
    res = any(ele in row[1] for ele in sparseData)
    dataFileQ.write("nr  \"Q_{exec}\"\n")
    if res: 
        for x in range(4,14):
            if x==4:
                dataFileQ.write("1  "+str(float(row[x]))+"\n")
            if x==6:
                dataFileQ.write("2  "+str(float(row[x]))+"\n") 
            if x==12:
                sparkNData = ["NS","NM","NL1","NL2"]
                sparkCase = any(ele in row[1] for ele in sparkNData)
                if not sparkCase:
                    dataFileQ.write("3  "+str(float(row[x]))+"\n")
    else:
        for x in range(4,14):
            if x==4:
                dataFileQ.write("1  "+str(float(row[x]))+"\n")
            if x==6:     
                dataFileQ.write("2  "+str(float(row[x]))+"\n")
            if x==8:
                dataFileQ.write("3  "+str(float(row[x]))+"\n") 
            if x==10:
                dataFileQ.write("4  "+str(float(row[x]))+"\n")
            if x==12:
                dataFileQ.write("5  "+str(float(row[x]))+"\n")  
    dataFileQ.close()

    #RW data file
    dataFileRW = open("gnudata/"+fName+'RW.dat', 'w') 
    dataFileRW.write("nr \"RW_{exec}\" \"RW_{find}\""+"\n")
    if res:
        for x in range(4,14):
            if x==5:
                dataFileRW.write("1  "+str(float(row[x]))+" "+str(float(row[14]))+"\n")
            if x==7:
                dataFileRW.write("2  "+str(float(row[x]))+" "+str(float(row[14]))+"\n")    
            if x==13:
                sparkNData = ["NS","NM","NL1","NL2"]
                sparkCase = any(ele in row[1] for ele in sparkNData)
                if not sparkCase:
                    SPSpipe = ["P1.12","P1.14","P1.25","P2.10","P2.12"]
                    SPSCase = any(ele in row[0] for ele in SPSpipe)
                    if not SPSCase: 
                        dataFileRW.write("3  "+str(float(row[x]))+" "+str(float(row[14]))+"\n")
                    else:
                        dataFileRW.write("3  "+str(float(row[x]))+" "+str(float(0.00))+"\n")

    else:   
        for x in range(4,14):
            if x==5:
                SMpipe = ["P1.9","P1.17","P2.2","P2.5","P2.6","P2.8","P2.16"]
                SMCase = any(ele in row[0] for ele in SMpipe)
                if SMCase:
                    dataFileRW.write("1  "+str(float(row[x]))+" "+str(0.00)+"\n")
                else:
                    dataFileRW.write("1  "+str(float(row[x]))+" "+str(float(row[14]))+"\n")
            if x==7:
                dataFileRW.write("2  "+str(float(row[x]))+" "+str(float(row[14]))+"\n")
            if x==9:
                dataFileRW.write("3  "+str(float(row[x]))+" "+str(float(row[14]))+"\n")
            if x==11: 
                TFpipe = ["P1.9","P1.17","P2.2","P2.5","P2.8","P2.10"]
                TFCase = any(ele in row[0] for ele in TFpipe)
                if TFCase:
                    dataFileRW.write("4  "+str(float(row[x]))+" "+str(0.00)+"\n")
                else:
                    dataFileRW.write("4  "+str(float(row[x]))+" "+str(float(row[14]))+"\n")
            if x==13:
                SDPDpipe = ["P1.12","P1.14","P2.10"]
                SPDCase = any(ele in row[0] for ele in SDPDpipe)
                if SPDCase: 
                    dataFileRW.write("5  "+str(float(row[x]))+" "+str(0.00)+"\n")
                else:
                    dataFileRW.write("5  "+str(float(row[x]))+" "+str(float(row[14]))+"\n")   
    dataFileRW.close()

plotCommands = open('run.sh', 'w') 
with open('results/'+str(sys.argv[1])) as csvfile:
    readCSV = csv.reader(csvfile, delimiter=',')
    next(readCSV, None)
    for row in readCSV:
        fName = row[0].replace('.','-')+row[1].split(':')[1]
        plotCommands.write('gnuplot' +' ' +fName+'.p'+'\n')
        #PlotFile
        title = row[1]
        if row[2]:
            title = title + ',' +row[2]
        if row[3]:
              title = title + ',' +row[3]
        generateQRWDataFiles(row)
        sparseData = ["AS","AM","AL1","AL2","AL3","NS","NM","NL1","NL2","NL3"]
        res = any(ele in row[1] for ele in sparseData)
        execs=[]
        execs.append(float(row[4]))
        execs.append(float(row[6]))
        execs.append(float(row[8]))
        execs.append(float(row[10]))
        execs.append(float(row[12]))
        maxExec = max(execs)
        if res:
            xticsp="\"SM\" 1, \"R\" 2, \"SP\" 3"
            sparkNData = ["NS","NM","NL1","NL2"]
            sparkCase = any(ele in row[1] for ele in sparkNData)
            if sparkCase:
                xticsp="\"SM\" 1, \"R\" 2"
            generatePlotFile(fName+'.p',fName+'.pdf',xticsp,maxExec,title,fName+'Q.dat',fName+'RW.dat')
        else:
            xticsd="\"SM\" 1, \"R\" 2, \"NP\" 3, \"TF\" 4, \"SP\" 5"      
            generatePlotFile(fName+'.p',fName+'.pdf',xticsd,maxExec,title,fName+'Q.dat',fName+'RW.dat')




