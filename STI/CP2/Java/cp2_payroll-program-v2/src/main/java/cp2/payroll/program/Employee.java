package cp2.payroll.program;

public class Employee  {
    
    private String name;

    
    public void setName(String newName) {
        name = newName;
    }

    
    public String getName() {
        return name;
    }
    
    
    
    interface employeeInfo {

        //EmployeeName
        public void setName(String newName);

        public String getName();

        //FullTimeEmployee
        public void setMonthlySalary(double newMonthlySalary);

        public double getMonthlySalary();

        //PartTimeEmployee
        public void setRatePerHour(double newRatePerHour);

        public double getRatePerHour();

        public void setHoursWorked(int newHoursWorked);

        public int getHoursWorked();

        public void setWage(double newWage);

        public double getWage();
    }

}
