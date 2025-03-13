import React, { use, useEffect, useRef, useState } from 'react';

function LoanCalculator() {
    //States for form data
    const [name, setName] = useState("");
    const [type, setType] = useState("Home")
    const [interestRate, setInterestRate] = useState(9);
    const [tenure, setTenure] = useState(0);
    const [amount, setAmount] = useState(0);
    const [monthlyPayment, setMonthlyPayment] = useState(null);
    const [tenureErrorMessage, setTenureErrorMessage] = useState("");
    const [amountErrorMessage, setAmountErrorMessage] = useState("");

    useEffect(() => {
        switch (type) {
            case "Home":
                setInterestRate(9);
                break;
            case "Car":
                setInterestRate(10);
                break;
            case "Personal":
                setInterestRate(11);
                break;
            default:
                setInterestRate(9);
                break;
        }
    }, [type])

    useEffect(() => {
        let errorMessage = "";
        switch (type) {
            case "Home":
                if (tenure > 30) {
                    errorMessage = "TENURE MUST BE LESS THAN 30 ";
                }
                break;
            case "Car":
                if (tenure > 7) {
                    errorMessage = "TENURE MUST BE LESS THAN 7";
                }
                break;
            case "Personal":
                if (tenure > 5) {
                    errorMessage = "TENURE MUST BE LESS THAN 5";
                }
                break;
            default:
                break;
        }
        setTenureErrorMessage(errorMessage);
    }, [tenure, type]);

    useEffect(() => {
        let errorMessage = "";
        switch (type) {
            case "Home":
                if (amount < 500000 || amount > 10000000) {
                    errorMessage = "AMOUNT MUST BE BETWEEN 5,00,000 AND 1,00,00,000";
                }
                break;
            case "Car":
                if (amount < 100000 || amount > 500000) {
                    errorMessage = "AMOUNT MUST BE BETWEEN 1,00,000 AND 5,00,000";
                }
                break;
            case "Personal":
                if (amount < 10000 || amount > 500000) {
                    errorMessage = "AMOUNT MUST BE BETWEEN 10,000 AND 5,00,000";
                }
                break;
            default:
                break;
        }
        setAmountErrorMessage(errorMessage);
    }, [amount, type]);

   

    function calculate() {
        const principal = amount;
        const monthlyInterestRate = interestRate / 100 / 12;
        const numberOfPayments = tenure * 12;

        if (monthlyInterestRate === 0) {
            setMonthlyPayment(principal / numberOfPayments);
        } else {
            const monthlyPayment = (principal * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));
            setMonthlyPayment(monthlyPayment);
        }
    }

    const handleSubmit = (e) => {
        e.preventDefault();

        calculate();
    }


    return (
        <div className='loan-calculator-container'>
            <h2>Loan Calculator</h2>
            <form onSubmit={handleSubmit}>
                Applicant's Name: <input type='text' placeholder='Enter Name' required></input>
                <br></br>
                Select Type of Loan: <select value={type} onChange={(e) => { setType(e.target.value) }}>
                    <option value="Home">Home Loan</option>
                    <option value="Car">Car Loan</option>
                    <option value="Personal">Personal Loan</option>
                </select>
                <br></br>
                Interest Rate: <input type="number" value={interestRate} readOnly onChange={(e) => setTenure(e.target.value)} required></input>
                <br></br>
                Loan Amount: <input type='number' placeholder='Enter Loan Amount' value={amount} onChange={(e) => setAmount(e.target.value)} required />
                {amountErrorMessage && <p className='error-message'>{amountErrorMessage}</p>}   
                <br />
                Tenure: <input type='number' placeholder='Enter Tenure' value={tenure} onChange={(e) => setTenure(e.target.value)} required />
                {tenureErrorMessage && <p className='error-message'>{tenureErrorMessage}</p>}

                <button type='submit'>CALCULATE</button>
            </form>
            {monthlyPayment !== null && (
                <div className='emi-result'>
                    <h3>Monthly Payment: Rs{monthlyPayment.toFixed(2)}</h3>
                </div>
            )}
        </div>
    );
}

export default LoanCalculator;