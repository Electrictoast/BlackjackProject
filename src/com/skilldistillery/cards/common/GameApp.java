package com.skilldistillery.cards.common;

import java.util.Scanner;

public class GameApp {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		GameApp a = new GameApp();
		Player player = new Player(sc);
		Dealer dealer = new Dealer();
		a.run(player, dealer);
	}
	public void run(Player player, Dealer dealer) {
		boolean playAgain = false;
		start(player, dealer);
		do {
			playAgain=playRound(player,dealer);
		}while(playAgain==true);
		
	}
	public void start(Player player, Dealer dealer) {
		System.out.println("Welcome "+player.name+"!");
		System.out.println("Your dealer today will be "+dealer.name+".");
	}
	public boolean playRound(Player player, Dealer dealer) {
		startingDeal(player,dealer);
		if (player.playHand(sc,dealer)) {
			System.out.println("You busted!");
			return player.checkPlayAgain(sc);
		}
		if(dealer.playHand(player)) {
			System.out.println("The dealer busted");
			System.out.println("You win!");
			return player.checkPlayAgain(sc);
		}
		if(player.hand.handValue()>dealer.hand.handValue()) {
			System.out.println("You win!");
			return player.checkPlayAgain(sc);
		}else {
			System.out.println("Dealer wins...");
			return player.checkPlayAgain(sc);
		}
			
	}
	public void startingDeal(Player player, Dealer dealer) {
		player.addCard(dealer.dealCard());
		dealer.addCard();
		player.addCard(dealer.dealCard());
		dealer.addCard();
		
	}

}
