import React, { useEffect, useState } from 'react'
import './styles/Effect.css'

const Effect = () => {

    const [a,setA]=useState(0);
    const [b,setB]=useState(0);

    const updateA=()=>{
        setA(a+1);
    }

    const updateB=()=>{
        setB(b+1);
    }


    useEffect(()=>{
        console.log("Component Did Mount");  
    },[a,b])


  return (
    <div>
        <hr></hr>
        <h2>
            This is from Effect Component
        </h2>
        <h3>A: {a}</h3>
        <h3>B: {b}</h3>
        <button onClick={updateA}>
            Increment A
        </button>

        <button onClick={updateB}>
            Increment B
        </button>
    </div>
  )
}

export default Effect