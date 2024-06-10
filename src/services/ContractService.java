package services;

import java.time.LocalDate;

import entities.Contract;
import entities.Installment;

public class ContractService {
	
	//Contract contract;
	//private int months;
	
	private OnlinePaymentService onlinePaymentService;
	
	
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}



	public void processContract(Contract contract, int months) {
		
		
		for (int month=1; month<= months; month++) {
			 double baseValue = contract.getTotalValue()/months;
			 
			 // Payment Value corrections
			 baseValue += onlinePaymentService.interest(baseValue, month);
			 baseValue += onlinePaymentService.paymentFee(baseValue);
			 
			 // DueDate calculation
			 LocalDate baseDate = contract.getDate().plusMonths(month);
			 
			 // Add Installment 
			 contract.addInstallment(new Installment(baseDate, baseValue));
		}
		
		
	}
	
	
	
}
