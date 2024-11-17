package com.skilldistillery.cards.common;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	private List<Card> cards;

	public Deck() {
		cards = new ArrayList<>(52);
		populateDeck();
	}
	
	private void populateDeck() {
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				cards.add(new Card(r,s));
			}
		}
	}
	
	public int checkDeckSize() {
		return cards.size();
	}
	
	public Card dealCard() {
		return cards.remove(0);
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	//NO getCards(){}
	
}