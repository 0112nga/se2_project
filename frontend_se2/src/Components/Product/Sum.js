import React, {useEffect, useState} from 'react';
import DataTable from './Table';

function SumTable({match}){
    const [products, setProducts] = useState([]);
    useEffect(()=>{
        fetchData();
    },[match.params.name])
    const fetchData = async () =>{
        const fetchData = await fetch(`http://localhost:8082/se2_project/rest/products/${match.params.name}`);
        const products = await fetchData.json();
        setProducts(products);
    }
    return(
        <DataTable items={products} name={match.params.name} key="productInventory"/>
    );
}
export default SumTable;