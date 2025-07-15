

public class Bank {
    public static void main(String[] args) {
        UserManager manager = new UserManager();
        manager.getUsers().forEach(System.out::println);

    }
}