package cp2.payroll.program;

public abstract class PartTimeEmployee implements Employee.employeeInfo {

    private double ratePerHour;
    private int hoursWorked;
    private double wage;

    @Override
    public void setRatePerHour(double newRatePerHour) {
        ratePerHour = newRatePerHour;
    }

    @Override
    public double getRatePerHour() {
        return ratePerHour;
    }

    @Override
    public void setHoursWorked(int newHoursWorked) {
        hoursWorked = newHoursWorked;
    }

    @Override
    public int getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public void setWage(double newWage) {
        wage = newWage;
    }

    @Override
    public double getWage() {
        return wage;
    }
}
