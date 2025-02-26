
/*
 * 2/26/25
 * Sw Design with Java 
 * Jonathan Martinez 
 */


package Workers;

public class Manager extends Employee {
    private double bonus;
    
    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }
    
    @Override
    public double getAnnualIncome() {
        return getSalary() + bonus;
    }
}
