package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	List<Card> deck;

	public Deck() {
		deck = new ArrayList<>();
		Rank[] rankArr = Rank.values();
		Suit[] suitArr = Suit.values();
		for (Suit suit : suitArr) {
			for (Rank rank : rankArr) {
				deck.add(new Card(suit, rank));
			}

		}
	}

	public int checkDeckSize() {
		return deck.size();
	}

	public Card dealCard() {
		return deck.remove(0);
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}

	public void addDeck() {
		Rank[] rankArr = Rank.values();
		Suit[] suitArr = Suit.values();
		for (Suit suit : suitArr) {
			for (Rank rank : rankArr) {
				deck.add(new Card(suit, rank));
			}

		}
	}
}
