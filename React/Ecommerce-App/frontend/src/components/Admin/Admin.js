import axios from 'axios'
import React, { useEffect, useState } from 'react'
import '../../styles/Admin.css'

const Admin = () => {

    const [products,setProducts] = useState([]);
    const [vendors,setVendors] = useState([]);

    useEffect(() => {
        axios.get("http://localhost:4000/products")
        .then((res)=>{
            setProducts(res.data)
        })

    },[])

    useEffect(() => {
        axios.get("http://localhost:4000/vendors")
        .then((res)=>{
            setVendors(res.data)
        })

    },[])
    return (
        <div>
            <h2>Admin Page</h2>
            <h3>
                Products
            </h3>
            <table>
                <thead>
                    <tr>
                        <th>Product Id</th>
                        <th>Product Name</th>
                        <th>Product Price</th>
                        <th>Product Quantity</th>
                        <th>Vendor Id</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        products.map((item) => {
                            return (
                                <tr key={item.id}>
                                    <td>{item.id}</td>
                                    <td>{item.productName}</td>
                                    <td>{item.productPrice}</td>
                                    <td>{item.productQuantity}</td>
                                    <td>{item.vendorId}</td>
                                </tr>
                            );
                        })
                    }
                </tbody>
            </table>


            <h3>
                Vendors
            </h3>

            <table>
                <thead>
                    <tr>
                        <th>Vendor Id/GSTIN</th>
                        <th>Vendor Name</th>
                        <th>Vendor City</th>
                        <th>Vendor Ratings</th>
                        
                    </tr>
                </thead>
                <tbody>
                    {
                        vendors.map((item) => {
                            return (
                                <tr key={item.vendorId}>
                                    <td>{item.vendorId}</td>
                                    <td>{item.vendorName}</td>
                                    <td>{item.vendorCity}</td>
                                    <td>{item.vendorRatings}</td>
                                </tr>
                            );
                        })
                    }
                </tbody>
            </table>
        </div>
    )
}

export default Admin