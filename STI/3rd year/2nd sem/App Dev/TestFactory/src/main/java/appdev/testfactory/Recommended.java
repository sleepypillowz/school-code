package appdev.testfactory;

class Recommended extends Laptop {
    private int ram;
    private int ssd;
    private String cpu;

    public Recommended(int ram, int ssd, String cpu) {
        this.ram = ram;
        this.ssd = ssd;
        this.cpu = cpu;
    }

    @Override
    public int getRAM() {
        return this.ram;
    }

    @Override
    public int getSSD() {
        return this.ssd;
    }

    @Override
    public String getCPU() {
        return this.cpu;
    }
}
