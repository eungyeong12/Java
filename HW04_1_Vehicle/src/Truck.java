public class Truck extends Vehicle {
    private int cargo_capa; // cargo capacity in ton
    public Truck(String color, String vtype, int eng_capa, Person driver, int cargo_capa) {
        super(color, vtype, eng_capa, driver);
        this.cargo_capa = cargo_capa;
    }
    public String toString() {
        return getColor() + " Truck (driver : " + getDriver() + ")";
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
