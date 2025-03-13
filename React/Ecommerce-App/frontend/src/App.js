import logo from './logo.svg';
import './App.css';
import Products from './components/Products/Products';
import Vendors from './components/Vendors/Vendors';
import Marketplace from './components/Marketplace/Marketplace';
import Admin from './components/Admin/Admin';

function App() {
  return (
    <div className="App">
      <Vendors/>
      {/* <hr></hr> */}
      {/* <Products/> */}
      <hr></hr>
      <Marketplace/>

      <Admin></Admin>
      

    </div>
  );
}

export default App;
