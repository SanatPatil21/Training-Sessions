import React from 'react'
import { Link } from 'react-router-dom'

const Header = () => {
  return (
    <div>
      <h1>Kalupur International Bank</h1>
      <h2>Banking Made Easier</h2>
      <ul>
        <li>
          <Link to='/home'>Home</Link>
        </li>
        <li>
          <Link to='/about'>About Us</Link>
        </li>
        <li>
          <Link to='/services'>Services</Link>
        </li>
      </ul>


    </div>
  )
}

export default Header