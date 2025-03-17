import React from 'react'
import useCounter from './useCounter'

const FirstComp = () => {

    const [cnt, incr, decr] = useCounter(3);

    return (
        <div>
            <h2>First Component</h2>
            <span>Count: { cnt }</span>
            <br></br>
            <button onClick={incr}>INCR</button>
            <button onClick={decr}>DECR</button>


        </div>
    )
}

export default FirstComp