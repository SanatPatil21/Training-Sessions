import JsxDemo from "./JsxDemo";
import Greet from "./Greet"
import Counter from "./Counter";
import Welcome from "./Welcome";
import Calculators from "./Calculators"


function App() {
  const a = 10;
  let b=20;


  return (
    <div>
      
      {/* <h1>This is my first React Application</h1> 
      <JsxDemo />
      <h2>Sum of {a} and {b} is :{a+b}</h2>
      {
        (a=>10)?"Good Morning":"Good Evening"
      }

      <Greet day="Morning" name="Sanat"></Greet>
      <Greet day="Afternoon" name="Karan"></Greet>
      <Greet day="Night" name="Maddy"></Greet>

      <Counter/>
      <Welcome/>
      */}
      <Calculators/>
    </div>
  );
}

export default App;
