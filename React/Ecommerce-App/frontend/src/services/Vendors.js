import axios from "axios";

export const getAllVendors = () => {
    axios.get("http://localhost:4000/vendors")
        .then((res)=>{
            console.log(res.data);
            
            return res.data
            // console.log(vendorDetails);
        })
}