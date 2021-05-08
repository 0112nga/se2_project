
import React from 'react';
import CardItem from './Card';

function HeadTable(props){
    console.log("1sjcn" + props.url);
    return(
        <>
        <div className="container" style={{marginLeft: "150px", marginRight:"0px", marginTop:"40px"}}>
            <div className="row">
                <div className="col-sm card total-card">
                    <div className="d-flex justify-content-between">
                        <p className="card-text">$ {Math.round(props.totalPrice * 100) / 100}</p>
                    </div>
                    <p className="card-item total-item">Total On Hand Budget</p>
                </div>
                <CardItem name='onHand' url={props.url} total={props.totalOnHand}/>
                <CardItem name='reserved' url={props.url} total={props.totalReserved}/>
                <CardItem name='committed' url={props.url} total={props.totalCommitted}/>
                <CardItem name='awaiting' url={props.url} total={props.totalAwaiting}/>
            </div>
        </div>
        </>
    );
}
export default HeadTable;