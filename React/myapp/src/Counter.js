import { useState } from "react"

function Counter(){
    // let count = 0 ;
    const [count,setCount] = useState(0);

    function incrCounter(){
        setCount(count+1);
    }

    function decrCounter(){
        setCount(count-1);
    }

    return(
        <div>
            <h3>State Demo</h3>
            <h3>Counter: {count} </h3>
            <button onClick={incrCounter}>INCREMENT</button>
            <button onClick={decrCounter}>DECREMENT</button>
        </div>
    )
}

export default Counter