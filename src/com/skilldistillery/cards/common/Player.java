package com.skilldistillery.cards.common;

import java.util.List;
import java.util.Scanner;

public class Player{
	public String name;
	private BlackjackHand hand;

	public Player(Scanner sc) {
		System.out.println("What is your name?");
		name=sc.nextLine();
		hand= new BlackjackHand();
	}
	
	public void playHand(Scanner sc,Dealer dealer) {
		System.out.println("The dealer passes you two cards");
		System.out.println("What would you like to do?");
		menu(sc);
	}

	public void showHand() {
		List<Card> temp= hand.getCards();
		for (Card card : temp) {
			System.out.println(card.toString());
		}
	}
	public void newHand(Dealer dealer) {
		hand.clearHand();
		List<Card> temp = dealer.dealHand();
		for (Card card : temp) {
			hand.addCard(card);
		}
	}
	public boolean checkPlayAgain() {
		return false;
	}
	public int menu(Scanner sc) {
		boolean valid = false;
		int choice=0;
		System.out.println("1. Check your hand");
		System.out.println("2. Check dealers hand");
		System.out.println("3. Hit");
		System.out.println("4. Stay");
		while (!valid) {
			try {
				choice=Integer.parseInt(sc.nextLine());
				if (choice<0||choice>4) {
					throw new Exception();
				}else {
					valid=true;
				}
				
				}catch (Exception e) {
					System.err.println("Invalid input");
					valid=false;
				}
			}
		
		
		return choice;
	}
	public boolean actionMenu(int choice,Dealer dealer) {
		boolean bust = false;
		switch (choice) {
		case 1:
			showHand();
			break;
		case 2:
			dealer.showHand();
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		}
		
		return bust;
	}

}
