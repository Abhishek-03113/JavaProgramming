package techverito.constants;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public enum BasepackTypes {

    SilverPack(List.of(Channels.Zee, Channels.Sony, Channels.StarPlus), 50.00),
    GoldPack(List.of(Channels.Zee, Channels.Sony, Channels.StarPlus, Channels.Discovery, Channels.NetGeo), 100.00);

    private final List<Channels> channels;
    private final Double amount;

    private BasepackTypes(List<Channels> channels, Double amount) {
        this.channels = channels;
        this.amount = amount;
    }

    public List<Channels> getChannels() {
        return channels;
    }

    public Double getValue() {
        return amount;
    }

    public BigDecimal calculateCost(int months) {
        return BigDecimal.valueOf(amount).setScale(2, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(months)).setScale(2, RoundingMode.HALF_UP);
    }
}