package com.skilldistillery.cards.common;

import java.util.Scanner;

public class GameApp {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		GameApp a = new GameApp();
		System.out.println("#=================#");
		System.out.println("\"                 \"");
		System.out.println("\"    BLACKJACK    \"");
		System.out.println("\"                 \"");
		System.out.println("#=================#");
		
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
		if (player.playHand(sc,dealer)) {
			System.out.println("Oh no!");
			player.showHand();
			System.out.println("Thats "+player.hand.handValue());
			System.out.println("You busted!");
			return player.checkPlayAgain(dealer, sc);
		}
		if(dealer.playHand(player)) {
			System.out.println(dealer.name +" busted");
			System.out.println("You win!");
			return player.checkPlayAgain(dealer, sc);
		}
		if(player.hand.handValue()>dealer.hand.handValue()) {
			System.out.println("You win!");
			System.out.println(dealer.name +" had:");
			dealer.showTrueHand();
			return player.checkPlayAgain(dealer, sc);
		}else {
			System.out.println(dealer.name+": I win");
			System.out.println(dealer.name+": Better luck next time "+player.name);
			dealer.showTrueHand();
			System.out.println(dealer.name+": Thats "+ dealer.hand.handValue());
			return player.checkPlayAgain(dealer, sc);
		}
			
	}
	public void startingDeal(Player player, Dealer dealer) {
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
