import java.util.Random;


public class Profile extends User{
    private String username;
    private String password;
    Random random = new Random();
    public  Profile(String username, String password, String name, int age, long mobileNumber, String email) {
        super(name, age, mobileNumber, email);
        this.username = username;
        this.password = password;
        int userID = random.nextInt(10000);
    }
}
