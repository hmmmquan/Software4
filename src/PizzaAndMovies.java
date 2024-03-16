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

        public Builder pepperoni() {
            this.toppings.add("Pepperoni");
            return this;
        }

        public Builder sausage() {
            this.toppings.add("Sausage");
            return this;
        }

        public Builder mushrooms() {
            this.toppings.add("Mushrooms");
            return this;
        }

        public Builder bacon() {
            this.toppings.add("Bacon");
            return this;
        }

        public Builder onions() {
            this.toppings.add("Onions");
            return this;
        }

        public Builder extraCheese() {
            this.toppings.add("Extra Cheese");
            return this;
        }

        public Builder peppers() {
            this.toppings.add("Peppers");
            return this;
        }

        public Builder chicken() {
            this.toppings.add("Chicken");
            return this;
        }

        public Builder olives() {
            this.toppings.add("Olives");
            return this;
        }

        public Builder spinach() {
            this.toppings.add("Spinach");
            return this;
        }

        public Builder tomatoAndBasil() {
            this.toppings.add("Tomato and Basil");
            return this;
        }

        public Builder beef() {
            this.toppings.add("Beef");
            return this;
        }

        public Builder ham() {
            this.toppings.add("Ham");
            return this;
        }

        public Builder pesto() {
            this.toppings.add("Pesto");
            return this;
        }

        public Builder spicyPork() {
            this.toppings.add("Spicy Pork");
            return this;
        }

        public Builder hamAndPineapple() {
            this.toppings.add("Ham and Pineapple");
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
                .pepperoni()
                .sausage()
                .mushrooms()
                .build();

        Pizza medium = new Pizza.Builder("Medium")
                .bacon()
                .onions()
                .extraCheese()
                .peppers()
                .chicken()
                .olives()
                .build();

        Pizza large = new Pizza.Builder("Large")
                .spinach()
                .tomatoAndBasil()
                .beef()
                .ham()
                .pesto()
                .spicyPork()
                .hamAndPineapple()
                .pepperoni()
                .sausage()
                .build();

        small.eat();
        medium.eat();
        large.eat();

        //Part 2
        System.out.println("PART 2-----------------------");
        Pizza pizzaHut1 = new Pizza.Builder("Large")
                .chain("Pizza Hut")
                .pepperoni()
                .sausage()
                .mushrooms()
                .build();

        Pizza pizzaHut2 = new Pizza.Builder("Small")
                .chain("Pizza Hut")
                .bacon()
                .onions()
                .build();

        Pizza littleCaesars1 = new Pizza.Builder("Medium")
                .chain("Little Caesars")
                .extraCheese()
                .peppers()
                .chicken()
                .olives()
                .spinach()
                .tomatoAndBasil()
                .beef()
                .ham()
                .build();

        Pizza littleCaesars2 = new Pizza.Builder("Small")
                .chain("Little Caesars")
                .pesto()
                .spicyPork()
                .hamAndPineapple()
                .pepperoni()
                .sausage()
                .mushrooms()
                .build();

        Pizza dominos1 = new Pizza.Builder("Small")
                .chain("Dominos")
                .bacon()
                .build();

        Pizza dominos2 = new Pizza.Builder("Large")
                .chain("Dominos")
                .onions()
                .extraCheese()
                .peppers()
                .build();

        pizzaHut1.eat();
        pizzaHut2.eat();
        littleCaesars1.eat();
        littleCaesars2.eat();
        dominos1.eat();
        dominos2.eat();
    }
}
