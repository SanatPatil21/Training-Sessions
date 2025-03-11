import { addition } from "./testingFunction"

describe("Calculation Testing",()=>{
    it("Testing Add Function",()=>{
        expect(addition(11,22)).toBe(33)
    })
})


describe("String Testing",()=>{
    let i=0;

    beforeEach(()=>{
        console.log('Before Each Test Case:'+ ++i);    
    })

    afterEach(()=>{
        console.log('BefAfterore Each Test Case:'+ i);
    })

    beforeAll(()=>{
        console.log("-----------STARTED----------------");
    })

    afterAll(()=>{
        console.log("-----------FINISHED---------------");
    })
    
    it('Testing string equality using toBe',()=>{
        let string = "Hello Everybody";
        expect(string).toBe("Hello Everybody")
    })

    it('Testing string equality using toEqual',()=>{
        let string = "Hello Everybody";
        expect(string).toEqual("Hello Everybody")
    })

    it('Testing String with REGEX',()=>{
        let string="Happy New Year 2025"
        expect(string).toMatch(/\d+/)
    })
})

describe("Testing with Deep Checking",()=>{
    it("Testing JSON",()=>{
        let e1={"name":"Sanat","age":32};
        expect(e1).toEqual({"name":"Sanat","age":32})
    })

    it("Testing for Arrays",()=>{
        let arr1=[123,256,345,456,567];
        expect(arr1).toEqual([123,256,345,456,567])
    })
})