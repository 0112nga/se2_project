import React from 'react';
import MaterialTable from 'material-table';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import Box from '@material-ui/core/Box';
import Typography from '@material-ui/core/Typography';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import NumberFormat from 'react-number-format';
import { Link } from 'react-router-dom';
import Paper from '@material-ui/core/Paper';
import HeadTable from './HeadTable';
import PriceChart from './PieChart';
import { useState } from 'react';
import { useEffect } from 'react';
function DataTable (props) {
    const [titleTable, setTile] = useState('Inventory');
    const columns = [
        {title:'SKU', field:'SKU',render:(row)=><Link to={"/products/product/"+row.SKU} style={{textDecoration:"none", fontWeight:"bold", paddingLeft:"0px"}}><i className="fa fa-arrow-right" aria-hidden="true" style={{marginRight:"4px"}}></i>{row.SKU}</Link>},
        {title:'Description', field:'description',render:(row)=><span className="overflowtext">{row.description}</span>},
        {title:'On Hand', field:'onHand', render:(row)=><span className={row.onHand == '0' ? "mode-off" : "mode mode-active2" }>{row.onHand}</span>},
        {title:'Reserved Quantity', field:'reservedQty', render:(row)=><span className={row.reservedQty == '0' ? "mode-off" : "mode mode-active1" } >{row.reservedQty}</span>},
        {title:'Committed Quantity', field:'committedQty', render:(row)=><span className={row.committedQty == '0' ? "mode-off" : "mode mode-active2" }>{row.committedQty}</span>},
        {title:'Awating Quantity', field:'awatingQty', render:(row)=><span className={row.awatingQty == '0' ? "mode-off" : "mode mode-active1" }>{row.awatingQty}</span>},
        {title:'Selling Price', field:'sellingPrice'},

    ]
    useEffect(()=>{
      if(props.name === 'onHand'){
        setTile('On Hand Products')
      }else if(props.name === 'reserved'){
        setTile('Reserved Products')
      }else if(props.name === 'committed'){
        setTile('Committed Products')
      }else if(props.name === 'awaiting'){
        setTile('Awaiting Products')
      }
    },[props.name])
    return <>
        <HeadTable totalOnHand={props.items.totalOnHand} 
        totalReserved={props.items.totalReserved}
        totalCommitted={props.items.totalCommitted}
        totalAwaiting={props.items.totalAwaiting}
        totalPrice={props.items.totalPrice} url={props.url}>
        </HeadTable>
        <div style={{display:"inline-flex"}}>
        <MaterialTable 
        title={titleTable}
            data={props.items.products}
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
                fetch('http://localhost:8082/se2_project/rest/products',{
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
                fetch(`http://localhost:8082/se2_project/rest/products`,{
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
                  fetch(`http://localhost:8082/se2_project/rest/products/product/${data.SKU}`,{
                    method: 'DELETE',
                    headers:{
                      'Content-Type':'application/json',
                      "Access-Control-Allow-Origin": "*"
                       }
                  })
                  .then(res => {
                    res.json();
                  })
                  .catch(err => console.log(err));
                  resolve();
                  })
            }}
            detailPanel= {[{ render: rowData => {
                return (
                    <Box margin={1} key="ạncbas">
                    <Typography variant="h6" gutterBottom component="div" style={{marginLeft:"15px", marginTop:"15px",fontSize:"24px", fontFamily:"'Noto Sans SC', sans-serif"}}>
                    More Details
                    </Typography>
                    <Table size="small" aria-label="purchases">
                      <TableHead>
                        <TableRow>
                          <TableCell></TableCell>
                          <TableCell></TableCell>
                          <TableCell style={{fontSize:"15px", fontFamily:"'Noto Sans SC', sans-serif",paddingBottom:"20px"}}>Product Image</TableCell>
                          <TableCell style={{fontSize:"15px", fontFamily:"'Noto Sans SC', sans-serif",paddingBottom:"20px"}}>Product Barcode</TableCell>
                          <TableCell style={{fontSize:"15px", fontFamily:"'Noto Sans SC', sans-serif",paddingBottom:"20px"}}>EAN/UPC</TableCell>
                          <TableCell style={{fontSize:"15px", fontFamily:"'Noto Sans SC', sans-serif",paddingBottom:"20px"}}>Category</TableCell>
                          <TableCell style={{fontSize:"15px", fontFamily:"'Noto Sans SC', sans-serif",paddingBottom:"20px"}}>UOM</TableCell>
                          <TableCell style={{fontSize:"15px", fontFamily:"'Noto Sans SC', sans-serif",paddingBottom:"20px"}}>Trade mark</TableCell>
                          <TableCell></TableCell>
                        </TableRow>
                      </TableHead>
                      <TableBody>
                          <TableRow key={rowData.SKU}>
                              <TableCell ></TableCell>
                              <TableCell></TableCell>
                            <TableCell component="th" scope="row" style={{fontSize:"15px", fontFamily:"'Noto Sans SC', sans-serif"}}>
                              <img className="product-img" src={process.env.PUBLIC_URL + rowData.productImgURL}></img>
                            </TableCell>
                            <TableCell style={{fontSize:"15px", fontFamily:"'Noto Sans SC', sans-serif"}}>
                              <img className="product-img" src={process.env.PUBLIC_URL + rowData.barcode.productBarcodeURL}></img>
                            </TableCell>
                            <TableCell style={{fontSize:"15px", fontFamily:"'Noto Sans SC', sans-serif"}}>{rowData.barcode.EANorUPC}</TableCell>
                            <TableCell style={{fontSize:"15px", fontFamily:"'Noto Sans SC', sans-serif"}}>
                              {/* {Math.round(historyRow.amount * row.price * 100) / 100} */}
                              {rowData.category}
                            </TableCell>
                            <TableCell style={{fontSize:"15px", fontFamily:"'Noto Sans SC', sans-serif"}}>{rowData.UOM}</TableCell>
                            <TableCell style={{fontSize:"15px", fontFamily:"'Noto Sans SC', sans-serif"}}>{rowData.tradeMark}</TableCell>
                            <TableCell></TableCell>
                          </TableRow>
                      </TableBody>
                    </Table>
                    <Typography variant="h6" gutterBottom component="div" style={{marginLeft:"15px", marginTop:"15px",fontSize:"24px", fontFamily:"'Noto Sans SC', sans-serif"}}>
                      Fulfillment
                    </Typography>
                    <Table size="small" aria-label="purchases">
                      <TableHead>
                        <TableRow>
                          <TableCell ></TableCell>
                          <TableCell></TableCell>
                          <TableCell style={{fontSize:"15px", fontFamily:"'Noto Sans SC', sans-serif",paddingBottom:"20px"}}>Fulfillment Key</TableCell>
                          <TableCell style={{fontSize:"15px", fontFamily:"'Noto Sans SC', sans-serif",paddingBottom:"20px"}}>Supplier</TableCell>
                          <TableCell style={{fontSize:"15px", fontFamily:"'Noto Sans SC', sans-serif",paddingBottom:"20px"}}>Purchase Price</TableCell>
                          <TableCell style={{fontSize:"15px", fontFamily:"'Noto Sans SC', sans-serif",paddingBottom:"20px"}}>Landing Cost</TableCell>
                          <TableCell style={{fontSize:"15px", fontFamily:"'Noto Sans SC', sans-serif",paddingBottom:"20px"}}>Email</TableCell>
                          <TableCell></TableCell>
                        </TableRow>
                      </TableHead>
                      <TableBody>
                          <TableRow key={rowData.barcode.EANorUPC}>
                          <TableCell></TableCell>
                          <TableCell></TableCell>
                            <TableCell style={{fontSize:"15px", fontFamily:"'Noto Sans SC', sans-serif",textDecoration:"none", fontWeight:"bold"}} component="th" scope="row" >
                              <Link to={"fulfillment/"+rowData.fulfillment.fulfillment_key} style={{textDecoration:"none"}}><i className="fa fa-arrow-right" aria-hidden="true" style={{marginRight:"4px"}}></i>
                              <NumberFormat value={rowData.fulfillment.fulfillment_key} displayType={'text'} prefix={'000'} /></Link>
                            </TableCell>
                            <TableCell style={{fontSize:"15px", fontFamily:"'Noto Sans SC', sans-serif"}} >
                              {rowData.fulfillment.companyName}
                            </TableCell>
                            <TableCell style={{fontSize:"15px", fontFamily:"'Noto Sans SC', sans-serif"}} >
                            <NumberFormat value={rowData.purchasePrice} displayType={'text'} prefix={'$'}/>
                            </TableCell>
                            <TableCell style={{fontSize:"15px", fontFamily:"'Noto Sans SC', sans-serif"}} >
                              <NumberFormat value={rowData.fulfillment.landingCost} displayType={'text'} prefix={'$'}/>
                            </TableCell>
                            <TableCell style={{fontSize:"15px", fontFamily:"'Noto Sans SC', sans-serif"}} >
                              {rowData.fulfillment.email}
                            </TableCell>
                            <TableCell></TableCell>
                            
                          </TableRow>
                      </TableBody>
                    </Table>
                  </Box>
                )
              }}]}
            
            />
            <div className="card card-chart">
              <PriceChart products={props.items.products}/>
            </div>
        </div>
    </>
}
export default DataTable;