import React, { useCallback, useState } from "react";
import { useEffect } from "react";
import { PieChart, Pie, Tooltip } from "recharts";

export default function PriceChart(props) {
  const [state, setState] = useState([]);
  const [state2, setState2] = useState([]);
  useEffect(()=>{
      getData();
  },[props.products])
  const getData = () =>{
    let dict = [];
    let dict2 = [];
    if(props.products !== undefined){
      for(let p of props.products){
        if (p.category in dict){
          dict[p.category] = dict[p.category]+ Math.round(p.sellingPrice*p.onHand * 100) / 100;
        }else{
          dict[p.category] = Math.round(p.sellingPrice*p.onHand * 100) / 100;
        }
        if (p.category in dict2){
          dict2[p.category] = dict2[p.category]+ p.onHand;
        }else{
          dict2[p.category] = p.onHand;
        }
      }
      let data = [];
      let data2 = [];
      for (const [key, value] of Object.entries(dict)) {
        if(value != 0){
          data.push({
            name : key,
            value : value
          })
        }
      }
      for (const [key, value] of Object.entries(dict2)) {
        if(value != 0){
          data2.push({
            name : key,
            value : value
          })
        }
    }
    setState(data);
    setState2(data2);
    }
  }
  const chart = <><PieChart width={400} height={400}>
    <Pie
        data={state2}
        dataKey="value"
        cx={200}
        cy={200}
        outerRadius={50}
        fill="#92cbb7"
      />
  <Pie
    data={state}
    dataKey="value"
    cx={200}
    cy={200}
    innerRadius={70}
    outerRadius={90}
    fill="#ffb550"
    label
  />
  <Tooltip/>
  </PieChart>
  <div className="chart-text2">Category Chart</div>
    <div className="sub-text justify-content-between">
      <div className="sub-text2">
        <p>OuterChart</p>
        <p className="sub-text3">Price ($)</p>
      </div>
      <div className="sub-text2">
        <p>InnerChart</p>
        <p className="sub-text3">Quantity</p>
      </div>
    </div>
  </>
  let c = state.length === 0 ? 
  <><p className="chart-text">No Information</p>
  <div className="chart-text2" style={{transform: "translate(50px, -25px)"}}>Category Chart</div>
    <div className="sub-text justify-content-between" style={{transform: "translate(45px, 0px)"}}>
      <div className="sub-text2">
        <p>OuterChart</p>
        <p className="sub-text3">Price ($)</p>
      </div>
      <div className="sub-text2">
        <p>InnerChart</p>
        <p className="sub-text3">Quantity</p>
      </div>
    </div></> : chart;
  return (
    <>
    {c}
    </>
  );
}

