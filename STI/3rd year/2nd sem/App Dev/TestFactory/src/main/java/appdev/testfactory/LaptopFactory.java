package appdev.testfactory;

class LaptopFactory {

    public static Laptop getSpecs(String type, int ram, int ssd, String cpu) {
        if ("min".equalsIgnoreCase(type)) {
            return new Minimum(ram, ssd, cpu);
        } else if ("reco".equalsIgnoreCase(type)) {
            return new Recommended(ram, ssd, cpu);
        }
        return null;
    }
}
