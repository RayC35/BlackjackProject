package com.skilldistillery.cards.app;

import java.util.Scanner;

import com.skilldistillery.cards.blackjack.Dealer;
import com.skilldistillery.cards.blackjack.Player;
//import com.skilldistillery.cards.common.Card;

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
			System.out.println();
//			keepGoing = false;
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
		
		System.out.println("Your hand: ");
		player.displayHand();
		System.out.println(player.getHandValue());
		System.out.println("Dealer's hand: ");
		dealer.displayHand();
		System.out.println(dealer.getHandValue());
	}
	
	private void playerTurn() {
		boolean playerTurn = true;
//		
		while(playerTurn) {
			System.out.println("Current hand: ");
//			player.displayHand();
			System.out.println("Would you like to hit or stand?");
			String response = kb.nextLine().toLowerCase();
			
			if(response.equals("hit")) {
				player.hit(dealer.dealCard());
				System.out.println("You drew: " + player.getLastCard());
				System.out.println(player.getHandValue());
				playerTurn = true;
				System.out.println();
			}
			if (player.getHandValue() > 21) {
				System.out.println("Bust! You lose!");
				playerTurn = false;
			}
			else if (response.equals("stand")) {
			System.out.println("You chose to stand.");
			playerTurn = false;
			}
//			else {
//				System.out.println("Invalid response. 'Hit' or 'Stand'? ");
//			}
		}
	}
	
	public void dealerTurn() {
//		if (dealer.getHandValue() < 17) {
//			System.out.println("Dealer hits...");
//			player.hit(dealer.dealCard());
//		}
//		else if (dealer.getHandValue() > 21) {
//			System.out.println("");
//		}
		while (dealer.getHandValue() < 17) {
			System.out.println("Dealer hits...");
			dealer.hit(dealer.dealCard());
		}
		System.out.println("Dealer stands with: " + dealer.getHandValue());
	}
	

	
	
}
	