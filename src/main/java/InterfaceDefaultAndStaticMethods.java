/*
Interface Default and Static Methods
Starting with Java 8, interfaces can have static and default methods that, despite being declared in an interface, have a defined behavior.
https://www.baeldung.com/java-8-new-features
 */
public class InterfaceDefaultAndStaticMethods {

    interface Vehicle {
        static String producer() { return "N&F Vehicles"; }
        default String getOverview() {return "ATV made by " + producer(); }
    }

    class VehicleImpl implements Vehicle { }

    public void execute() {
        String producer = Vehicle.producer();
        System.out.println(producer);       // N&F Vehicles

        Vehicle vehicle = new VehicleImpl();
        String overview = vehicle.getOverview();
        System.out.println(overview);       // ATV made by N&F Vehicles
    }

    public static void main(String[] args) {
        InterfaceDefaultAndStaticMethods interfaceDefaultAndStaticMethods = new InterfaceDefaultAndStaticMethods();
        interfaceDefaultAndStaticMethods.execute();
    }
}