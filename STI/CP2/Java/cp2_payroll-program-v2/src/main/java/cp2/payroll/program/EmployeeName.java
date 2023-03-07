package cp2.payroll.program;

public abstract class EmployeeName implements Employee.employeeInfo {

    private String name;

    @Override
    public void setName(String newName) {
        name = newName;
    }

    @Override
    public String getName() {
        return name;
    }
}
