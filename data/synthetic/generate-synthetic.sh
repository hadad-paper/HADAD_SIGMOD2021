#Generate
python3.7 generate.py --nrow 50000 --ncol 100 --sparsity 100%
python3.7 generate.py --nrow 100 --ncol 50000 --sparsity 100%
python3.7 generate.py --nrow 1000000 --ncol 100 --sparsity 100%
python3.7 generate.py --nrow 5000000 --ncol 100 --sparsity 100%
python3.7 generate.py --nrow 10000 --ncol 10000 --sparsity 100%
python3.7 generate.py --nrow 20000 --ncol 20000 --sparsity 100%
python3.7 generate.py --nrow 100 --ncol 1 --sparsity 100%
python3.7 generate.py --nrow 50000 --ncol 1 --sparsity 100%
python3.7 generate.py --nrow 100000 --ncol 1 --sparsity 100%
python3.7 generate.py --nrow 100 --ncol 100 --sparsity 100%

#Copy
cp matrix-50000-100-1.0.csv syn1.csv
cp matrix-100-50000-1.0.csv syn2.csv
cp matrix-1000000-100-1.0.csv syn3a.csv
cp matrix-1000000-100-1.0.csv syn3b.csv
cp matrix-5000000-100-1.0.csv syn4a.csv
cp matrix-5000000-100-1.0.csv syn4b.csv
cp matrix-10000-10000-1.0.csv syn5c.csv
cp matrix-10000-10000-1.0.csv syn5d.csv
cp matrix-10000-10000-1.0.csv syn5e.csv
cp matrix-20000-20000-1.0.csv syn6c.csv
cp matrix-20000-20000-1.0.csv syn6d.csv
cp matrix-20000-20000-1.0.csv syn6e.csv
cp matrix-100-1-1.0.csv syn7.csv
cp matrix-50000-1-1.0.csv syn8.csv
cp matrix-100000-1-1.0.csv syn9.csv
cp matrix-100-100-1.0.csv syn10.csv