package cp2.payroll.program;

public abstract class FullTimeEmployee implements Employee.employeeInfo {

    private double monthlySalary;

    @Override
    public void setMonthlySalary(double newMonthlySalary) {
        monthlySalary = newMonthlySalary;
    }

    @Override
    public double getMonthlySalary() {
        return monthlySalary;
    }
}
