package techverito.model;

import techverito.constants.Messages;
import techverito.constants.BasepackTypes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class User {

    private BigDecimal balance = new BigDecimal("105.34").setScale(2, RoundingMode.HALF_UP).stripTrailingZeros();
    private BasepackTypes currSubscription;
    private String email;
    private String phone;
    
    public User() {
        
    }
    
    public void setBalance(double value) {
        balance = new BigDecimal(""+value);
    }
    
    public String getBalance() {
        return balance.toPlainString();
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BasepackTypes getSubcription() {
        return currSubscription;
    }
    
    public void setSubscription(BasepackTypes subscription) {
        this.currSubscription = subscription;
    }
}
