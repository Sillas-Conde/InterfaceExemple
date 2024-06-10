package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Contract {
	
	
	private Integer ID;
	private LocalDate date;
	private Double totalValue;
	
	private List<Installment> installments = new ArrayList<>();
	
	
	// Constructors
	public Contract() {}
	public Contract(Integer ID, LocalDate date, Double totalValue) {
		this.ID = ID;
		this.date = date;
		this.totalValue = totalValue;
	}
	
	// Getters and Setters
	public int getID() {
		return ID;
	}
	public LocalDate getDate() {
		return date;
	}
	
	public double getTotalValue() {
		return totalValue;
	}
	
	public List<Installment> getInstallments() {
		return installments;
	}
	
	// Add installments
	public void addInstallment(Installment installment) {
		
		this.installments.add(installment);
	}
	
	@Override
	public String toString() {
		
		String installments = "Installments: \n";
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		for (Installment installment : this.installments) {
			
			installments += installment.getDueDate().format(fmt1) + " - ";
			installments += installment.getAmount() + "\n";
			
		}
		
		return installments;
		
	}
	
	
	
	
	
	
}
