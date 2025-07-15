import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface validation {
    boolean validator();
}

public class User {
    private final String name;
    private final Age age;
    private final MobileNumber mobileNumber;
    private final Email email;

    public User(String name, Age age, MobileNumber mobileNumber, Email email) {
        this.name = name;
        this.age = age;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }
}

class Age implements validation {
    int age;

    public Age(int age) {
        this.age = age;
    }

    public boolean validator() {
        return age > 0 && age <= 100;
    }
}

class MobileNumber implements validation {
    long mobileNumber;

    public MobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public boolean validator() {
        String mobileNumberString = String.valueOf(this.mobileNumber);
        return mobileNumberString.length() == 10;

    }
}

class Email implements validation {
    String email;

    public Email(String email) {
        this.email = email;
    }

    public boolean validator() {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}