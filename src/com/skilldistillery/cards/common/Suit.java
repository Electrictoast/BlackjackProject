package com.skilldistillery.cards.common;

public enum Suit {
	HEARTS("Hearts",'\u2661'),SPADES("Spades",'\u2660'),CLUBS("Clubs",'\u2663'),DIAMONDS("Diamonds", '\u2662');
	
	String name;
	char suit;
	
	Suit(String name, char suit){
		this.name=name;
		this.suit=suit;
	}
	@Override
	public String toString() {
		return name;
	}
	public char getSuit() {
		return suit;
	}
}
