import sys
import plotly.graph_objects as go
import pandas as pd
import numpy as np
import plotly
import plotly.express as px

res= pd.read_csv(sys.argv[1])
fig=px.scatter(res,x=res['x'],y=res['y'],color=res['Speedup'], color_discrete_sequence=['#0466A7','#87BDD9','#F2A382','#008000'])
fig.update_traces(marker=dict(size=20,
                              line=dict(width=2,
                                        color='DarkSlateGrey'),
                              ),
                  selector=dict(mode='markers'))

fig.update_xaxes(showgrid=True, gridwidth=1, gridcolor='black', title='Tuple Ratio',
        )
fig.update_yaxes(showgrid=True, gridwidth=1, gridcolor='black')
fig.update_layout(
xaxis_title="Tuple Ratio",
yaxis_title="Feature Ratio",
font=dict(
        family="Old Standard TT, serif",
        size=25,
        color="black"
    ),
legend=dict(
    orientation="h",
    yanchor="bottom",
    y=1,
    xanchor="right",
    x=0.7,
    title="",
    font=dict(
        size=20,
        color="black"
    )
),
xaxis=dict(
       tickfont=dict(
            family='Old Standard TT, serif',
            size=20,
            color='black'

        )
    ), 

yaxis=dict(
        tickfont=dict(
            family='Old Standard TT, serif',
            size=20,
            color='black'
        ),
        tickmode = 'linear',
        tick0 = 1,
        dtick = 1

    ),
     paper_bgcolor='rgba(0,0,0,0)',
     plot_bgcolor='rgba(0,0,0,0)')

fig.write_image(sys.argv[2])