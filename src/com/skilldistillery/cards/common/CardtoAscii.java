package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public class CardtoAscii {
	public List<Card> hand;
	public StringBuilder[] cardBuilder;

	public CardtoAscii() {

	}

	private void setCards(List<Card> cards) {
		this.hand = new ArrayList<Card>();
		hand.addAll(cards);
	}

	private void initConverter(List<Card> cards) {
		setCards(cards);
		cardBuilder = new StringBuilder[11];
		StringBuilder lineA = new StringBuilder();
		StringBuilder lineB = new StringBuilder();
		StringBuilder lineC = new StringBuilder();
		StringBuilder lineD = new StringBuilder();
		StringBuilder lineE = new StringBuilder();
		StringBuilder lineF = new StringBuilder();
		StringBuilder lineG = new StringBuilder();
		StringBuilder lineH = new StringBuilder();
		StringBuilder lineI = new StringBuilder();
		StringBuilder lineJ = new StringBuilder();
		StringBuilder lineK = new StringBuilder();
		cardBuilder[0] = lineA;
		cardBuilder[1] = lineB;
		cardBuilder[2] = lineC;
		cardBuilder[3] = lineD;
		cardBuilder[4] = lineE;
		cardBuilder[5] = lineF;
		cardBuilder[6] = lineG;
		cardBuilder[7] = lineH;
		cardBuilder[8] = lineI;
		cardBuilder[9] = lineJ;
		cardBuilder[10] = lineK;

	}

	private void firstCard() {
		cardBuilder[0].append("-------------");
		cardBuilder[1].append("|         ax|");
		cardBuilder[2].append("|           |");
		cardBuilder[3].append("|  *******  |");
		cardBuilder[4].append("|  *******  |");
		cardBuilder[5].append("|  *******  |");
		cardBuilder[6].append("|  *******  |");
		cardBuilder[7].append("|  *******  |");
		cardBuilder[8].append("|           |");
		cardBuilder[9].append("|ax         |");
		cardBuilder[10].append("-------------");
	}

	private void dealerFirstCard() {
		cardBuilder[0].append("-------------");
		cardBuilder[1].append("|###########|");
		cardBuilder[2].append("|#*********#|");
		cardBuilder[3].append("|#*********#|");
		cardBuilder[4].append("|#*********#|");
		cardBuilder[5].append("|#*********#|");
		cardBuilder[6].append("|#*********#|");
		cardBuilder[7].append("|#*********#|");
		cardBuilder[8].append("|#*********#|");
		cardBuilder[9].append("|###########|");
		cardBuilder[10].append("-------------");

	}

	private void addCard() {
		cardBuilder[0].append("---");
		cardBuilder[1].append("ax|");
		cardBuilder[2].append("  |");
		cardBuilder[3].append("  |");
		cardBuilder[4].append("  |");
		cardBuilder[5].append("  |");
		cardBuilder[6].append("  |");
		cardBuilder[7].append("  |");
		cardBuilder[8].append("  |");
		cardBuilder[9].append("  |");
		cardBuilder[10].append("---");

	}

	private void fillSuitAndNumber(Card card, String playerOrDealer, int counter) {
		cardBuilder[1].replace(0, cardBuilder[1].length(),
				cardBuilder[1].toString().replaceAll("a", "" + card.getRank()));
		cardBuilder[1].replace(0, cardBuilder[1].length(),
				cardBuilder[1].toString().replaceAll("x", "" + card.getSuitChar()));

		if (playerOrDealer.equals("Player") && counter < 1) {
			if (card.getRank().equals("10")) {
				cardBuilder[9].replace(0, cardBuilder[9].length(),
						cardBuilder[9].replace(1, 4, "" + card.getRank() + card.getSuitChar()).toString());

			} else {
				cardBuilder[9].replace(0, cardBuilder[9].length(),
						cardBuilder[9].replace(1, 3, "" + card.getRank() + card.getSuitChar()).toString());
			}
		}
	}

	private void subHeart() {
		cardBuilder[3].replace(3, 10, " __ __ ");
		cardBuilder[4].replace(3, 10, "( \\/  )");
		cardBuilder[5].replace(3, 10, " \\   / ");
		cardBuilder[6].replace(3, 10, "  \\ /  ");
		cardBuilder[7].replace(3, 10, "   '   ");
	}

	private void subSpade() {
		cardBuilder[3].replace(3, 10, "   .   ");
		cardBuilder[4].replace(3, 10, "  / \\  ");
		cardBuilder[5].replace(3, 10, " /   \\ ");
		cardBuilder[6].replace(3, 10, "(__ __)");
		cardBuilder[7].replace(3, 10, "   |   ");
	}

	private void subClub() {
		cardBuilder[3].replace(3, 10, "  ___  ");
		cardBuilder[4].replace(3, 10, " (   ) ");
		cardBuilder[5].replace(3, 10, "(_ ' _)");
		cardBuilder[6].replace(3, 10, "   |   ");
		cardBuilder[7].replace(3, 10, "       ");
	}

	private void subDiamond() {
		cardBuilder[3].replace(3, 10, "   .   ");
		cardBuilder[4].replace(3, 10, "  / \\  ");
		cardBuilder[5].replace(3, 10, " /   \\ ");
		cardBuilder[6].replace(3, 10, " \\   / ");
		cardBuilder[7].replace(3, 10, "  \\ /  ");
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

	private void drawHand(String playerOrDealer) {
		int counter = 0;
		for (Card card : hand) {
			if (counter < 1) {
				if (playerOrDealer.equals("Dealer")) {
					dealerFirstCard();
				} else {
					firstCard();
					drawSuit(card);
				}
				fillSuitAndNumber(card, playerOrDealer, counter);
				counter++;
			} else {
				addCard();
				fillSuitAndNumber(card, playerOrDealer, counter);
			}
		}
		for (StringBuilder sb : cardBuilder) {
			System.out.println(sb.toString());
		}

	}

	public void printHand(List<Card> hand, String playerOrDealer) {
		initConverter(hand);
		drawHand(playerOrDealer);
	}

}
