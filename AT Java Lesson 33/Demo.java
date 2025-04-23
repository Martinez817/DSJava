class Animal implements Comparable<Animal> {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Animal other) {
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return name + " (Age: " + age + ")";
    }
}

public class Demo {
    public static void main(String[] args) {
        Animal dog = new Animal("Dog", 5);
        Animal cat = new Animal("Cat", 3);

        System.out.println("Comparing animals:");
        System.out.println(dog + " vs " + cat);

        int comparison = dog.compareTo(cat);
        if (comparison > 0) {
            System.out.println(dog.getName() + " is older than " + cat.getName());
        } else if (comparison < 0) {
            System.out.println(dog.getName() + " is younger than " + cat.getName());
        } else {
            System.out.println(dog.getName() + " and " + cat.getName() + " are the same age.");
        }
    }
}
