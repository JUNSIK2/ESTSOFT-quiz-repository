package week2;

public class Grocery extends Product{

    public Grocery(String name, int price, int weight) {
        super(name, price, weight);
    }

    @Override
    public int getDiscountAmount() {
        return 2000;
    }
}

