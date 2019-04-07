package com.skilldistillery.cards.common;

import java.util.Scanner;

public class GameApp {
	public static Scanner sc = new Scanner(System.in);
	public CardtoAscii converter= new CardtoAscii();

	public static void main(String[] args) {
		GameApp a = new GameApp();
		System.out.println("#=================#");
		System.out.println("\"                 \"");
		System.out.println("\"    BLACKJACK    \"");
		System.out.println("\"                 \"");
		System.out.println("#=================#");
//		menu asking number of players
		Dealer dealer = new Dealer();
		Player player = new Player(dealer,sc);
		a.run(player, dealer);
	}
	public void run(Player player, Dealer dealer) {
		boolean playAgain = false;
		do {
			playAgain=playRound(player,dealer);
		}while(playAgain==true);
		
	}
	public boolean playRound(Player player, Dealer dealer) {
		startingDeal(player,dealer);
		if(player.hand.handValue()==21) {
			System.out.println("You got Blackjack!");
			converter.printHand(player.hand.getCards(), "Player");
			if(dealer.hand.handValue()==21) {
				System.out.println("Unfortunately so did "+dealer.name);
				converter.printHand(dealer.hand.getCards(), "Player");
				System.out.println(dealer.name+ ": Too bad");
				return player.checkPlayAgain(dealer, sc);
			}
			System.out.println(dealer.name+": You win this round!");
			return player.checkPlayAgain(dealer, sc);
		}else if(dealer.hand.handValue()==21) {
			System.out.println(dealer.name + ": I got Blackjack!");
			converter.printHand(dealer.hand.getCards(), "Player");
			System.out.println(dealer.name + " wins this round.");
			return player.checkPlayAgain(dealer, sc);

		}
		if (player.playHand(sc,dealer)) {
			System.out.println("Oh no!");
//			player.showHand();
			converter.printHand(player.hand.getCards(), "Player");
			System.out.println("Thats "+player.hand.handValue());
			System.out.println("You busted!");
			System.out.println();
			return player.checkPlayAgain(dealer, sc);
		}
		if(dealer.playHand(player)) {
			System.out.println("You win!");
			System.out.println();
			return player.checkPlayAgain(dealer, sc);
		}
		if(player.hand.handValue()>dealer.hand.handValue()) {
			System.out.println("You win!");
			System.out.println(dealer.name +" had:");
//			dealer.showTrueHand();
			converter.printHand(dealer.hand.getCards(), "Player");
			System.out.println();
			return player.checkPlayAgain(dealer, sc);
		}else {
//			dealer.showTrueHand();
			converter.printHand(dealer.hand.getCards(), "Player");
			System.out.println(dealer.name+": Thats "+ dealer.hand.handValue());
			System.out.println(dealer.name+": I win");
			System.out.println(dealer.name+": Better luck next time "+player.name);
			return player.checkPlayAgain(dealer, sc);
		}
			
	}
	public void startingDeal(Player player, Dealer dealer) {
//		list of players and loop for first deal
		if (dealer.getDeckSize()<12) {
			dealer.changeDeck();
		}
		player.hand.clearHand();
		dealer.hand.clearHand();
		player.addCard(dealer.dealCard());
		dealer.addCard();
		player.addCard(dealer.dealCard());
		dealer.addCard();
		
	}

}
