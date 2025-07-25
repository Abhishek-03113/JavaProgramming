public class SmartTransport {

    public static void main(String[] args) {

        Bus bus = new Bus("Bus", 20);
        Metro metro = new Metro("Metro", 30);
        BikeRental bikeRental = new BikeRental("BikeRental", 10);

        User alice = new User("Alice", 100, "alice@something.com");
        User bob = new User("Bob", 100);


        bikeRental.travel(alice);
        bikeRental.travel(alice);
        bikeRental.travel(alice);
        bus.travel(alice);
        bus.travel(alice);

        alice.printTravelLog();


        metro.travel(bob);
        metro.travel(bob);
        metro.travel(alice);


        alice.rechargeBalance(100);
        bikeRental.travel(bob);
        bob.rechargeBalance(30);


        bob.printTravelLog();

    }
}