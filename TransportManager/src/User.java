import java.util.HashMap;
import java.util.*;

public class User {
    private String name;
    private int balance;
    private String email;

    private Map<Transport, Integer> travelLog;
    private List<Transport> travelLogList;

    public List<Transport> getTravelLogList() {
        return travelLogList;
    }

    public void setTravelLogList(List<Transport> travelLogList) {
        this.travelLogList = travelLogList;
    }

    public Map<Transport, Integer> getTravelLog() {
        return travelLog;
    }

    public void setTravelLog(Map<Transport, Integer> travelLog) {
        this.travelLog = travelLog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String name, int balance, String email) {
        this.name = name;
        this.email = email;
        this.balance = balance;
        this.travelLog = new HashMap<>();
        this.travelLogList = new ArrayList<>();
        System.out.println("[User Created]" + name + "(Email:" + email + ")" + "- Balance:" + balance);
    }

    public User(String name, int balance) {
        this.name = name;
        this.balance = balance;
        this.travelLog = new HashMap<>();
        this.travelLogList = new ArrayList<>();
        System.out.println("[User Created]" + name + "(Email:" + "email not provided" + ")" + "- Balance:" + balance);

    }

    @Override
    public String toString() {
        return "Name " + name + "\n Current balance : " + balance;
    }

    public void rechargeBalance(int rechargeAmount) {
        System.out.println("Recharging Account of  " + name);
        balance += rechargeAmount;
        System.out.println("New account balance of  " + name + " is " + getBalance());
    }

    public void printTravelLog() {

        System.out.println(name + " ----Travel Log Start ---- ");
        travelLogList.forEach(log -> System.out.println(log.getTransportName() + " " + log.getUsageCost()));
        System.out.println("----Travel Log Finished ---- ");

    }

    public void printBalance() {
        System.out.println("[" + this.getName() + "]" + " Travel Log");
        System.out.println(balance);
    }
}
