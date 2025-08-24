package techverito.model;

import techverito.constants.BasepackTypes;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Pack {
    private BasepackTypes packType;
    private int months;
    private BigDecimal monthlyPrice;
    private BigDecimal totalPrice;

    public Pack(BasepackTypes packType, int months) {
        this.packType = packType;
        this.months = months;
        this.monthlyPrice = BigDecimal.valueOf(packType.getValue()).setScale(2, RoundingMode.HALF_UP);
        calculateTotalPrice();
    }

    private void calculateTotalPrice() {
        this.totalPrice = packType.calculateCost(months);
    }

    public String getPackTypeName() {
        return packType.name();
    }

    public BasepackTypes getPackType() {
        return packType;
    }

    public BigDecimal getMonthlyPrice() {
        return monthlyPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
        calculateTotalPrice();
    }
}
