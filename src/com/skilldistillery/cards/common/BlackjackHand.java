package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public class BlackjackHand extends Hand {
	List<Card> hand= new ArrayList<>();

	public BlackjackHand() {
		
	}
	public void addCard(Card card) {
		hand.add(card);
	}
	public void clearHand() {
		hand= new ArrayList<>();
	}
	public List<Card> getCards(){
		return hand;
		
	}

}
