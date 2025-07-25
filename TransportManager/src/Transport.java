public abstract class Transport {

    private String transportName;
    private int usageCost;

    public Transport(String transportName, int usageCost) {
        this.transportName = transportName;
        this.usageCost = usageCost;
    }

    public String getTransportName() {
        return transportName;
    }

    public void setTransportName(String transportName) {
        this.transportName = transportName;
    }

    public int getUsageCost() {
        return usageCost;
    }

    public void setUsageCost(int usageCost) {
        this.usageCost = usageCost;
    }

    public void travel(User user) {
        if (user.getBalance() < this.getUsageCost()) {
            System.out.println("Insufficient Balance, Please recharge and try again !!! ");
            return;
        }

        user.getTravelLogList().add(this);
        System.out.println("[" + user.getName() + "]" + "  chooses  " + this.transportName);

        user.setBalance(user.getBalance() - usageCost);

        Integer oldLog = user.getTravelLog().get(this);
        if (oldLog != null) {
            user.getTravelLog().replace(this, oldLog, oldLog++);
        } else {
            user.getTravelLog().put(this, 1);
        }

        System.out.println("[" + user.getName() + "]" + " --Remaining Balance-- " + user.getBalance());

    }

    public void ticketingLogic(User user){

    }
}
