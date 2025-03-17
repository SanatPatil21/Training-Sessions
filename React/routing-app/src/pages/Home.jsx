import React from 'react'
import Header from '../components/Header'
import { useNavigate } from 'react-router-dom';

const Home = () => {
    let flag= false;
    const navigate = useNavigate();
    function goTo(){
        if(flag){
            navigate('/about');
            flag = false;
        }
        else{
            navigate('/services');
            flag = true;
        }
    }

    return (
        <div>
            <Links
            <h2>
                Home Page
            </h2>
            <hr>
            </hr>
            <p>
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolorem quo delectus consequatur distinctio vel itaque ullam nam incidunt accusamus quibusdam? Repudiandae eum dolores ipsa consequuntur assumenda quia modi excepturi, consequatur saepe itaque, esse animi quos rem ad labore tenetur nulla.
            </p>
            <button onClick={goTo}>CLICK HERE</button>
        </div>
    )
}

export default Home