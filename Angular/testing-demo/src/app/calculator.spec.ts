import { Calculator } from "./calculator"

describe("Calculator Class Testing", () => {
    let cal:Calculator;
    beforeEach(()=>{
        cal=new Calculator();
    })

    it("Addition Testing", () => {
        let result = cal.add(22,33)
        expect(result).toBe(55);
    })

    it("Subtraction Testing", () => {
        let result = cal.sub(33,22)
        expect(result).toBe(11);
    })

    it("Multiplication Testing", () => {
        let result = cal.mul(5,3)
        expect(result).toBe(15);
    })

    it("Division Testing", () => {
        let result = cal.div(50,2)
        expect(result).toBe(25);
    })
})