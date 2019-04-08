package com.skilldistillery.cards.common;

import java.util.List;
import java.util.Scanner;

public class Player {
	public String name;
	public BlackjackHand hand;
	public CardtoAscii converter= new CardtoAscii();

	public Player(Dealer dealer, Scanner sc) {
		System.out.println(dealer.name+ ": Welcome!");
		System.out.println(dealer.name+ ": What is your name?");
		name = sc.nextLine();
		System.out.println(dealer.name + ": Nice to meet you "+ name +" lets play some Blackjack!");
		hand = new BlackjackHand();
	}

	public boolean playHand(Scanner sc, Dealer dealer) {
		boolean bust = false;
		boolean stay = false;
		System.out.println();
		System.out.println(dealer.name +" passes you two cards");
		System.out.println(dealer.name+ ": What would you like to do?");
		while (!bust && !stay) {
			stay = actionMenu(menu(sc), dealer, sc);
			bust = checkBust();
		}
		return bust;
	}

	public void showHand() {
		List<Card> temp = hand.getCards();
		for (Card card : temp) {
			System.out.println(card.toString());
		}
	}

	public void addCard(Card card) {
		hand.addCard(card);
	}

	public boolean checkPlayAgain(Dealer dealer, Scanner sc) {
		System.out.println(dealer.name + ": Would you like to play again?");
		System.out.print("(yes/no)  ");
		if(sc.nextLine().toUpperCase().equals("YES")) {
			return true;
		}else {
		return false;
		}
	}

	public int menu(Scanner sc) {
		boolean valid = false;
		int choice = 0;
		System.out.println("1. Check cards");
		System.out.println("2. Hit");
		System.out.println("3. Stay");
		while (!valid) {
			try {
				choice = Integer.parseInt(sc.nextLine());
				if (choice < 0 || choice > 3) {
					throw new Exception();
				} else {
					valid = true;
				}

			} catch (Exception e) {
				System.err.println("Invalid input");
				valid = false;
			}
		}
		System.out.println();
		return choice;
	}

	public boolean actionMenu(int choice, Dealer dealer, Scanner sc) {
		boolean stay = false;
		switch (choice) {
		case 1:
			System.out.println("Your cards:");
//			showHand();
			converter.printHand(hand.getCards(), "Player");
			System.out.println();
			System.out.println(dealer.name + " has:");
//			dealer.showHand();
			converter.printHand(dealer.getHand(), "Hide");
			System.out.println();
			System.out.println("Press enter to continue");
			sc.nextLine();
			break;
		case 2:
			Card newCard = dealer.dealCard();
			hand.addCard(newCard);
			System.out.println(dealer.name+" hands you a "+ newCard.toString());
			System.out.println("Press enter to continue");
			sc.nextLine();
			break;
		case 3:
			stay = true;
			break;
		}

		return stay;
	}

	public boolean checkBust() {
		if (hand.handValue() > 21) {
			return true;
		}
		return false;
	}

}
