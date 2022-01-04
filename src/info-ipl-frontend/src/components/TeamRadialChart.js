import React, { PureComponent } from 'react';
import { PieChart, Pie, Sector, Cell } from 'recharts';


const COLORS = ['#4caf50', '#ffcc33', '#ec1818'];

export default class Example extends PureComponent {

  render() {
    const data = [
        { name: 'Wins', value: this.props.team.totalWins},
        { name: 'Draw', value: this.props.team.noDraw  },
        { name: 'Losses', value: this.props.team.noLosses }
    ];

    return (
      <PieChart width={400} height={200} onMouseEnter={this.onPieEnter}>
        <Pie
          data={data}
          cx={210}
          cy={100}
          startAngle={180}
          endAngle={0}
          innerRadius={60}
          outerRadius={80}
          fill="#8884d8"
          paddingAngle={5}
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
