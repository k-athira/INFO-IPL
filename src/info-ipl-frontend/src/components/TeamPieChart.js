import React, { PureComponent } from 'react';
import { PieChart, Pie, Cell } from 'recharts';


export default class Example extends PureComponent {


  render() {

    const data = [
        { name: 'Wins', value: this.props.team.totalWins },
        { name: 'Losses', value: this.props.team.noLosses },
        { name: 'Draw', value: this.props.team.noDraw  }
    ];

    const COLORS = ['#4caf50', '#ec1818', '#ffcc33'];

    
    return (
        <PieChart width={100} height={100}>
            <Pie
                data={data}
                cx="50%"
                cy="50%"
                labelLine={false}
                outerRadius={50}
                innerRadius={35}
                fill="#8884d8"
                dataKey="value"
            >
                {data.map((entry, index) => (
                <Cell key={`cell-${index}`} fill={COLORS[index % COLORS.length]} />
            ))}
            </Pie>
        </PieChart>
    );
  }
}