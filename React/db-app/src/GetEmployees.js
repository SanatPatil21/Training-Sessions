//

import axios from "axios";
import { useEffect, useState } from "react";

function GetEmployees() {

    const [employees, setEmployees] = useState([]);


    useEffect(() => {
        axios.get("http://localhost:4000/employees")
            .then((res) => {
                setEmployees(res.data);
                console.log(res.data);
            })
            .catch((err) => console.log(err))

    },[]);
    
    return (
        <div>
            <h3>
                Employee Details
            </h3>
            <table>
                <thead>
                    <tr>
                        <th>Emp ID</th>
                        <th>Name</th>
                        <th>Age</th>
                        <th>Salary</th>
                        <th>Designation</th>
                    </tr>

                </thead>

                {
                    employees.map((emp) => {
                        return (
                            <tbody key={emp.id}>
                                <tr>
                                    <td >{emp.id}</td>
                                    <td>{emp.name}</td>
                                    <td>{emp.age}</td>
                                    <td>{emp.salary}</td>
                                    <td>{emp.designation}</td>
                                </tr>
                            </tbody>
                        )
                    })
                }

            </table>


        </div>

    )
}

export default GetEmployees;