package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;

public class Player {
	
	//fields
	protected BlackjackHand hand;
	
	//No List<card>
	 public Player() {
		 hand = new BlackjackHand();
	 }
	 
	 public void hit(Card card) {
		 hand.addCard(card);
	 }

	 //NO getHand()
	 
	 
	 
	 
	 
}
