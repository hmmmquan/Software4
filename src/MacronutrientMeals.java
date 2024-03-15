import java.util.*;

class Customer {
    String name;
    String dietPlan;

    public Customer(String name, String dietPlan) {
        this.name = name;
        this.dietPlan = dietPlan;
    }
}

interface Carbs { String getName(); }
interface Protein { String getName(); }
interface Fats { String getName(); }

class Cheese implements Carbs { public String getName() { return "Cheese"; } }
class Bread implements Carbs { public String getName() { return "Bread"; } }
class Lentils implements Carbs { public String getName() { return "Lentils"; } }
class Pistachio implements Carbs { public String getName() { return "Pistachio"; } }
class Fish implements Protein { public String getName() { return "Fish"; } }
class Chicken implements Protein { public String getName() { return "Chicken"; } }
class Beef implements Protein { public String getName() { return "Beef"; } }
class Tofu implements Protein { public String getName() { return "Tofu"; } }
class Avocado implements Fats { public String getName() { return "Avocado"; } }
class SourCream implements Fats { public String getName() { return "Sour Cream"; } }
class Tuna implements Fats { public String getName() { return "Tuna"; } }
class Peanuts implements Fats { public String getName() { return "Peanuts"; } }

interface MacronutrientFactory {
    Carbs getCarbs();
    Protein getProtein();
    Fats getFats();
}

class DietPlanFactory {
    private static final Map<String, MacronutrientFactory> dietPlanFactories = new HashMap<>();

    public static MacronutrientFactory getFactory(String dietPlan) {
        if (!dietPlanFactories.containsKey(dietPlan)) {
            switch (dietPlan) {
                case "No Restriction":
                    dietPlanFactories.put(dietPlan, new NoRestriction());
                    break;
                case "Paleo":
                    dietPlanFactories.put(dietPlan, new Paleo());
                    break;
                case "Vegan":
                    dietPlanFactories.put(dietPlan, new Vegan());
                    break;
                case "Nut Allergy":
                    dietPlanFactories.put(dietPlan, new NutAllergy());
                    break;
            }
        }
        return dietPlanFactories.get(dietPlan);
    }
}

class NoRestriction implements MacronutrientFactory {
    private final Random rand = new Random();
    private final List<Carbs> carbs = Arrays.asList(new Cheese(), new Bread(), new Lentils(), new Pistachio());
    private final List<Protein> proteins = Arrays.asList(new Fish(), new Chicken(), new Beef(), new Tofu());
    private final List<Fats> fats = Arrays.asList(new Avocado(), new SourCream(), new Tuna(), new Peanuts());

    public Carbs getCarbs() { return carbs.get(rand.nextInt(carbs.size())); }
    public Protein getProtein() { return proteins.get(rand.nextInt(proteins.size())); }
    public Fats getFats() { return fats.get(rand.nextInt(fats.size())); }
}

class Paleo implements MacronutrientFactory {
    private final Random rand = new Random();
    private final List<Carbs> carbs = List.of(new Pistachio());
    private final List<Protein> proteins = Arrays.asList(new Fish(), new Chicken(), new Beef());
    private final List<Fats> fats = Arrays.asList(new Avocado(), new Tuna(), new Peanuts());

    public Carbs getCarbs() { return carbs.get(rand.nextInt(carbs.size())); }
    public Protein getProtein() { return proteins.get(rand.nextInt(proteins.size())); }
    public Fats getFats() { return fats.get(rand.nextInt(fats.size())); }
}

class Vegan implements MacronutrientFactory {
    private final Random rand = new Random();
    private final List<Carbs> carbs = Arrays.asList(new Bread(), new Lentils(), new Pistachio());
    private final List<Protein> proteins = List.of(new Tofu());
    private final List<Fats> fats = Arrays.asList(new Avocado(), new Peanuts());

    public Carbs getCarbs() { return carbs.get(rand.nextInt(carbs.size())); }
    public Protein getProtein() { return proteins.get(rand.nextInt(proteins.size())); }
    public Fats getFats() { return fats.get(rand.nextInt(fats.size())); }
}

class NutAllergy implements MacronutrientFactory {
    private final Random rand = new Random();
    private final List<Carbs> carbs = Arrays.asList(new Cheese(), new Bread(), new Lentils());
    private final List<Protein> proteins = Arrays.asList(new Fish(), new Chicken(), new Beef(), new Tofu());
    private final List<Fats> fats = Arrays.asList(new Avocado(), new SourCream(), new Tuna());

    public Carbs getCarbs() { return carbs.get(rand.nextInt(carbs.size())); }
    public Protein getProtein() { return proteins.get(rand.nextInt(proteins.size())); }
    public Fats getFats() { return fats.get(rand.nextInt(fats.size())); }
}

public class MacronutrientMeals {
    public static void main(String[] args) {
        List<Customer> customers = Arrays.asList(
                new Customer("AAA", "No Restriction"),
                new Customer("BBB", "Paleo"),
                new Customer("CCC", "Vegan"),
                new Customer("DDD", "Nut Allergy"),
                new Customer("EEE", "No Restriction"),
                new Customer("FFF", "Paleo")
        );

        for (Customer customer : customers) {
            MacronutrientFactory factory = DietPlanFactory.getFactory(customer.dietPlan);
            Carbs carb = factory.getCarbs();
            Protein protein = factory.getProtein();
            Fats fat = factory.getFats();
            System.out.println("Customer: " + customer.name);
            System.out.println("Diet plan: " + customer.dietPlan);
            System.out.println("Carb: " + carb.getName() +
                                "\nProtein: " + protein.getName() +
                                "\nFat: " + fat.getName());
            System.out.println();
        }
    }
}
