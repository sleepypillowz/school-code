package cp2.p.info;

public class PInfo {

    public static void main(String[] args) {
        
        //initialize variables
        final int num = 26; //favorite number
        final String ctc = "Fullmetal Alchemist"; //favorite cartoon character
        final char mi = 'B'; 
        final char[] name = {'a','l','e','x'}; 
        
        //print to console
        System.out.println(num + " is my favorite number.");
        System.out.println("I love " + ctc + "!");
        System.out.println("My name is Alexander Thomas " + mi + " Acojido"); 
        System.out.print("You can call me ");    
        for (int i = 0; i < name.length; i++){
            System.out.print(name[i]);
        }
    }
}