package week2;

public class Cart {
    Product[] products;

    public Cart(Product[] products) {
        this.products = products;
    }

    int calculateDeliveryCharge(){
        int totalDeliveryCharge = 0;
        int productsWeight = 0;
        int productsPrice = 0;

        for (Product product : products) {
            productsWeight = product.getWeight();
            productsPrice = product.getPrice() - product.getDiscountAmount();
        }

        if (productsWeight < 3){
            totalDeliveryCharge += 1000;
        } else if (productsWeight < 10){
            totalDeliveryCharge += 5000;
        } else {
            totalDeliveryCharge += 10000;
        }

        if (productsPrice >= 30000 && productsPrice < 100000){
            totalDeliveryCharge -= 1000;
        } else if (productsPrice >= 100000){
            totalDeliveryCharge = 0;
        }

        return totalDeliveryCharge;
    }
}
