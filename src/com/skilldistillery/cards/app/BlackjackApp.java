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
			System.out.println();
			
		if (response.equalsIgnoreCase("y") || (response.equalsIgnoreCase("yes"))) {
			newGame();
			initialHands();
			initialCheck();
			if (player.getHandValue() != 21 && dealer.getHandValue() != 21) {
				playerTurn();
				dealerTurn();
				whoWins();
				System.out.println();
			}
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
		
		//why can't I combine these two lines below?
		System.out.println("Your hand: ");
		player.displayHand();
		System.out.println(player.getHandValue());
		player.blackJackCheck();
		System.out.println();
		
		System.out.println("Dealer's hand: ");
		System.out.println(dealer.getLastCard());
		System.out.println(dealer.getLastCard().getValue());
		dealer.blackJackCheck();
		
	}
	
	private void playerTurn() {
		boolean keepGoing = true;
		while (keepGoing) {
			if (player.getHandValue() == 21 || dealer.getHandValue() == 21) {
			keepGoing = false;
			}
			else {
				boolean playerTurn = true;
//		
				while(playerTurn) {
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
//					System.out.println("Bust! You lose!");
					playerTurn = false;
					}
				else if (response.equals("stand")) {
					System.out.println("You chose to stand.");
					playerTurn = false;
					}
				}
			}
			keepGoing = false;
		}
	}
	
	
	public void dealerTurn() {
		boolean dealersTurn = true;
		while (dealersTurn) {
		if (player.getHandValue() > 21) {
			dealersTurn = false;
		}
		else if (player.getHandValue() <= 21) {
		//FIX DEALER STANDS IF D BUSTS, GO STRAIGHT TO WHOWINS(). NEW BOOLEAN IN WHILE?
			while (dealer.getHandValue() < 17) {
				if (dealer.getHandValue() > 21) {
					dealersTurn = false;
				}
				System.out.println("Dealer hits...");
				dealer.hit(dealer.dealCard());
				System.out.println("Dealer draws: " + dealer.getLastCard());
				System.out.println(dealer.getHandValue());
				}
			System.out.println("Dealer stands with: " + dealer.getHandValue());
			dealersTurn = false;
			}
		}
	}
	public void whoWins() {
		int playerValue = player.getHandValue();
		int dealerValue = dealer.getHandValue();
		
		if (playerValue > 21) {
			System.out.println("Player busts! Dealer wins. Too bad, maybe next time.");
		}
		else if (dealerValue > 21) {
			System.out.println("Dealer busts! Player wins. Congratulations!");
		}
		else if (playerValue > dealerValue) {
			System.out.println("Player wins with: " + playerValue + ". Way to go!");
		}
		else if (playerValue < dealerValue) {
			System.out.println("Dealer wins with: " + dealerValue + ". Too bad, maybe next time.");
		}
		else {
			System.out.println("Push! Both dealer and player have: " + playerValue + ", no winner.");
		}
	}
	
	public void initialCheck() {
		if (player.getHandValue() == 21 && dealer.getHandValue() != 21) {
			System.out.println("Player wins!"); 
		}
		else if (dealer.getHandValue() == 21 && player.getHandValue() != 21) {
			System.out.println("Dealer wins!");
			}
		else if (player.getHandValue() == 21 && dealer.getHandValue() == 21) {
			System.out.println("Both dealer and player have blackjack! It's a push!");
		}
		System.out.println();	
	}
	
	public void newGame() {
		player.clearHand();
		dealer.clearHand();
	}
	
	
	
	
	}