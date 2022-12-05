package inheritance;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		IndividualCustomer individualCustomer1 = new IndividualCustomer(1,"121", "Dogan", "Kilaz", "10001");
		IndividualCustomer individualCustomer2 = new IndividualCustomer(2,"122", "Yusuf", "aaa", "10002");
		IndividualCustomer individualCustomer3 = new IndividualCustomer(3,"123", "Mehmet", "bbb", "10003");
		IndividualCustomer individualCustomer4 = new IndividualCustomer(4,"124", "Cagri", "ccc", "10004");
		IndividualCustomer individualCustomer5 = new IndividualCustomer(5,"125", "Tunahan", "ddd", "10005");
		
		CorporateCustomer corpCustomer1 = new CorporateCustomer(11,"111", "Apple", "201");
		CorporateCustomer corpCustomer2 = new CorporateCustomer(12,"111", "Microsoft", "202");
		CorporateCustomer corpCustomer3 = new CorporateCustomer(13,"111", "MasterCard", "203");
		CorporateCustomer corpCustomer4 = new CorporateCustomer(14,"111", "CostCo", "204");
		CorporateCustomer corpCustomer5 = new CorporateCustomer(15,"111", "HEB", "205");
		
		List<IndividualCustomer> listOfIndividualCustomer=new ArrayList<IndividualCustomer>();
		listOfIndividualCustomer.add(individualCustomer1);
		listOfIndividualCustomer.add(individualCustomer2);
		listOfIndividualCustomer.add(individualCustomer3);
		listOfIndividualCustomer.add(individualCustomer4);
		listOfIndividualCustomer.add(individualCustomer5);
		
		List<CorporateCustomer> listOfCorporateCustomer = new ArrayList<CorporateCustomer>();
		listOfCorporateCustomer.add(corpCustomer1);
		listOfCorporateCustomer.add(corpCustomer2);
		listOfCorporateCustomer.add(corpCustomer3);
		listOfCorporateCustomer.add(corpCustomer4);
		listOfCorporateCustomer.add(corpCustomer5);
		
		List<Customer> listOfAllCustomers = new ArrayList<Customer>();
		listOfAllCustomers.addAll(listOfIndividualCustomer);
		listOfAllCustomers.addAll(listOfCorporateCustomer);
		
		IndividualCustomer individualCustomer = new IndividualCustomer();
		CorporateCustomer corporateCustomer = new CorporateCustomer();
		
		Customer customer1 = individualCustomer;
		Customer customer2 = corporateCustomer;
		
		System.out.println(((IndividualCustomer)customer1).getFirstNumber());
		
		Customer asd = new IndividualCustomer(1,"12", "a", "b", "1001");
		List<Customer> qwe = new ArrayList<Customer>();
		qwe.add(asd);
		
	}

}
