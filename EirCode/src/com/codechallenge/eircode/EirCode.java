package com.codechallenge.eircode;

import java.util.Scanner;

public class EirCode {

	public static void main(String[] args) {
		String[] eirArray = {"D02 Y006", "D04 C932", "D15 XR2R", "D03 RR27", "D24 H510"};
		String[] addressArray = {"5 Merrion Square North, Dublin 2", "10 Burlington Road, Dublin 4", "Dunsink Observatory, Dunsink Lane, Dublin 15", "26 KINCORA ROAD, Clontarf, Dublin 3", "Partas, 4A BROOKFIELD ENTERPRISE CENTRE, Dublin 24"};




		boolean quit = true;


		do{
			String input = "";
			boolean found = false;
			System.out.println("Please input EirCode: ");

			Scanner scan = new Scanner(System.in);

			input = scan.nextLine();

			for(int i = 0; i < eirArray.length; ++i){
				if(input.equalsIgnoreCase(eirArray[i])){
					System.out.println("The address you're looking for is: " + addressArray[i]);
					found = true;
				}
			}

			if(!found) System.out.println("Address not found");

			System.out.println("Would you like to continue? Y / N");
			String choice = null;
			boolean notYN = true;
			while (notYN) {
				choice = scan.next();
				if(choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("N")){ 
					notYN = false;
				}else{
					System.out.println("Choice must be Y or N, Would you like to continue? Y / N");
				}
			}
			if(choice.equalsIgnoreCase("N")) quit = false;

		} while (quit);
		System.out.println("Thank you for using EirApp, Goodbye!");
	}

}
