import './App.css';
import GetEmployees from './GetEmployees';
import AddEmployees from './AddEmployees';

function App() {
  return (
    <div className="App">
      <h1>
        Employee Management Application
      </h1>
      <hr></hr>
      <AddEmployees/>
      <GetEmployees />
    </div>
  );
}

export default App;
