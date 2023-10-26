package cp2.payroll.program;

public class PartTimeEmployee  {
    
    private double ratePerHour;
    private int hoursWorked;
    private double wage;
     
    public void setRatePerHour(double newRatePerHour) {
        ratePerHour = newRatePerHour;      
    }
      
    public double getRatePerHour() {
    return ratePerHour;
    }
    
    public void setHoursWorked(int newHoursWorked) {
        hoursWorked = newHoursWorked;      
    }
    
    public int getHoursWorked() {
    return hoursWorked;
    }

    public void setWage(double newWage) {
        wage = newWage;      
    }
      
    public double getWage() {
    return wage;
    }  
}