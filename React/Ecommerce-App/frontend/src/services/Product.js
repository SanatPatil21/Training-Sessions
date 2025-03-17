import axios from "axios";

export const buyProduct = (product) => {
    alert(`Buying ${product.productName} with Vendor Id: ${product.vendorId}`);
    product.productQuantity -= 1;
    axios.put(`http://localhost:4000/products/${product.id}`,product);
}


export const groupProductsByName = (products) => {
    const groupedProducts = products.reduce((acc, product) => {
        const { productName } = product;
        if (!acc[productName]) {
            acc[productName] = [];
        }
        acc[productName].push(product);
        acc[productName].sort((a, b) => a.productPrice - b.productPrice);
        return acc;
    }, {});
    return groupedProducts;
}
