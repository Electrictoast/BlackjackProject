package com.skilldistillery.cards.common;

import java.util.List;
import java.util.Scanner;

public class Player {
	public String name;
	private BlackjackHand hand;

	public Player(Scanner sc) {
		System.out.println("What is your name?");
		name = sc.nextLine();
		hand = new BlackjackHand();
	}

	public boolean playHand(Scanner sc, Dealer dealer) {
		boolean bust = false;
		boolean stay = false;
		System.out.println("The dealer passes you two cards");
		System.out.println("What would you like to do?");
		while (!bust && !stay) {
			stay = actionMenu(menu(sc), dealer);
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

	public boolean checkPlayAgain() {
		return false;
	}

	public int menu(Scanner sc) {
		boolean valid = false;
		int choice = 0;
		System.out.println("1. Check your hand");
		System.out.println("2. Check dealers hand");
		System.out.println("3. Hit");
		System.out.println("4. Stay");
		while (!valid) {
			try {
				choice = Integer.parseInt(sc.nextLine());
				if (choice < 0 || choice > 4) {
					throw new Exception();
				} else {
					valid = true;
				}

			} catch (Exception e) {
				System.err.println("Invalid input");
				valid = false;
			}
		}

		return choice;
	}

	public boolean actionMenu(int choice, Dealer dealer) {
		boolean stay = false;
		switch (choice) {
		case 1:
			showHand();
			break;
		case 2:
			dealer.showHand();
			break;
		case 3:
			hand.addCard(dealer.dealCard());
			break;
		case 4:
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
