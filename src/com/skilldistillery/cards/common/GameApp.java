package com.skilldistillery.cards.common;

import java.util.Scanner;

public class GameApp {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		GameApp a = new GameApp();
		Player player = new Player(sc);
		Dealer dealer = new Dealer(new Deck());
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
		dealer.newHand();
		player.newHand(dealer);
		player.playHand(sc);
		dealer.playHand();
		return player.checkPlayAgain();
	}

}
