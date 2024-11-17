package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.AbstractHand;
import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Rank;
import com.skilldistillery.cards.common.Suit;

public class BlackjackHand extends AbstractHand {

//	public static void main(String [] args) {
//		BlackjackHand hand = new BlackjackHand();
//		hand.addCard(new Card(Rank.TEN, Suit.SPADES));
//		hand.addCard(new Card(Rank.ACE, Suit.SPADES));
//		hand.addCard(new Card(Rank.JACK, Suit.SPADES));
//		System.out.println(displayHand());
//	}	
	
	//No fields
	
	@Override
	public int getHandValue() {
		int sum = 0;
		for (Card card : cardsInHand) {
			sum += card.getValue();
//			System.out.println(sum);
		}
		return sum;
	}
	
	public boolean isBlackjack() {
		if (getHandValue() == 21) {
			System.out.println("Blackjack!");
		}
			return true;
	}
			
	public boolean isBust() {
		if (getHandValue() > 21) {
			System.out.println("Over! You lose!");
		}
			return true;
	}
	
	public void displayHand() {
		for (Card card : cardsInHand) {
			System.out.println(card);
		}
	}

}
