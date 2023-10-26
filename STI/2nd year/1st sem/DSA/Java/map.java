import java.util.*;

public class MyClass 
{
    public static void main(String args[]) 
    {
      
        //new map
        Map <String, String> nameMap = new HashMap<>();
      
        //content of the map
        nameMap.put("BSIT", "Bachelor of Science in Information Technology ");
        nameMap.put("BSCS", "Bachelor of Science in Computer Science ");
        nameMap.put("BSIS", "Bachelor of Science in Information Systems ");
      
        nameMap.remove("BSIT");
      
        //checks for BSCpE then returns a bool
        System.out.println(nameMap.containsKey("BSCpE"));
      
        //print the contents of the map
        for (Map.Entry e : nameMap.entrySet()) {
        System.out.print(e.getKey() + ": " +
        e.getValue());
        }
    }
}