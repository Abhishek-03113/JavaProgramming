package techverito.model;

import techverito.constants.BasepackTypes;

public class Pack {

    String packType;
    String monthlyPrice;
    int months;

    public String getPackType() {
        return switch (packType) {
            case "G" -> "Gold";
            case "S" -> "Silver";
            default -> "";
        };
    }

    public void setPackType(String packType) {
        this.packType = packType;
    }

    public String getMonthlyPrice() {
        return monthlySubscriptionPrice(getPackType());
    }

    private String monthlySubscriptionPrice(String packType) {
        if (getPackType().equals("Gold")) return BasepackTypes.GoldPack.getValue();
        else if (getPackType().equals("Silver")) {
            return BasepackTypes.SilverPack.getValue();
        }
        return BasepackTypes.GoldPack.getValue();
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

}
