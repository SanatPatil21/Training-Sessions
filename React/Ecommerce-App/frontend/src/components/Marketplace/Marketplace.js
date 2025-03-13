import axios from 'axios';
import React, { useEffect, useState } from 'react'
import '../../App.css'

const Marketplace = () => {

    const [products, setProducts] = useState([]);
    const [groupedProducts, setGroupedProducts] = useState([]);
    const [vendorDetails,setVendorDetails]=useState([]);

    useEffect(()=>{
        axios.get("http://localhost:4000/vendors")
        .then((res)=>{
            setVendorDetails(res.data)
            console.log(vendorDetails);
        })
    },[products])

    useEffect(() => {
        axios.get("http://localhost:4000/products")
            .then((res) => {
                setProducts(res.data);
            });
    }, []);

    useEffect(() => {
        groupProducts(products);
    }, [products]);

    const groupProducts = (data) => {
        //Group Together Products Based on Product Name
        const groupedProducts = data.reduce((acc, product) => {
            const { productName } = product;
            if (!acc[productName]) {
                acc[productName] = [];
            }
            acc[productName].push(product);
            return acc;
        }, {});
        setGroupedProducts(groupedProducts);
        console.log(`Grouped Products`,groupedProducts);
    }

    const getVendorName = (vendorId) => {
        const vendor = vendorDetails.find(vendor => vendor.vendorId == vendorId);
        return vendor ? vendor.vendorName : 'Unknown Vendor';
    }

    const getVendorRatings = (vendorId) => {
        const vendor = vendorDetails.find(vendor => vendor.vendorId == vendorId);
        return vendor ? vendor.vendorRatings : 'No Ratings';
    }

    return (
        <div>
            <h1>
                Marketplace
            </h1>
            <div className="marketplace-container">
            
            {
                Object.keys(groupedProducts).map((productName) => {
                    return (
                        <div className='product-card' key={productName}>
                            <h3>{productName}</h3>
                            <h4>List of Available Vendors</h4>

                            {
                                groupedProducts[productName].map((product) => {
                                    return (
                                        <div key={product.id}>
                                            <p>Vendor Name: {getVendorName(product.vendorId)}</p>
                                            <p>Price: Rs.{product.productPrice}</p>
                                            <p>Ratings: {getVendorRatings(product.vendorId)}</p>
                                            <br></br>
                                            {/* <p>Quantity: {product.productQuantity}</p> */}
                                        </div>
                                    )
                                })
                            }
                        </div>
                    )
                })
            }
        </div>

        </div>
        
    )
}

export default Marketplace