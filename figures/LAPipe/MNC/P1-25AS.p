set terminal pdf
set output "figures/P1-25AS.pdf"
set size square 1.0,1.0
set xtics ("SM" 1, "R" 2, "SP" 3) font ", 16"
set yrange [0.001:41.03537011]
set logscale y 10
set style fill solid border -1
set key off
set grid
set title "M:AS,N:Syn2" font ", 18"
num_of_ksptypes=2
set boxwidth 0.4/num_of_ksptypes
dx=0.5/num_of_ksptypes
offset=-0.1
set ytics font ", 14"
set ylabel "Total Execution Time (logscale) -[s]" font ",16"
plot 'gnudata/P1-25ASQ.dat' using ($1+offset):2 title "Q_{exec}" linecolor rgb "#0000CD" with boxes fs pattern 18,          'gnudata/P1-25ASRW.dat' using ($1+offset+dx):($2+$3) title "RW_{exec}" linecolor rgb "#A9A9A9" with boxes fs pattern 19,          ''                   using ($1+offset+dx):3 title "RW_{find}" linecolor rgb "#0000FF" with boxes