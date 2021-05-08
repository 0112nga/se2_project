import React, {useEffect, useState,useCallback} from 'react';
import { Link } from 'react-router-dom';

function CardItem(props){
    const [title, setTitle] = useState('On Hand Products');
    console.log(props.url)
    useEffect(()=>{
        if(props.name === 'reserved'){
            setTitle('Reserved Quantity');
        }else if(props.name ==='committed'){
            setTitle('Committed Quantity');
        }else if(props.name ==='awaiting'){
            setTitle('Awaiting Quantity');
        }
    },[title])
    return(
        <Link to={props.url !== undefined ? "/products/fulfilment/"+props.url :"/products/"+props.name} className="col-sm quantity-card ">
                    <div className="d-flex justify-content-between">
                        <p className="quantity-text">+ {props.total}</p>
                        <i className="fa fa-tag p-2 quantity-icon" aria-hidden="true"></i> 
                    </div>
                    <p className="quantity-item">{title}</p>
        </Link>
        
    );
}
export default CardItem;