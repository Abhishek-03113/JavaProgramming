package techverito.constants;

/*
 * This class contains all string messages used in the application.
 */
public final class Messages {

	private Messages() {
		
	}
	
	static public String welcomeMessage = "Welcome to SatTV \n"+
							"1. View account balance and current subscription\n"+
							"2. Recharge Account\n"+
							"3. View available packs and channels\n"+
							"4. Subscribe to base packs\n"+
							"5. Add channels to an existing subscription\n"+
							"6. Update email and phone number for notifications\n"+
							"7. Exit";
	
	static public String selectOption = "Enter the option:";
	static public String balance = "Account balance is %s Rs.";
	static public String notSubscribed = "Not subscribed";
	static public String currSubscription = "Current subscription: %s ";
	static public String rechargeAmount = "Enter the amount to recharge:";
	static public String rechargeSuccessful = "Recharge completed successfully.Current balance is %s";
	static public String availablePacks = "Available packs for subscription";
	static public String availableChannels = "Available channels for subscription";
	static public String enterPack = "Enter the pack you wish to subscribe: (Silver: 'S',Gold: 'G'):";
	static public String enterMonths = "Enter the months:";
	static public String successfulSubscription = "You have successfully subscribed the following pack - %s";
	static public String monthlyPrice = "Monthly price: %s Rs.";
	static public String numMonths = "No. of months: %s";
	static public String subscriptionAmount = "Subscription Amount: %s Rs.";
	static public String discountApplied = "Discount applied: %s Rs.";
	static public String finalPrice = "Final price after discount: %s Rs.";
	static public String emailNotification = "Email notification sent successfully";
	static public String smsNotification = "SMS notification sent successfully";
	static public String channelNames = "Enter channel names to add(separated by commas):";
	static public String channelsAdded = "Channels added successfully";
	static public String updateEmail_Phone = "Update email and phone number for notifications";
	static public String enterEmail = "Enter the email:";
	static public String enterPhone = "Enter phone:";
	static public String emailPhoneUpdated = "Email and phone updated successfully";
	static public String insufficientBalance = "Insufficient Balance";
	
	
	
}
