import axios from 'axios';
import React, { useEffect, useState } from 'react';

const DisplayInventory = () => {
    const [inventory, setInventory] = useState([]);
    const [totalInventory, setTotalInventory] = useState([]);
    const [vendorId, setVendorId] = useState('');

    useEffect(() => {
        axios.get("http://localhost:4000/products")
            .then((res) => {
                // console.log(res.data);
                setTotalInventory(res.data);
                // filterData(res.data);
            });
    }, []);

    useEffect(() => {
        filterData(totalInventory);
    }, [vendorId]);

    const filterData = (data) => {
        const filteredInventory = data.filter((item) => item.vendorId == vendorId);
        setInventory(filteredInventory);
        // console.log(`Filtered Inventory`, filteredInventory);
    };

    const editItem = (product) => {

        console.log("product");
    };

    return (
        <div>
            <input type='number' name='vendorId' placeholder='Enter Vendor Id' onChange={(e) => setVendorId(e.target.value)}></input>
            <button type='submit' onClick={() => filterData(totalInventory)}>Show Inventory</button>
            <table>
                <thead>
                    <tr>
                        <th>Product Id</th>
                        <th>Product Name</th>
                        <th>Product Price</th>
                        <th>Product Quantity</th>
                        <th>Vendor Id</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        inventory.map((item) => {
                            return (
                                <tr key={item.id}>
                                    <td>{item.id}</td>
                                    <td>{item.productName}</td>
                                    <td>{item.productPrice}</td>
                                    <td>{item.productQuantity}</td>
                                    <td>{item.vendorId}</td>
                                    <td>
                                        <button onClick={editItem(item)}>✏️</button>
                                    </td>
                                </tr>
                            );
                        })
                    }
                </tbody>
            </table>

            <div>

            </div>
        </div>
    );
};

export default DisplayInventory;