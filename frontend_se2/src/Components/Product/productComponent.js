import React, {useState, useEffect} from 'react';
import SumTable from './Sum';
import DataTable from './Table';
import {BrowserRouter as Switch, Route} from "react-router-dom"
import Product from './Product';
import FulfillmentTable from '../Fulfillment/FulfillmentTable';
import Fulfillment from '../Fulfillment/Fullfilment';
import FulfillmentList from '../Fulfillment/FulfilmentList';

function ProductComponent(){
    useEffect(()=>{
        fetchAllProducts();
    },[]);
    const [products, setProducts] = useState([]);
    const fetchAllProducts = async () =>{
        const fetchData = await fetch('http://localhost:8082/se2_project/rest/products');
        const productsData = await fetchData.json();
        setProducts(productsData);
    }

    return(
        <>
        <Switch>
            <Route path="/products" exact component={() => <DataTable items={products} key="productInventory"/>}/>
            <Route path="/products/:name" exact component={SumTable}/>
            <Route path="/products/product/:sku" exact component={Product}/>
            <Route path="/products/fulfillment/:id" exact component={FulfillmentTable}/>
            <Route path="/fulfillment/" exact component={FulfillmentList}/>
            <Route path="/fulfillment/:id" exact component={Fulfillment}/>
            <Route path="/products/fulfilment/:id" exact component={Fulfillment}/>
        </Switch>
        </>
        )
}

export default ProductComponent;