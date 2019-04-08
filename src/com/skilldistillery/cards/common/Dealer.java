package com.skilldistillery.cards.common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dealer{
	public String name;
	public BlackjackHand hand;
	private Deck deck;
	public CardtoAscii converter = new CardtoAscii();

	public Dealer() {
		deck = new Deck();
		for (int i =0; i<8; i++) {
			deck.addDeck();
		}
		deck.shuffle();
		hand = new BlackjackHand();
		pickName();
		System.out.println("Your dealer today will be "+name+".");
	}

	public boolean playHand(Player player) {
		boolean bust = false;
		Card temp = null;
		
		System.out.println(name+ ": My turn!");
		do {
		if(hand.handValue()<17&&hand.handValue()<player.hand.handValue())
			System.out.println(name + ": Guess I'll draw a card");
			temp = addCard();
		if(hand.handValue()>21) {
			bust = true;
		}
		System.out.println(temp.toString());
		if (bust) {
//			showTrueHand();
			converter.printHand(hand.getCards(), "Player");
			System.out.println(name +": Thats "+hand.handValue());
			System.out.println(name+ ": Oh no! I busted");
		}
		}while(hand.handValue()<17 && !bust);
		
		return bust;
	}

	public void showHand() {
		List<Card> temp = hand.getCards();
		int counter = 0;
		for (Card card : temp) {
			if (counter++ > 0) {
				System.out.println(card.toString());
			} else {
				System.out.println("Mystery card");
			}
		}
	}
	public void showTrueHand() {
		List<Card> temp = hand.getCards();
		for (Card card : temp) {
				System.out.println(card.toString());
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

	public Card addCard() {
		Card temp = hand.addCard(dealCard());
		return temp;
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
	public void changeDeck() {
		System.out.println();
		System.out.println(name + ": Wow you really like this game.");
		System.out.println("Lets grab a new deck!");
		deck = new Deck();
		for (int i =0; i<8; i++) {
			deck.addDeck();
		}
		
	}
	public int getDeckSize() {
		return deck.checkDeckSize();
	}
	public List<Card> getHand(){
		return hand.getCards();
	}

}
