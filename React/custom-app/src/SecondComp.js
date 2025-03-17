import React from 'react'
import useCounter from './useCounter';

const SecondComp = () => {

    const [cnt, incr, decr] = useCounter();

    return (
        <div>
            <h2>Second Component</h2>
            <span>Count: { cnt }</span>
            <br></br>
            <button onClick={incr}>INCR</button>
            <button onClick={decr}>DECR</button>


        </div>
    )
  
}

export default SecondComp