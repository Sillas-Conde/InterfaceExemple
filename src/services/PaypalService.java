package services;

public class PaypalService implements OnlinePaymentService {
	
	
	private static double interestFactor = 1;
	private static double paymentFactor = 2;
	
	@Override
	public double paymentFee(double amount) {
		return amount*(paymentFactor/100);
	}
	
	@Override
	public double interest(double amount, int months) {
		return amount*(interestFactor/100)*months;
	}
}


