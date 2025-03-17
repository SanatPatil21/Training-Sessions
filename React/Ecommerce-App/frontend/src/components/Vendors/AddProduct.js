import axios from 'axios';
import React, { useState } from 'react'

const AddProduct = () => {
    const [product,setProduct]=useState({
        vendorId:"",
        productName:"",
        productPrice:"",
        productQuantity:""

    });


    const assignData = (e) => {
        e.preventDefault();
        setProduct({...product,[e.target.name]:e.target.value});
    }


    const insertProduct=(e)=>{
        e.preventDefault();
        axios.post("http://localhost:4000/products",product)
        .then((res)=>{
            // console.log(`Product Added Sucessfully`,res.data);
            alert(`Product Added Sucessfully`);
            //Reset the form fields
            setProduct({vendorId:"",productName:"",productPrice:"",productQuantity:""});
        })
        .catch((err)=>{
            console.log(err);
        })
    }

    return (
        <div>
            <h3>
                Please enter Product details
            </h3>
            <input name='vendorId' value={product.vendorId} onChange={assignData} type='number' placeholder='Enter Vendor ID'></input><br></br>

            <input name='productName' value={product.productName} onChange={assignData}type='text' placeholder='Enter Product Name'></input><br></br>

            <input name='productPrice' value={product.productPrice} onChange={assignData}type='number' placeholder='Enter Price'></input><br></br>

            <input name='productQuantity' value={product.productQuantity} onChange={assignData}type='number' placeholder='Enter Quantity'></input><br></br>
            <br></br>

            <button type="submit" onClick={insertProduct}>SUBMIT</button>
            {/* <button type="submit" onClick={updateEmp}>UPDATE</button> */}

        </div>
    )
}

export default AddProduct