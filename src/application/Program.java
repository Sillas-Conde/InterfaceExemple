package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import services.ContractService;
import services.PaypalService;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Contract ID:");
		int ID = sc.nextInt();
		sc.nextLine();
		System.out.println("Contract date:");
		LocalDate date = LocalDate.parse(sc.nextLine(),fmt);
		
		System.out.println("Contract total value:");
		double contractValue = sc.nextDouble();
		sc.nextLine();
		
		System.out.println("Contract installments value:");
		int contracts = sc.nextInt();
		sc.nextLine();
		sc.close();
		
		Contract ct1 = new Contract(ID, date, contractValue);
		
		ContractService ctService = new ContractService(new PaypalService());
		//OnlinePaymentService service = new PaypalService();
		
		ctService.processContract(ct1,contracts);
		
		
		System.out.println(ct1.toString());
		
		
		

	}

}
