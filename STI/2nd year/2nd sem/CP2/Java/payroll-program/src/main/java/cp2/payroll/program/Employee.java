package cp2.payroll.program;

public class Employee extends FullTimeEmployee{
    
    private String name;
    
    public void setName(String newName) {
        name = newName;      
    }
    
    public String getName() {
    return name;
    }
}