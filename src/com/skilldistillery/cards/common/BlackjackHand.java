package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public class BlackjackHand extends Hand {
	List<Card> hand= new ArrayList<>();

	public BlackjackHand() {
		
	}
	public Card addCard(Card card) {
		hand.add(card);
		return card;
	}
	public void clearHand() {
		hand= new ArrayList<Card>();
	}
	public List<Card> getCards(){
		return hand;
		
	}
	public int handValue() {
		int total=0;
		for (Card card : hand) {
			total+= card.getValue();
		}
		return total;
	}
	public int checkHandSize() {
		return hand.size();
	}

}
