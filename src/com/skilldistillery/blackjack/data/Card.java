package com.skilldistillery.blackjack.data;

public class Card {
	private String suit;
	private String rank;
	private int value;

	public Card(Suit suit,Rank rank) {
		this.suit=suit.toString();
		value=rank.getValue();
		this.rank=rank.toString();
	}
	public int hashCode() {
		return 0;
		
	}
	public void equals() {
		
	}
	@Override
	public String toString() {
		return rank+" of "+suit;
	}
	public int getValue() {
		return value;
	}
	

}
