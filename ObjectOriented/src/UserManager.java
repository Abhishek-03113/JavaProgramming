import java.util.ArrayList;

class MathUtils {
    public static int square(int x) {
        return x * x;
    }
}


class User {
    public String username;
    public String name;
    public int age;
    private int account_no;
    private int account_balance;

    public User(String username, String name, int age, int account_no, int account_balance) {
        this.username = username;
        this.name = name;
        this.age = age;
        this.account_no = account_no;
        this.account_balance = account_balance;
    }

    public int getAccount_no() {
        return account_no;
    }

    public void setAccount_no(int account_no) {
        this.account_no = account_no;
    }

    public int getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(int account_balance) {
        this.account_balance = account_balance;
    }
}

public class UserManager {
    private final ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUsers() {
        return users;
    }

    public void CreateUser(String username, String name, int age, int account_no, int account_balance) {
        users.add(new User(username, name, age, account_no, account_balance));
    }

    public void DeleteUser(String username) {
        users.removeIf(user -> user.username.equals(username));
    }

    public static void main(String[] args) {
        UserManager manager = new UserManager();
        int result = MathUtils.square(10);
        MathUtils obj = new MathUtils();

        int result_ = obj.square(10);

        System.out.println(result_);
        System.out.println(result);
    }
}

