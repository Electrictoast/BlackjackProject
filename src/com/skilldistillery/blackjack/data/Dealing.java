package com.skilldistillery.blackjack.data;

import java.util.Scanner;

public class Dealing {
	public static Scanner sc = new Scanner(System.in);
	Deck deck = new Deck();

	public static void main(String[] args) {
		Dealing a = new Dealing();
		a.run();
		sc.close();
	}

	public Dealing() {
		deck.shuffle();
	}

	public void run() {
		boolean again=false;
		do {
		again=actionMenu(menu());
		}while(again);
	}

	public int menu() {
		int choice = 0;
		boolean valid = false;
		while (!valid) {
			System.out.println("How many cards would you like?");
			try {
				choice = Integer.parseInt(sc.nextLine());
				if (choice > deck.checkDeckSize() || choice <= 0) {
					throw new Exception();
				}
				valid = true;
			} catch (Exception e) {
				System.out.println("Invalid entry " + choice + ".");
				System.out.println("There are " + deck.checkDeckSize() + " cards left in the deck.");
				System.out.println("Please draw at least one but no more than " + deck.checkDeckSize() + " cards.");
			}
		}
		return choice;
		
	}
	public boolean actionMenu(int choice) {
		for(int i=0; i<choice; i++) {
			System.out.println(deck.dealCard());
		}
		System.out.print("Would you like to draw more cards?\n (yes/no)");
		String choices=sc.nextLine();
		return (choices.toUpperCase().equals("YES"));
	}
}
