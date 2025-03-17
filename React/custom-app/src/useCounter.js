import { useState } from "react";

function useCounter(arg=0){
    const [count,setCount] = useState(arg);

    function increment(){
        setCount(count+1);
    }

    function decrement(){
        setCount(count-1);
    }

    return [count,increment,decrement]

}

export default useCounter;