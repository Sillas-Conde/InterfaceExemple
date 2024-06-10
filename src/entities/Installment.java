package entities;

import java.time.LocalDate;


public class Installment {
	
	
	private LocalDate dueDate;
	private double amount;
	
	// Constructors
	public Installment() {}
	public Installment(LocalDate dueDate, double amount) {
		super();
		this.dueDate = dueDate;
		this.amount = amount;
	}
	
	// Getters And Setters
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public double getAmount() {
		return amount;
	}
}
