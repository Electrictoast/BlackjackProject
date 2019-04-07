package com.skilldistillery.cards.common;

public class Card {
	private String suit;
	private String rank;
	private int value;
	private char suitChar;

	public Card(Suit suit,Rank rank) {
		this.suit=suit.toString();
		value=rank.getValue();
		this.rank=rank.toString();
		suitChar=suit.getSuit();
	}
	
	@Override
	public String toString() {
		return rank+" of "+suit;
	}
	public int getValue() {
		return value;
	}
	public String getSuit() {
		return suit;
	}
	public char getSuitChar() {
		return suitChar;
	}
	public String getRank() {
		return rank.toString();
	}
	

}
