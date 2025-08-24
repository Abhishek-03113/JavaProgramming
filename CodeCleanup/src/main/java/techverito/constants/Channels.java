package techverito.constants;

public enum Channels {
	
	Zee("10"), Sony("15"), StarPlus("20"), Discovery("10"), NetGeo("20");
	public String value;
	
	private Channels(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
