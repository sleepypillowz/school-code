package appdev.testfactory;

abstract class Laptop {

    public abstract int getRAM();
    public abstract int getSSD();
    public abstract String getCPU();

    @Override
    public String toString() {
        return "RAM=" + this.getRAM() + "GB, SSD=" + this.getSSD() + "GB, CPU=" + this.getCPU();
    }
}
