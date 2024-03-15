import java.util.ArrayList;
import java.util.List;

class Pizza {
    private final String chain;
    private final String size;
    private final List<String> toppings;

    private Pizza(Builder builder) {
        this.chain = builder.chain;
        this.size = builder.size;
        this.toppings = builder.toppings;
    }

    public void eat() {
        System.out.println(this.chain +
                            "\nSize: " + this.size +
                            "\n" + this.toppings.size() + " Toppings: " + String.join(", ", this.toppings) +
                            "\n");
    }

    public static class Builder {
        private String chain = "Pizza Hut";
        private final String size;
        private final List<String> toppings = new ArrayList<>();

        public Builder(String size) {
            this.size = size;
        }

        public Builder chain(String chain) {
            this.chain = chain;
            return this;
        }

        public Builder addTopping(String topping) {
            this.toppings.add(topping);
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}

public class PizzaAndMovies {
    public static void main(String[] args) {
        //Part 1
        System.out.println("PART 1-----------------------");
        Pizza small = new Pizza.Builder("Small")
                .addTopping("Pepperoni")
                .addTopping("Sausage")
                .addTopping("Mushrooms")
                .build();

        Pizza medium = new Pizza.Builder("Medium")
                .addTopping("Bacon")
                .addTopping("Onions")
                .addTopping("Extra Cheese")
                .addTopping("Peppers")
                .addTopping("Chicken")
                .addTopping("Olives")
                .build();

        Pizza large = new Pizza.Builder("Large")
                .addTopping("Spinach")
                .addTopping("Tomato and Basil")
                .addTopping("Beef")
                .addTopping("Ham")
                .addTopping("Pesto")
                .addTopping("Spicy Pork")
                .addTopping("Ham and Pineapple")
                .addTopping("Pepperoni")
                .addTopping("Sausage")
                .build();

        small.eat();
        medium.eat();
        large.eat();

        //Part 2
        System.out.println("PART 2-----------------------");
        Pizza pizzaHut1 = new Pizza.Builder("Large")
                .chain("Pizza Hut")
                .addTopping("Pepperoni")
                .addTopping("Sausage")
                .addTopping("Mushrooms")
                .build();

        Pizza pizzaHut2 = new Pizza.Builder("Small")
                .chain("Pizza Hut")
                .addTopping("Bacon")
                .addTopping("Onions")
                .build();

        Pizza littleCaesars1 = new Pizza.Builder("Medium")
                .chain("Little Caesars")
                .addTopping("Extra Cheese")
                .addTopping("Peppers")
                .addTopping("Chicken")
                .addTopping("Olives")
                .addTopping("Spinach")
                .addTopping("Tomato and Basil")
                .addTopping("Beef")
                .addTopping("Ham")
                .build();

        Pizza littleCaesars2 = new Pizza.Builder("Small")
                .chain("Little Caesars")
                .addTopping("Pesto")
                .addTopping("Spicy Pork")
                .addTopping("Ham and Pineapple")
                .addTopping("Pepperoni")
                .addTopping("Sausage")
                .addTopping("Mushrooms")
                .build();

        Pizza dominos1 = new Pizza.Builder("Small")
                .chain("Dominos")
                .addTopping("Bacon")
                .build();

        Pizza dominos2 = new Pizza.Builder("Large")
                .chain("Dominos")
                .addTopping("Onions")
                .addTopping("Extra Cheese")
                .addTopping("Peppers")
                .build();

        pizzaHut1.eat();
        pizzaHut2.eat();
        littleCaesars1.eat();
        littleCaesars2.eat();
        dominos1.eat();
        dominos2.eat();
    }
}
