public class Vehicle implements I_Drive {
    private String v_type; //vehicle type: Sedan, Bus, Truck
    private int eng_capa;
    private String v_color;
    private Person driver;

    public Vehicle(String color, String vtype, int eng_capa, Person driver) {
        this.v_color = color;
        this.v_type = vtype;
        this.eng_capa = eng_capa;
        this.driver = driver;
    }

    public String toString() {
        return "";
    }

    public String getVtype() {
        return v_type;
    }

    public int getEngCapa() {
        return eng_capa;
    }

    public String getColor() {
        return v_color;
    }

    public String getDriver() {
        return driver.getName();
    }

    @Override
    public void foward(int speed) {
        System.out.print(" moving forward at speed " + speed + " km/h; ");
    }

    @Override
    public void turn(int angle) {
        System.out.print("turning " + angle + " degree; ");
    }

    @Override
    public void stop() {
        System.out.print("stopping; ");
    }
}
