package com.codechallenge.eircode;

import java.util.Scanner;

/**
 *
 * EirCode App by Greg Harman, Alex Scanlan, James? 
 *
 */



public class EirCode {

	private  String[] eirArray ={"D02Y006", "D04C932", "D15XR2R", "D03RR27", "D24H510", "D02XE81", "D02P656", "", "", ""};
	private String[] addressArray = {"5 Merrion Square North, Dublin 2", "10 Burlington Road, Dublin 4", "Dunsink Observatory, Dunsink Lane, Dublin 15", "26 KINCORA ROAD, Clontarf, Dublin 3", "Partas, 4A BROOKFIELD ENTERPRISE CENTRE, Dublin 24",
			"HODGES FIGGIS, 56-58 DAWSON STREET, Dublin 2", "CENTRAL BANK OF IRELAND, DAME STREET, Dublin 2", "", "", ""};

	private static Scanner scan;
	private static StringBuilder input = new StringBuilder ("");
	private static int count = 7;

	public static void main(String[] args) {

		System.out.println("Welcome to EirApp.");

		boolean quit = true;
		EirCode ec = new EirCode();

		do{
			ec.displayMenu();


			scan = new Scanner(System.in);

			int choice = 0;
			boolean validChoice = false;

			while (!validChoice) {
				scan = new Scanner(System.in);
				try {
					choice = scan.nextInt();
					validChoice = true;
				} catch (Exception e) {
					System.out.println("Please pick a correct option between 1 - 5");
					validChoice = false;
					ec.displayMenu();
				} 
			}

			switch(choice){
			case 1: 
				ec.searchEirCode();
				break;

			case 2:
				ec.searchByAddress();
				break;

			case 3:
				ec.searchByPostcode();
				break;

			case 4:
				ec.enterAddressEirCode();
				break;

			case 5: quit = false;
			break;

			default: System.out.println("Please pick a correct option between 1 - 5");
			}


			//	ec.searchEirCode(input);

			//	quit = ec.quitCheck();

		} while (quit);

		System.out.println("Thank you for using EirApp, Goodbye!");

		scan.close();
	}

	private void enterAddressEirCode() {

		if(count < eirArray.length){

			scan = new Scanner(System.in);
			System.out.print("Please enter an EirCode (Valid format is XXX XXXX): ");

			input = new StringBuilder(scan.nextLine());
			input = replaceAllChar(input);

			if(input.length() != 7){
				System.out.println("Invalid format, Valid format is XXX XXXX");
			}else{
				eirArray.toString();
				eirArray[count] = input.toString();
				boolean addressValid = true;

				do{

					scan = new Scanner(System.in);
					System.out.print("Please enter an address: ");

					StringBuilder input = new StringBuilder(scan.nextLine());

					if(!input.equals("")){
						addressArray[count] = input.toString();
						addressValid = false;
						System.out.println("EirCode and address saved.");

					}


				}while(addressValid);

				count++;
			}







		}else{
			System.out.println("You have entered the max amount of EirCodes and addresses.");
		}



	}

	private void searchByPostcode() {
		scan = new Scanner(System.in);

		System.out.print("Please enter an area code for Dublin (Valid format is DXX): ");

		boolean found = false;
		StringBuilder input ;

		input = new StringBuilder(scan.nextLine());
		input = replaceAllChar(input);

		if(input.length() == 3){

			for(int i = 0; i < eirArray.length; ++i){

				if(!eirArray[i].equals("")){
					if(input.toString().equalsIgnoreCase(eirArray[i].substring(0, 3))){

						System.out.println("The address you're looking for is: " + addressArray[i]);
						found = true;

					}
				}
			}

			if(!found){
				System.out.println("No address's found in this area");
			}


		}else{
			System.out.println("Area code must be in format DXX.");
		}


	}

	private void searchByAddress() {
		scan = new Scanner(System.in);

		System.out.print("Please enter an address: ");

		boolean found = false;
		StringBuilder input ;

		input = new StringBuilder(scan.nextLine());
		input = replaceAllChar(input);


		//input = input.replaceAll("\\s", "");
		//input = input.toLowerCase();
		for(int i = 0; i < addressArray.length; ++i){
			if(addressArray[i].toLowerCase().contains(input.toString().toLowerCase())){
				System.out.println("Address: " + addressArray[i]);
				System.out.println("The Eircode for this address is: " + eirArray[i].substring(0, 3)+" "+eirArray[i].substring(3, 7));
				found = true;
			}
		}

		if(!found){
			System.out.println("Eircode not found");
		}
	}

	private void displayMenu() {

		StringBuilder str = new StringBuilder();
		str = new StringBuilder ("\nPlease pick an option below-");
		System.out.println(str);
		
		str = new StringBuilder ("1) Search by EirCode");
		System.out.println(str);
		
		str = new StringBuilder ("2) Search by address");
		System.out.println(str);
		
		str = new StringBuilder ("3) Search by postcode");
		System.out.println(str);
		
		str = new StringBuilder ("4) Enter EirCode and address");
		System.out.println(str);
		
		str = new StringBuilder ("5) Quit");
		System.out.println(str);

	}

	private void searchEirCode(){
		scan = new Scanner(System.in);

		System.out.print("Please enter an EirCode (Valid format is XXX XXXX): ");

		boolean found = false;
		StringBuilder input;

		input = new StringBuilder(scan.nextLine());
		input = replaceAllChar(input);


		for(int i = 0; i < eirArray.length; ++i){
			if(input.toString().equalsIgnoreCase(eirArray[i])){
				System.out.println("The address you're looking for is: " + addressArray[i]);
				found = true;
			}
		}

		if(!found){
			if(input.length() != 7){
				System.out.println("Invalid format, Valid format is XXX XXXX");
			}else{
				System.out.println("Address not found");
			}
		}

	}

	private StringBuilder replaceAllChar(StringBuilder input){

		for( int i =0 ; i < input.length(); i++){
			
			if(input.charAt(i) == ' '){
				input.insert(i, "");
			}
			
		}
		return input;

	}
}
