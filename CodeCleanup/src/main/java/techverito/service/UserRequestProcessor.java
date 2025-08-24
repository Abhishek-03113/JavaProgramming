package techverito.service;

import techverito.application.InputReader;
import techverito.constants.BasepackTypes;
import techverito.constants.Channels;
import techverito.constants.Messages;
import techverito.model.Pack;
import techverito.model.User;
import techverito.util.Logging;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class UserRequestProcessor {
	
	NotificationService service;
	private InputReader inputReader;

	public UserRequestProcessor(InputReader inputReader) {
		this.inputReader = inputReader;
	}
	
	/*
	 * This method will process user input and display result
	 */
	public void process(String input, User user) {
		switch(input) {
		case "1":
			processSelection1(user);
			break;
		case "2":
			processSelection2(user);
			break;
		case "3":
			processSelection3(user);
			break;
		case "4":
			processSelection4(user);
			break;
		case "5":
			processSelection5(user);
			break;
		case "6":
			processSelection6(user);
			break;
		}
		
	}

	/*
	 * This method will process user input: 1 and display result
	 */
	public void processSelection1(User user) {
		Logging.displayMessage(Messages.balance, user.getBalance());
		Logging.displayNewLine();
		Optional<String> optional = Optional.ofNullable(user.getSubcription());
		if(optional.isPresent()) {
			Logging.displayMessage(Messages.currSubscription, optional.get());
			Logging.displayNewLine();
		}
		else {
			Logging.displayMessage(Messages.notSubscribed);
		}
	}
	
	/*
	 * This method will process user input: 2 and display result
	 */
	public void processSelection2(User user) {
		Logging.displayMessage(Messages.rechargeAmount);
		String input = inputReader.getInput();
		user.setBalance(Double.parseDouble(user.getBalance()) + Double.parseDouble(input));
		
		Logging.displayMessage(Messages.rechargeSuccessful, user.getBalance());
		Logging.displayNewLine();
	}

	/*
	 * This method will process user input: 3 and display result
	 */
	public void processSelection3(User user) {
		Logging.displayMessage(Messages.availablePacks);
		Logging.displayMessage(BasepackTypes.SilverPack.name() + ": " + BasepackTypes.SilverPack.getChannels() + ": " + BasepackTypes.SilverPack.getValue() + " Rs.");
		Logging.displayMessage(BasepackTypes.GoldPack.name() + ": " + BasepackTypes.GoldPack.getChannels() + ": " + BasepackTypes.GoldPack.getValue() + " Rs.");
		Logging.displayMessage(Messages.availableChannels);
		StringBuilder sb = new StringBuilder();
		
		Consumer<Channels> consumer = s-> { sb.append(s.name() + ": "+ s.getValue() + ", "); };
		Arrays.asList(Channels.values()).forEach(consumer);
		
		sb.deleteCharAt(sb.length()-1);// removing ""
		sb.deleteCharAt(sb.length()-1);// removing ","
		Logging.displayMessage(sb.toString());
	}

	/*
	 * This method will process user input: 4 and display result
	 */
	public void processSelection4(User user) {
		Pack pack = new Pack(); 
		Logging.displayMessage(Messages.enterPack);
		
		pack.setPackType(inputReader.getInput());
		user.setSubscription(pack.getPackType());
		Logging.displayMessage(Messages.enterMonths);
		pack.setMonths(Integer.parseInt(inputReader.getInput()));
		
		double totalValue = (double) pack.getMonths() *Double.parseDouble(pack.getMonthlyPrice());
		double discount = totalValue/10;

		if(Double.parseDouble(user.getBalance()) > (totalValue-discount)) {
			System.out.println("user.getBalance() = " + user.getBalance());
			System.out.println("discount = " + discount);
			System.out.println("totalValue = " + totalValue);
			Logging.displayMessage(Messages.successfulSubscription, pack.getPackType());
			Logging.displayNewLine();
			Logging.displayMessage(Messages.monthlyPrice, pack.getMonthlyPrice());
			Logging.displayNewLine();
			Logging.displayMessage(Messages.numMonths, String.valueOf(pack.getMonths()));
			Logging.displayNewLine();
			
			
			Logging.displayMessage(Messages.subscriptionAmount, ""+ totalValue);
			Logging.displayNewLine();
			Logging.displayMessage(Messages.discountApplied, ""+ discount);
			Logging.displayNewLine();
			Logging.displayMessage(Messages.finalPrice, ""+ (totalValue-discount));
			Logging.displayNewLine();
			
			user.setBalance(Double.parseDouble(user.getBalance()) - (totalValue-discount));
			sendEmail();
			sendSms();
		}
		else {
			Logging.displayMessage(Messages.insufficientBalance);
		}
		
	}
	
	private void sendEmail() {
		service = new NotificationServiceImpl();
		service.sendEmail();
	}
	
	private void sendSms() {
		service = new NotificationServiceImpl();
		service.sendSms();
	}
	
	/*
	 * This method will process user input: 5 and display result
	 */
	public void processSelection5(User user) {
		Logging.displayMessage(Messages.channelNames);
		List<String> listChannels = inputReader.getChannelsInput();
		double totalPriceForChannels = 0d;
		Channels[] channels = Channels.values();
		
		for(String channelEntered : listChannels) {
			for(Channels channel: channels) {
				if(channelEntered.equalsIgnoreCase(channel.name())) {
					totalPriceForChannels+= Double.parseDouble(channel.getValue());
				}
			}
		}
		if(totalPriceForChannels > 0 && Double.parseDouble(user.getBalance()) > totalPriceForChannels) {
			user.setBalance(Double.parseDouble(user.getBalance()) - totalPriceForChannels);
			Logging.displayMessage(Messages.channelsAdded);
		}
		else {
			if(Double.parseDouble(user.getBalance()) < totalPriceForChannels)
				Logging.displayMessage(Messages.insufficientBalance);
			else {
				Logging.displayMessage(Messages.notSubscribed);
			}
		}
	}
	
	/*
	 * This method will process user input: 6 and display result
	 */
	public void processSelection6(User user) {
		Logging.displayMessage(Messages.updateEmail_Phone);
		Logging.displayMessage(Messages.enterEmail);
		user.setEmail(inputReader.getInput());
		
		Logging.displayMessage(Messages.enterPhone);
		user.setPhone(inputReader.getInput());
		Logging.displayMessage(Messages.emailPhoneUpdated);
	}
	
	
	
}
