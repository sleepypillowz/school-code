package cp2.payroll.program;

public class FullTimeEmployee extends PartTimeEmployee {
    
    private double monthlySalary;
    
    public void setMonthlySalary(double newMonthlySalary) {
        monthlySalary = newMonthlySalary;      
    }
    
    public double getMonthlySalary() {
    return monthlySalary;
    }
}