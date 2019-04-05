package com.skilldistillery.cards.common;

public enum Suit {
	HEARTS("Hearts"),SPADES("Spades"),CLUBS("Clubs"),DIAMONDS("Diamonds");
	
	String name;
	
	Suit(String suit){
		name=suit;
	}
	@Override
	public String toString() {
		return name;
	}
}
