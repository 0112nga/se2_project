import { Paper } from '@material-ui/core';
import MaterialTable from 'material-table';
import React, {useEffect, useState} from 'react';
import { Link } from 'react-router-dom';
import DataTable from '../Product/Table';

function FulfillmentTable(props){
    const [products, setProducts] = useState([]);
    const columns = [
        {title:'Description', field:'description',render:(row)=><span className="overflowtext">{row.description}</span>},
        {title:'SKU', field:'SKU',render:(row)=><Link to={"/products/product/"+row.SKU} style={{textDecoration:"none", fontWeight:"bold", paddingLeft:"0px"}}><i className="fa fa-arrow-right" aria-hidden="true" style={{marginRight:"4px"}}></i>{row.SKU}</Link>},
        {title:'On Hand', field:'onHand', render:(row)=><span className={row.onHand == '0' ? "mode-off" : "mode mode-active2" }>{row.onHand}</span>},
        {title:'Reserved Quantity', field:'reservedQty', render:(row)=><span className={row.reservedQty == '0' ? "mode-off" : "mode mode-active1" } >{row.reservedQty}</span>},
        {title:'Committed Quantity', field:'committedQty', render:(row)=><span className={row.committedQty == '0' ? "mode-off" : "mode mode-active2" }>{row.committedQty}</span>},
        {title:'Awating Quantity', field:'awatingQty', render:(row)=><span className={row.awatingQty == '0' ? "mode-off" : "mode mode-active1" }>{row.awatingQty}</span>},
        {title:'Selling Price', field:'sellingPrice'},
        {title:'Purchase Price', field:'purchasePrice'},

    ]
    useEffect(()=>{
        fetchData();
        console.log(products);
    },[props])
    const fetchData = async () =>{
        const fetchData = await fetch(`http://localhost:8082/se2_project/rest/products/fulfillment/${props.id}`);
        const products = await fetchData.json();
        setProducts(products);
    }
    return(
        <DataTable items={products} key="productInventory" url={props.id}/>
    );
}
export default FulfillmentTable;