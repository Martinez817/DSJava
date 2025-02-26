package Workers;
/*
 * Using the provided classes (see links above), create a new class called Executive that inherits the traits and behaviors of the Manager class:
In addition to the name, salary, and bonus that a Manager has, Executives can also be granted shares of the company stock.
Modify the Executive class so that it has public methods to get and set the number of shares that an executive currently owns (as a double)
Also override the displayInfo() method for the Executive class to include the number of shares that the Executive currently owns

 * 
 * 
 */
public class Executive extends Manager{
    private double shares;
    private String name;
    private double salary;
    private double bonus;
    
    public Executive(String name, double salary, double bonus, double shares) {
        super(name, salary, bonus);
        this.name = name;
        this.salary = salary;
        this.bonus = bonus;
        this.shares = shares;
    }
    
    public double getShares() {
        return shares;
    }
    
    public void setShares(double newShares) {
        shares = newShares;
    }
    
    public double getAnnualIncome() {
        return salary + bonus;
    }
    
    public void displayInfo() {
        System.out.println(name + ":");
        System.out.printf("  Salary = $%,12.2f%n", salary);
        System.out.printf("  Bonus  = $%,12.2f%n", bonus);
        System.out.printf("  Shares = $%,12.2f%n", shares);
    }
}
