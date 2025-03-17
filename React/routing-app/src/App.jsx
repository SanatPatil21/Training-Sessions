import { useState } from 'react'
import './styles.css'
import { Route, Routes } from 'react-router-dom'
import Header from './components/Header'
import Footer from './components/Footer'
import Home from './pages/Home'
import About from './pages/About'
import Services from './pages/Services'


function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <Header></Header>
      <Routes>
        <Route path="/"

          element={<h1>This is the Landing Page</h1>}>

        </Route>

        <Route path="/vite"

          element={<h1>This Project is created using VITE</h1>}>

        </Route>
        <Route path="/home" element={<Home />}>
        </Route>

        <Route path='/about' element={<About />}>

        </Route>

        <Route path='/services' element={<Services />}>



        </Route>
      </Routes>
      <Footer></Footer>
    </>
  )
}

export default App
