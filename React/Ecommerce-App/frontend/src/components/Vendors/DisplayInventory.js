import axios from 'axios';
import React, { useEffect, useState } from 'react';

const DisplayInventory = () => {
    const [inventory, setInventory] = useState([]);
    const [totalInventory, setTotalInventory] = useState([]);
    const [vendorId, setVendorId] = useState('');
    const [showEditForm,setShowEditForm]=useState(false);
    const [refreshInventory, setRefreshInventory] = useState(false); 

    const [product, setProduct] = useState({
        vendorId: "",
        productName: "",
        productPrice: "",
        productQuantity: ""

    });


    const assignData = (e) => {
        e.preventDefault();
        setProduct({ ...product, [e.target.name]: e.target.value });
    }

    useEffect(() => {
        axios.get("http://localhost:4000/products")
            .then((res) => {
                console.log("Refreshing Inventory");
                
                setTotalInventory(res.data);
                filterData(res.data);
            });
    }, [refreshInventory]);

    useEffect(() => {
        filterData(totalInventory);
    }, [vendorId]);

    const filterData = (data) => {
        const filteredInventory = data.filter((item) => item.vendorId == vendorId);
        setInventory(filteredInventory);
        // console.log(`Filtered Inventory`, filteredInventory);
    };

    const editItem = (product) => {
        setShowEditForm(true);
        setProduct(product);
        
        // console.log("product: ", product);
    };

    const updateProduct = (e) => {
        e.preventDefault();
        console.log('prdouct: ', product);
        
        axios.put(`http://localhost:4000/products/${product.id}`, product)
            .then((res) => {
                console.log(`Product Updated Successfully`, res.data);
                setShowEditForm(false);
                alert(`Product Updated Successfully`);
                setRefreshInventory(!refreshInventory); 
            })
            .catch((err) => {
                console.log(err);
            })
    }

    return (
        <div>
            <input type='number' name='vendorId' placeholder='Enter Vendor Id' onChange={(e) => setVendorId(e.target.value)}></input>
            <button type='submit' onClick={() => {setRefreshInventory(!refreshInventory)}}>Refresh
                 Inventory</button>
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
                    { inventory.length == 0 && <tr><td colSpan={6}>Inventory Empty</td></tr>}
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
                                        <button onClick={() => { editItem(item) }}>✏️</button>
                                    </td>
                                </tr>
                            );
                        })
                    }
                </tbody>
            </table>

            {showEditForm ? <div>
                <input name='vendorId' value={product.vendorId} onChange={assignData} type='number' placeholder='Enter Vendor ID'></input><br></br>

                <input name='productName' value={product.productName} onChange={assignData} type='text' placeholder='Enter Product Name'></input><br></br>

                <input name='productPrice' value={product.productPrice} onChange={assignData} type='number' placeholder='Enter Price'></input><br></br>

                <input name='productQuantity' value={product.productQuantity} onChange={assignData} type='number' placeholder='Enter Quantity'></input><br></br>
                <br></br>

                <button type="submit" onClick={updateProduct}>UPDATE</button>

            </div>
            : ""}
        </div>
    );
};

export default DisplayInventory;