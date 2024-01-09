public class Bus extends Vehicle {
    private int num_seats;
    private int num_passengers;
    public Bus(String color, String vtype, int eng_capa, Person driver, int num_seats) {
        super(color, vtype, eng_capa, driver);
        this.num_seats = num_seats;
    }

    public String toString() {
        return getColor() + " Bus (driver : " + getDriver() + ")";
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
