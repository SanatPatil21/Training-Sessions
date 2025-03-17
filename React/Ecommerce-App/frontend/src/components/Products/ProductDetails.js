import React, { use, useEffect, useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import { getAllVendors } from '../../services/Vendors';
import axios from 'axios';
import { createOrder } from '../../services/Orders';

const ProductDetails = () => {
    const location = useLocation();
    const { product } = location.state;
    const [productArray, setProductArray] = useState([]);
    const [vendors, setVendors] = useState([]);
    const [userId,setUserId]=useState("");
    const navigate = useNavigate();



    useEffect(() => {
        axios.get("http://localhost:4000/vendors")
        .then((res)=>{
            setVendors(res.data)
        })
        setProductArray(Object.values(product));
    }, [product]);

    const getVendorName = (vendorId) => {
        const vendor = vendors.find((item) => item.vendorId === vendorId);
        return vendor ? vendor.vendorName : 'Unknown';
    };

    const handleBuyNow = async (item) => {
        if (!userId) {
            alert("Please enter your ID before buying.");
            return;
        }
        console.log("User ID:", userId);
        console.log("Buying item:", item);

        const orderDetails = {
            userId,
            product: item,
            orderDate: new Date().toISOString()
        };

        await createOrder(orderDetails);
        alert('Purchase SuccessFull')
        navigate('/home')
    };


    return (

        <div>
            <div className='product-details'>
                <h1>Product Details</h1>
                {productArray.length > 0 && (
                    <>
                        <h2>{productArray[0].productName}</h2>
                        <p>Price: {productArray[0].productPrice}</p>
                        <input
                            type='text'
                            onChange={(e) => setUserId(e.target.value)}
                            placeholder='Enter your ID'
                        />
                    </>
                )}

                <h2>Available Vendors</h2>
                {
                    productArray.map((item, index) => (
                        <div key={index}>
                            <p>Vendor Name: {getVendorName(item.vendorId)}</p>
                            <p>Vendor ID: {item.vendorId}</p>
                            <p>Price: {item.productPrice}</p>
                            <button
                                onClick={() => handleBuyNow(item)}
                                disabled={!userId}
                            >
                                BUY
                            </button>
                            <hr />
                        </div>
                    ))
                }


            </div>

        </div>
    );
};

export default ProductDetails;