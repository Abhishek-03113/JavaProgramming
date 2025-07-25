public class BikeRental extends Transport {

    public BikeRental(String transportName, int usageCost) {

        super(transportName, usageCost);
    }

    @Override
    public void travel(User user) {

        if (user.getBalance() < this.getUsageCost()) {
            System.out.println("Insuffiecient Balance, Please recharge and try again !!! ");
            return;
        }
        System.out.println(user.getName() + "  chooses  " + this.getTransportName());

        Integer old = user.getTravelLog().get(this);

        if (old != null && old >= 2) {
            System.out.println("you've got 50% discount for choosing us \n");
            user.setBalance(user.getBalance() - this.getUsageCost() / 2);
            user.getTravelLog().replace(this, old, old + 1);
        } else if (old == null) {
            user.setBalance(user.getBalance() - this.getUsageCost());
        } else {
            user.setBalance(user.getBalance() - this.getUsageCost());
        }
        user.getTravelLogList().add(this);


        System.out.println("[" + user.getName() + "]" + "  --Remaining Balance--  " + user.getBalance());
    }
}