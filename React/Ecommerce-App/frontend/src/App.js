import logo from './logo.svg';
import './App.css';
import Products from './components/Products/Products';
import Vendors from './components/Vendors/Vendors';
import Marketplace from './components/Marketplace/Marketplace';
import Admin from './components/Admin/Admin';
import { useState } from 'react';
import Header from './components/Reusable/Header';
import { Route, Routes } from 'react-router-dom';
import ProductDetails from './components/Products/ProductDetails';

function App() {

  return (
    <div className="App">
      <Header></Header>
      <Routes>
        <Route path='/home' element={<Marketplace/>}></Route>
        <Route path='/' element={<Marketplace/>}></Route>
        <Route path='/admin' element={<Admin></Admin>} ></Route>
        <Route path='/vendor' element={<Vendors></Vendors>} ></Route>
        <Route path="/product-details" element={<ProductDetails />} />
      </Routes>

      {/* <Vendors/>
      <hr></hr>
      <Marketplace/>

      <Admin></Admin> */}
      

    </div>
  );
}

export default App;
