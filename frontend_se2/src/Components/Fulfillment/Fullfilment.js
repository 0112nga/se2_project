import React,{useState, useEffect}  from 'react';
import NumberFormat from 'react-number-format';
import { Link } from 'react-router-dom';
import FulfillmentTable from './FulfillmentTable';
// import { StyleSheet, ScrollView} from 'react-native';

function Fulfillment({match}){
    const [fulfillment, setProducts] = useState([]);
    useEffect(()=>{
        fetchData();
    },[])
    const fetchData = async () =>{
        const fetchData = await fetch(`http://localhost:8082/se2_project/rest/fulfillment/${match.params.id}`);
        const fulfillment = await fetchData.json();
        setProducts(fulfillment);
    }
    const c = fulfillment.length === 0 ? <></> :
    <div style={{ maxHeight: '700px', overflowY: 'scroll' }}>
    <div className="container" style={{marginLeft:"50px", marginTop:"40px"}}>
        <h2 style={{marginLeft:"160px"}}>Basic Information</h2>
        <div className="row" style={{marginTop:"20px", marginBottom:"20px",marginLeft:"150px"}}>
                <div className="col-sm-1">
                    <div className="product-title" >Key</div>
                        <div className="product-text" >
                        <Link to={"/fulfillment/"+fulfillment.fulfillment_key} style={{textDecoration:"none"}}><i className="fa fa-arrow-right" aria-hidden="true" style={{marginRight:"4px"}}></i>
                        <NumberFormat value={fulfillment.fulfillment_key} displayType={'text'} prefix={'000'} /></Link>
                    </div>
                </div>
                <div className="col-sm-3">
                    <div className="product-title" >Company Name</div>
                    <div className="product-text" >{fulfillment.companyName}</div>
                </div>
                <div className="col-sm-2">
                    <div className="product-title" >Landing Cost</div>
                    <div className="product-text" >$ {fulfillment.landingCost}</div>
                </div>
                <div className="col-sm-1">
                    <div className="product-title" >Currency</div>
                    <div className="product-text" >{fulfillment.currency}</div>
                </div>
                <div className="col-sm-3">
                    <div className="product-title" >Email</div>
                    <div className="product-text" >{fulfillment.email}</div>
                </div>
                <div className="col-sm-2">
                    <div className="product-title" >Phone Number</div>
                    <div className="product-text" >{fulfillment.phoneNumber}</div>
                </div>
        </div>
        <FulfillmentTable id={match.params.id} />
        <h2 style={{marginLeft:"160px", marginTop:"40px"}}>Location</h2>
        <div className="row" style={{marginTop:"20px",marginBottom:"40px",marginLeft:"150px"}}>
            <div className="col-sm-3">
                <div className="product-title" >Address</div>
                <div className="product-text" >{fulfillment.location.address}</div>
            </div>
            <div className="col-sm-3">
                <div className="product-title" >City</div>
                <div className="product-text" >{fulfillment.location.city}</div>
            </div>
            <div className="col-sm-2">
                <div className="product-title" >State</div>
                <div className="product-text" >{fulfillment.location.state}</div>
            </div>
            <div className="col-sm-2">
                <div className="product-title" >Country</div>
                <div className="product-text" >{fulfillment.location.country}</div>
            </div>
            <div className="col-sm-2">
                <div className="product-title" >Zipcode</div>
                <div className="product-text" >{fulfillment.location.zipcode}</div>
            </div>
        </div>
    </div>
    </div>
    return (
        <>{c}</>
    );
}
export default Fulfillment;