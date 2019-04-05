package com.skilldistillery.cards.common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dealer{
	String name;
	BlackjackHand hand;
	Deck deck;

	public Dealer() {
		deck = new Deck();
		deck.shuffle();
		hand = new BlackjackHand();
		pickName();
	}

	public void playHand() {
		// logic for dealer

	}

	public void showHand() {
		List<Card> temp = hand.getCards();
		int counter = 0;
		for (Card card : temp) {
			if (counter++ > 0) {
				System.out.println(card.toString());
			} else {
				System.out.println("Dealer has a mystery card");
			}
		}
	}

	public void pickName() {
		List<String> names = new ArrayList<>();
		try {
			FileReader fr = new FileReader("names.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				names.add(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("Invalid filename: " + e.getMessage());
			return;
		} catch (IOException e) {
			System.err.println("Problem while reading names.txt: " + e.getMessage());
			return;
		}
		name = names.get((int) (Math.random() * names.size()));

	}

	public void addCard() {
		hand.addCard(dealCard());
	}

	public Card dealCard() {
		return deck.dealCard();
	}
	public boolean checkBust() {
		if(hand.handValue()>21) {
			return true;
		}
		return false;
	}

}
