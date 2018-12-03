package com.SystemRecommendationOpenReq.SystemRecomendation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;

import data.FinalizedRequirementsFinder;
import data.FinalizedRequirementsGateway;
import data.UserFinder;
import data.UserGateway;
import data.sqliteConnection;

public class DriverQuery {

	public static void main(String[] args) {
		SpringApplication.run(SystemRecomendationApplication.class, args);
		
		System.out.println("Select option");
		Scanner scan = new Scanner(System.in);
		System.out.println("1 - query all users");
		System.out.println("2 - query all requirements");
		System.out.println("3 - query all finished requirements");
		System.out.println("4 - query all in progress requirements");
		System.out.println("5 - recommend an user");
		System.out.println("0 - exit program");
		
		String input = scan.nextLine();
		while (!input.equals("0")) {
			switch (Integer.parseInt(input)){
				case 1:
					UserFinder UF = new UserFinder();
				ArrayList<UserGateway> susg = new ArrayList<>();
				try {
					susg = UF.findAll();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					for (UserGateway usg : susg) usg.Write(); 
					break;
				case 2:
					//query
					break;
				case 3:
					FinalizedRequirementsFinder FRF = new FinalizedRequirementsFinder();
					ArrayList<FinalizedRequirementsGateway> sFRG = new ArrayList<>();
					try {
						sFRG = FRF.findAll();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					for (FinalizedRequirementsGateway FRG : sFRG) FRG.write(); 
					break;
				case 4:
					//query
					break;
				case 5:
					TrRecommenderByFinalizedRequirements aux = new TrRecommenderByFinalizedRequirements("2");
					aux.execute();
				default:
					System.out.println("please, enter a valid option");
					break;
			}
			System.out.println("");
			System.out.println("1 - query all users");
			System.out.println("2 - query all requirements");
			System.out.println("3 - query all finished requirements");
			System.out.println("4 - query all in progress requirements");
			System.out.println("5 - recommend an user");
			System.out.println("0 - exit program");
			input = scan.nextLine();
		}
		System.out.println("quitting program");
	}
}
