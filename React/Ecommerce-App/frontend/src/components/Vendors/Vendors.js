import React, { useState } from 'react'
import DisplayInventory from './DisplayInventory'
import AddProduct from './AddProduct'
import AddVendor from './AddVendor'

const Vendors = () => {
  const [showAddProduct, setShowAddProduct] = useState(false);
  const [showRegisterVendor, setShowRegisterVendor] = useState(false);


  const addProductEnable = () => {
    if(showAddProduct)
      setShowAddProduct(false);
    else
      setShowAddProduct(true)
  }

  const registerVendorEnable  = () => {
    if(showRegisterVendor)
      setShowRegisterVendor(false);
    else
      setShowRegisterVendor(true)
  }
  return (
    <div>
      <h1>
        Vendors Page
      </h1>
      <DisplayInventory></DisplayInventory>
      <hr></hr>
      <button onClick={addProductEnable}>
        ADD PRODUCTS
      </button>
      {showAddProduct&&<AddProduct></AddProduct>}
      <br></br>
      <br></br>


      <button onClick={registerVendorEnable}>
        REGISTER VENDOR
      </button>
      {
        showRegisterVendor && <AddVendor></AddVendor>
      }
    </div>
  )
}

export default Vendors