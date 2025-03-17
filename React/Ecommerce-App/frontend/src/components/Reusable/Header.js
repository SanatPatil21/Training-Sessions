import React from 'react'
import { Link } from 'react-router-dom'
import '../../styles/Header.css'

const Header = () => {
    return (
        <div className='container'>
            <h1 className='title'>WeMart</h1>
            <div className='links-container'>
                <Link className='link' to='/home'>Home</Link>
                <Link className='link' to='/admin'>Admin</Link>
                <Link className='link' to='/vendor'>Vendor</Link>
            </div>
        </div>
    )
}

export default Header