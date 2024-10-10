package appdev.testfactory;

public class TestFactory {

    public static void main(String[] args) {
        Laptop min = LaptopFactory.getSpecs("min", 8, 256, "i5-12450Hz");
        System.out.println(min);

        Laptop reco = LaptopFactory.getSpecs("reco", 16, 512, "i7-12700Hz");
        System.out.println(reco);
    }
}
