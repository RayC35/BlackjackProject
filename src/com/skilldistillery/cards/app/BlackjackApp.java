package com.skilldistillery.cards.app;

import java.util.Scanner;

import com.skilldistillery.cards.blackjack.Dealer;
import com.skilldistillery.cards.blackjack.Player;

public class BlackjackApp {

	private Dealer dealer;
	private Player player;
	private Scanner kb;
	
	private BlackjackApp() {
		dealer = new Dealer();
		player = new Player();
		kb = new Scanner(System.in);
	}
	
	public static void main(String[] args)	{
		BlackjackApp app = new BlackjackApp();
		app.startGame();
		
	}
	
	public void startGame() {
		boolean keepGoing = true;
		while (keepGoing) {
			System.out.println("How about a game of blackjack? Y/N?");
			String response = kb.nextLine();
			
		if (response.equalsIgnoreCase("y") || (response.equalsIgnoreCase("yes"))) {
			initialHands();
			keepGoing = false;
		}
		else if (response.equalsIgnoreCase("n") || (response.equalsIgnoreCase("no"))) {
			System.out.println("Another time then...");
			keepGoing = false;
		}
		else {
			System.out.println("Invalid response. Stop messing around.\n");
		}
	}
}
	public void initialHands() {
		dealer.shuffle();
		player.hit(dealer.dealCard());
		dealer.hit(dealer.dealCard());
		player.hit(dealer.dealCard());
		dealer.hit(dealer.dealCard());
		
//		displayHand(player, "Your hand: ");
//		displayHand(dealer, "The dealer's hand: ");
	}
	
	
}
