package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public class CardtoAscii {
	public List<Card> hand;
	public List<StringBuilder> cardBuilder;

	public CardtoAscii() {

	}

	private void setCards(List<Card> cards) {
		this.hand = new ArrayList<Card>();
		hand.addAll(cards);
	}

	private void initConverter(List<Card> cards) {
		setCards(cards);
		cardBuilder = new ArrayList<StringBuilder>();
		for (int i = 0; i < 11; i++) {
			cardBuilder.add(new StringBuilder());
		}

	}

	private void firstCard() {
		cardBuilder.get(0).append(",-----------,");
		cardBuilder.get(1).append("|        aax|");
		cardBuilder.get(2).append("|           |");
		cardBuilder.get(3).append("|  *******  |");
		cardBuilder.get(4).append("|  *******  |");
		cardBuilder.get(5).append("|  *******  |");
		cardBuilder.get(6).append("|  *******  |");
		cardBuilder.get(7).append("|  *******  |");
		cardBuilder.get(8).append("|           |");
		cardBuilder.get(9).append("|aax        |");
		cardBuilder.get(10).append("'-----------'");
	}

	private void dealerFirstCard() {
		cardBuilder.get(0).append(",-----------,");
		cardBuilder.get(1).append("|###########|");
		cardBuilder.get(2).append("|#*********#|");
		cardBuilder.get(3).append("|#*********#|");
		cardBuilder.get(4).append("|#*********#|");
		cardBuilder.get(5).append("|#*********#|");
		cardBuilder.get(6).append("|#*********#|");
		cardBuilder.get(7).append("|#*********#|");
		cardBuilder.get(8).append("|#*********#|");
		cardBuilder.get(9).append("|###########|");
		cardBuilder.get(10).append("'-----------'");

	}

	private void addCard(int counter) {
		cardBuilder.add(new StringBuilder());
		cardBuilder.get(cardBuilder.size() - 11).append("---,");
		cardBuilder.get(cardBuilder.size() - 10).append("aax|");
		cardBuilder.get(cardBuilder.size() - 9).append("   |");
		cardBuilder.get(cardBuilder.size() - 8).append("   |");
		cardBuilder.get(cardBuilder.size() - 7).append("   |");
		cardBuilder.get(cardBuilder.size() - 6).append("   |");
		cardBuilder.get(cardBuilder.size() - 5).append("   |");
		cardBuilder.get(cardBuilder.size() - 4).append("   |");
		cardBuilder.get(cardBuilder.size() - 3).append("   |");
		cardBuilder.get(cardBuilder.size() - 2).append("   |");
		for (int i = 0; i < counter; i++) {
			cardBuilder.get(cardBuilder.size() - 1).append("    ");
		}
		cardBuilder.get(cardBuilder.size() - 1).append("'-----------'");

	}

	private void fillSuitAndNumber(Card card, String showOrHide, int counter) {
		if (card.getRank().equals("10")) {
			cardBuilder.get(cardBuilder.size() - 10).replace(0, cardBuilder.get(cardBuilder.size() - 10).length(),
					cardBuilder.get(cardBuilder.size() - 10).toString().replaceAll("aa", "" + card.getRank()));
			cardBuilder.get(cardBuilder.size() - 10).replace(0, cardBuilder.get(cardBuilder.size() - 10).length(),
					cardBuilder.get(cardBuilder.size() - 10).toString().replaceAll("x", "" + card.getSuitChar()));

		} else {
			cardBuilder.get(cardBuilder.size() - 10).replace(0, cardBuilder.get(cardBuilder.size() - 10).length(),
					cardBuilder.get(cardBuilder.size() - 10).toString().replaceAll("aa", " " + card.getRank()));
			cardBuilder.get(cardBuilder.size() - 10).replace(0, cardBuilder.get(cardBuilder.size() - 10).length(),
					cardBuilder.get(cardBuilder.size() - 10).toString().replaceAll("x", "" + card.getSuitChar()));
		}
		if (card.getRank().equals("10")) {
			cardBuilder.get(cardBuilder.size() - 2).replace(0, cardBuilder.get(cardBuilder.size() - 2).length(),
					cardBuilder.get(cardBuilder.size() - 2).toString().replaceAll("aa", "" + card.getRank()));
			cardBuilder.get(cardBuilder.size() - 2).replace(0, cardBuilder.get(cardBuilder.size() - 2).length(),
					cardBuilder.get(cardBuilder.size() - 2).toString().replaceAll("x", "" + card.getSuitChar()));
		}else {
			cardBuilder.get(cardBuilder.size() - 2).replace(0, cardBuilder.get(cardBuilder.size() - 2).length(),
					cardBuilder.get(cardBuilder.size() - 2).toString().replaceAll("aa", " " + card.getRank()));
			cardBuilder.get(cardBuilder.size() - 2).replace(0, cardBuilder.get(cardBuilder.size() - 2).length(),
					cardBuilder.get(cardBuilder.size() - 2).toString().replaceAll("x", "" + card.getSuitChar()));
		}
	}

	private void subHeart() {
		cardBuilder.get(3).replace(3, 10, " __ __ ");
		cardBuilder.get(4).replace(3, 10, "( \\/  )");
		cardBuilder.get(5).replace(3, 10, " \\   / ");
		cardBuilder.get(6).replace(3, 10, "  \\ /  ");
		cardBuilder.get(7).replace(3, 10, "   '   ");
	}

	private void subSpade() {
		cardBuilder.get(3).replace(3, 10, "   .   ");
		cardBuilder.get(4).replace(3, 10, "  / \\  ");
		cardBuilder.get(5).replace(3, 10, " /   \\ ");
		cardBuilder.get(6).replace(3, 10, "(__ __)");
		cardBuilder.get(7).replace(3, 10, "   |   ");
	}

	private void subClub() {
		cardBuilder.get(3).replace(3, 10, "  ___  ");
		cardBuilder.get(4).replace(3, 10, " (   ) ");
		cardBuilder.get(5).replace(3, 10, "(_ ' _)");
		cardBuilder.get(6).replace(3, 10, "   |   ");
		cardBuilder.get(7).replace(3, 10, "       ");
	}

	private void subDiamond() {
		cardBuilder.get(3).replace(3, 10, "   .   ");
		cardBuilder.get(4).replace(3, 10, "  / \\  ");
		cardBuilder.get(5).replace(3, 10, " /   \\ ");
		cardBuilder.get(6).replace(3, 10, " \\   / ");
		cardBuilder.get(7).replace(3, 10, "  \\ /  ");
	}

	private void drawSuit(Card card) {

		if (card.getSuit().equals("Hearts")) {
			subHeart();
		}
		if (card.getSuit().equals("Diamonds")) {
			subDiamond();
		}
		if (card.getSuit().equals("Spades")) {
			subSpade();
		}
		if (card.getSuit().equals("Clubs")) {
			subClub();
		}
	}

	private void drawHand(String showOrHide) {
		int counter = 0;
		int counter2 = 1;
		for (Card card : hand) {
			if (counter < 1) {
				if (showOrHide.equals("Hide")) {
					dealerFirstCard();
				} else {
					firstCard();
					drawSuit(card);
				}
				fillSuitAndNumber(card, showOrHide, counter);
				counter++;
			} else {
				addCard(counter2);
				counter2++;
				fillSuitAndNumber(card, showOrHide, counter);
			}
		}
		for (StringBuilder sb : cardBuilder) {
			System.out.println(sb.toString());
		}

	}

	public void printHand(List<Card> hand, String showOrHide) {
		initConverter(hand);
		drawHand(showOrHide);
	}

}
