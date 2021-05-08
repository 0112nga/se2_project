import { Paper } from '@material-ui/core';
import MaterialTable from 'material-table';
import React, {useEffect, useState} from 'react';
import NumberFormat from 'react-number-format';
import { Link } from 'react-router-dom';

function FulfillmentList(){
    const [fulfillment, setFulfilment] = useState([]);
    useEffect(()=>{
        fetchData();
    },[])
    const fetchData = async () =>{
        const fetchData = await fetch(`http://localhost:8082/se2_project/rest/fulfillment`);
        const fulfillment = await fetchData.json();
        setFulfilment(fulfillment);
    }
    const columns = [
        {title:'Company Name', field:'companyName'},
        {title:'Key', field:'fulfillment_key',render:(row)=><Link to={"/fulfillment/"+row.fulfillment_key} style={{textDecoration:"none"}}><i className="fa fa-arrow-right" aria-hidden="true" style={{marginRight:"4px"}}></i>
        <NumberFormat value={row.fulfillment_key} displayType={'text'} prefix={'000'} /></Link>},
        {title:'Email', field:'email'},
        {title:'Phone Number', field:'phoneNumber', render:(row)=><NumberFormat format="###-###-####" displayType={'text'} value={row.phoneNumber}/>},
        {title:'Landing Cost', field:'landingCost', render:(row)=><>$ {row.landingCost}</>},
        {title:'Currency', field:'currency'},

    ]
    return(
        <MaterialTable 
        title="List of Fulfilments"
            style={{marginTop:"100px"}}
            data={fulfillment}
            columns={columns}
            options={{
                // filtering:false,
                exportButton:true,
                actionsColumnIndex:-1,
                addRowPosition:"first"
            }}
            components={{
              Container: (props) => <Paper className="table-unexpand" {...props}/>
                  }}
            editable = {{
              onRowAdd: (newRow) => {
                fetch('http://localhost:8082/se2_project/rest/fulfilment',{
                  method: 'POST',
                  headers:{
                    'Content-Type':'application/json'
                  },
                  body:JSON.stringify({
                    product : newRow,
                  })
                })
                .then(res => {
                  res.json();
                })
                .catch(err => console.log('err'))
              }
              ,
              onRowUpdate: (newData) =>
              new Promise((resolve, reject) => {
                fetch(`http://localhost:8082/se2_project/rest/fulfilment`,{
                  method: 'PUT',
                  headers:{
                    'Content-Type':'application/json'
                  },
                  body:JSON.stringify({
                    product : newData,
                  })
                })
                .then(res => {
                  res.json();
                })
                .catch(err => console.log('err'))
                  resolve();
                }),
                onRowDelete: data =>
                new Promise((resolve, reject) => {
                  fetch(`http://localhost:8082/se2_project/rest/fulfilment/${data.fulfillment_key}`,{
                    method: 'DELETE',
                    headers:{
                      'Content-Type':'application/json',
                       }
                  })
                  .then(res => {
                    res.json();
                  })
                  .catch(err => console.log(err));
                  resolve();
                  })
            }}
            
            />
        
    );
}
export default FulfillmentList;