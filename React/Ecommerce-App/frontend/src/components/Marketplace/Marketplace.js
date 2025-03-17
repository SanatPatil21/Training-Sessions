import axios from 'axios';
import React, { useEffect, useState } from 'react'
import '../../App.css'
import { buyProduct, groupProductsByName } from '../../services/Product';
import '../../styles/Marketplace.css'
import { useNavigate } from 'react-router-dom';

const Marketplace = () => {

    const [products, setProducts] = useState([]);
    const [groupedProducts, setGroupedProducts] = useState([]);
    const [vendorDetails,setVendorDetails]=useState([]);
    const navigate = useNavigate();

    useEffect(()=>{
        axios.get("http://localhost:4000/vendors")
        .then((res)=>{
            setVendorDetails(res.data)
            // console.log(vendorDetails);
        })
    },[products])

    useEffect(() => {
        axios.get("http://localhost:4000/products")
            .then((res) => {
                setProducts(res.data);
            });
    }, []);

    useEffect(() => {
        setGroupedProducts(groupProductsByName(products));
    }, [products]);


    const getLowestPrice = (productName) =>{
        const product = groupedProducts[productName][0];
        return product ? product.productPrice : 'No Price';
    }

    const handleBuyNow = (product) => {
        console.log(product);
        
        navigate('/product-details', { state: { product: { ...product } } });
    }
    

    return (
        <div>
            <div className="marketplace-container">
            {
                Object.keys(groupedProducts).map((productName) => {
                    return (
                        <div className='product-card' key={productName}>
                            <h3>{productName}</h3>
                            <h4>Price: {getLowestPrice(productName)}</h4>
                            <button onClick={()=>{handleBuyNow(groupedProducts[productName])}}>Buy Now</button>
                            

                            

                            {/* Show all the vendors for the product */}


                            
                        </div>
                    )
                })
            }
        </div>

        </div>
        
    )
}

export default Marketplace