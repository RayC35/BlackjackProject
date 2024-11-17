package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class Dealer extends Player {
	
	private Deck deck;
	
	public Dealer() {
		deck = new Deck();
	}
	
	public Card dealCard() {
		return deck.dealCard();
	} 
	
	public void shuffle() {
		deck.shuffle();
	}
	
	
//	Card c = dealer.dealCard();
//	player.hit(c);
	
	
	
	
	
	
	//NO getDeck()
	
	

}
