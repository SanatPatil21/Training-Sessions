import axios from 'axios';

export const createOrder = async (orderDetails) => {
    try {
        
        console.log(orderDetails);
        
        // Updating the Orders DB
        const orderDetailsToPost={
            userId:orderDetails.userId,
            productId: orderDetails.productId,
            vendorId: orderDetails.vendorId,
            orderDate: new Date().toISOString()
        }
        await axios.post('http://localhost:4000/orders', orderDetailsToPost);

        // Updating the Product Stock
        const product = orderDetails.product;
        const updatedProduct = {
            ...product,
            productQuantity: product.productQuantity - 1
        };

        await axios.put(`http://localhost:4000/products/${product.id}`, updatedProduct);

        console.log('Order created and product quantity updated successfully');
    } catch (error) {
        console.error('Error creating order:', error);
    }
};