public class Discount {

    private int discountId;
    private int percentage;
    private int flatDiscount;


    public Discount(int discountId, int percentage) {
        this.discountId = discountId;
        this.percentage = percentage;
        this.flatDiscount = 0;
    }

    public Discount(int discountId, int percentage, int flatDiscount) {
        this(discountId, percentage);
        this.flatDiscount = flatDiscount;
    }

    public int getDiscountId() {
        return discountId;
    }

    public int getPercentage() {
        return percentage;
    }

    public int getFlatDiscount() {
        return flatDiscount;
    }
}
