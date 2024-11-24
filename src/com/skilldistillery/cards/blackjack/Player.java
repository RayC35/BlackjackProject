package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;

public class Player {
	
	protected BlackjackHand hand;
	
	 public Player() {
		 hand = new BlackjackHand();
	 }
	 
	 public void hit(Card card) {
		 hand.addCard(card);
	 }
	 public void displayHand() {
		 hand.displayHand();
	 }
	 public int getHandValue() {
		 return hand.getHandValue();
	 }
	 
	 public Card getLastCard() {
		 return hand.getCards().get(hand.getCards().size() - 1);
	 }
	 
	 public void clearHand() {
		 hand.removeCards();
	 }
		 
}
