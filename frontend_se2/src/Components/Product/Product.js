import React,{useState, useEffect}  from 'react';
import NumberFormat from 'react-number-format';
import { Link } from 'react-router-dom';

function Product({match}){
    const [products, setProducts] = useState([]);
    useEffect(()=>{
        fetchData();
    },[])
    const fetchData = async () =>{
        const fetchData = await fetch(`http://localhost:8082/se2_project/rest/products/product/${match.params.sku}`);
        const products = await fetchData.json();
        setProducts(products);
        
    }
    const c = products.length === 0 ? <></> :
    <div className="container" style={{marginLeft:"250px"}}>
        <div className="row" style={{marginTop:"40px"}}>
            <div className="col-sm-2">
                <div style={{textAlign:"center",marginBottom:"25px"}}>
                    <img className="product-img" src={process.env.PUBLIC_URL + products.productImgURL}/>
                    <div className="product-title" style={{marginTop:"15px"}}>Product Image</div>
                </div>
                <div style={{textAlign:"center"}}>
                    <img className="product-img" src={process.env.PUBLIC_URL + products.barcode.productBarcodeURL}/>
                    <div className="product-title" style={{marginTop:"15px"}}>Barcode Image</div>
                </div>
            </div>
            <div className="col-sm-10">
                <h2 style={{marginLeft:"70px"}}>Basic Information</h2>
                <div className="col">
                    <div className="row" style={{marginLeft:"60px", display:"inline-flex",marginTop:"30px"}}>
                        <div className="col-sm-4">
                            <div className="product-title" >Product Description</div>
                            <div className="product-text" >{products.description}</div>
                        </div>
                        <div className="col-sm-3">
                            <div className="product-title" >SKU</div>
                            <div className="product-text" >{products.SKU}</div>
                        </div>  
                        <div className="col-sm-2">
                            <div className="product-title" >Barcode</div>
                            <div className="product-text" >{products.barcode.EANorUPC}</div>
                        </div>
                        <div className="col-sm-2">
                            <div className="product-title" >Selling Price</div>
                            <div className="product-text" >{products.sellingPrice}</div>
                        </div>
                    <div>
                    <div className="row" style={{marginTop:"20px"}}>
                        <div className="col-sm-2">
                            <div className="product-title" >On Hand Products</div>
                            <div className="product-text" >{products.onHand}</div>
                        </div>
                        <div className="col-sm-2">
                            <div className="product-title" >Reserved Quantity</div>
                            <div className="product-text" >{products.reservedQty}</div>
                        </div>
                        <div className="col-sm-3">
                            <div className="product-title" >Committed Quantity</div>
                            <div className="product-text" >{products.committedQty}</div>
                        </div>
                        <div className="col-sm-2">
                            <div className="product-title" >Awaiting Quantity</div>
                            <div className="product-text" >{products.awatingQty}</div>
                        </div>
                    </div>
                    <div className="row" style={{marginTop:"20px"}}>
                        <div className="col-sm-2">
                            <div className="product-title" >Category</div>
                            <div className="product-text" >{products.category}</div>
                        </div>
                        <div className="col-sm-2">
                            <div className="product-title" >UOM</div>
                            <div className="product-text" >{products.UOM}</div>
                        </div>
                        <div className="col-sm-3">
                            <div className="product-title" >Trade Mark</div>
                            <div className="product-text" >{products.tradeMark}</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
                
            </div>
        </div>
        <div className="row" style={{marginTop:"10px",marginLeft:"200px"}}>
                    <h2 style={{marginLeft:"70px",marginTop:"30px"}}>Fulfillment</h2>
                        <div className="row" style={{marginLeft:"60px", display:"inline-flex",marginTop:"30px"}}>
                            <div className="col-sm-4">
                                <div className="product-title" >Supplier</div>
                                <div className="product-text" >{products.fulfillment.companyName}</div>
                            </div>
                            <div className="col-sm-2">
                                <div className="product-title" >Key</div>
                                <div className="product-text" >
                                <Link to={"/fulfillment/"+products.fulfillment.fulfillment_key} style={{textDecoration:"none"}}><i className="fa fa-arrow-right" aria-hidden="true" style={{marginRight:"4px"}}></i>
                                <NumberFormat value={products.fulfillment.fulfillment_key} displayType={'text'} prefix={'000'} /></Link>
                                </div>
                            </div>
                            <div className="col-sm-2">
                                <div className="product-title" >Landing Cost</div>
                                <div className="product-text" >$ {products.fulfillment.landingCost}</div>
                            </div>
                            <div className="col-sm-2">
                                <div className="product-title" >Purchase Price</div>
                                <div className="product-text" >$ {products.purchasePrice}</div>
                            </div>
                        </div>
        </div>
    </div>
    ;
    return (
        <>{c}</>
    );
}
export default Product;