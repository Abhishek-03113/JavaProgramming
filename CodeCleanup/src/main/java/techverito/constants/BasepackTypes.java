package techverito.constants;

public enum BasepackTypes {

	SilverPack("Zee , Sony, StarPlus", "50"),
	GoldPack("Zee , Sony, StarPlus, Discovery, NatGeo", "100");
	
	String channels;
	String amount;
	
	private BasepackTypes(String channels, String amount) {
		this.channels = channels;
		this.amount = amount;
	}
	
	public String getChannels() {
		return channels;
	}
	
	public String getValue() {
		return amount;
	}

    public double calculateCost(int months){
        return months*Double.parseDouble(amount);
    }

}

