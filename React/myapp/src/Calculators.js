import { useState } from "react"
import LoanCalculator from "./LoanCalculator";

function Calculators() {
    const [showLoanCalculator, setShowLoanCalculator] = useState(false);
    const handleLoanCalculatorClick = () => {
        setShowLoanCalculator(true);

    }

    return (
        <>
            <div className="calculators-container">
                <h1>
                    Manage Your Finances
                </h1>
                <button onClick={handleLoanCalculatorClick}>
                    Loan Calculator
                </button>
                <button>
                    Deposit Calculator
                </button>
            </div>
            {showLoanCalculator && <LoanCalculator/>}

        </>
    )
}

export default Calculators