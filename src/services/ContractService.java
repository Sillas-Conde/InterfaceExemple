package services;

import java.time.LocalDate;

import entities.Contract;
import entities.Installment;

public class ContractService {
	
	//Contract contract;
	//private int months;
	
	//private OnlinePaymentService service = new PaypalService();
	
	public void processContract(Contract contract, int months, OnlinePaymentService service) {
		
		
		for (int month=1; month<= months; month++) {
			 double baseValue = contract.getTotalValue()/months;
			 
			 // Payment Value corrections
			 baseValue += service.interest(baseValue, month);
			 baseValue += service.paymentFee(baseValue);
			 
			 // DueDate calculation
			 LocalDate baseDate = contract.getDate().plusMonths(month);
			 
			 // Add Installment 
			 contract.addInstallment(new Installment(baseDate, baseValue));
		}
		
		
	}
	
	
	
}
