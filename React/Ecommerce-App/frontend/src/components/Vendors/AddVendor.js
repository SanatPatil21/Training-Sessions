import axios from 'axios';
import React, { useState } from 'react'

const AddVendor = () => {
    const [vendor,setVendor]=useState({
        vendorId:"",
        vendorName:"",
        vendorCity:"",
        vendorRatings:"4.3"
    });


    const assignData = (e) => {
        e.preventDefault();
        setVendor({...vendor,[e.target.name]:e.target.value});
    }


    const insertVendor=(e)=>{
        e.preventDefault();
        axios.post("http://localhost:4000/vendors",vendor)
        .then((res)=>{
            // console.log(`Vendor Added Sucessfully`,res.data);
            alert(`Vendor Added Sucessfully`);
            //Reset the form fields
            setVendor({vendorId:"",vendorName:"",vendorCity:""});
        })
        .catch((err)=>{
            console.log(err);
        })
    }

    return (
        <div>
            <h3>
                Register New Vendor
            </h3>
            <input name='vendorId' value={vendor.vendorId} onChange={assignData} type='number' placeholder='Enter Vendor ID/GSTIN'></input><br></br>

            <input name='vendorName' value={vendor.vendorName} onChange={assignData}type='text' placeholder='Enter Vendor Name'></input><br></br>

            <input name='vendorCity' value={vendor.vendorCity} onChange={assignData}type='text' placeholder='Enter City'></input><br></br>

        <br></br>
            <button type="submit" onClick={insertVendor}>SUBMIT</button>
            {/* <button type="submit" onClick={updateEmp}>UPDATE</button> */}

        </div>
    )
}

export default AddVendor;