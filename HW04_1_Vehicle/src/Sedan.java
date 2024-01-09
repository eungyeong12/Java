public class Sedan extends Vehicle {
    private int num_seats;

    public Sedan(String color, String vtype, int eng_capa, Person driver, int num_seats) {
        super(color, vtype, eng_capa, driver);
        this.num_seats = num_seats;
    }

    public String toString() {
        return getColor() + " Sedan (driver : " + getDriver() + ")";
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
