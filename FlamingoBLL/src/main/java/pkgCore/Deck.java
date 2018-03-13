package pkgCore;

import java.util.Collections;
import java.util.ArrayList;

import pkgEnum.eRank;
import pkgEnum.eSuit;

public class Deck {

	private ArrayList<Card> cards = new ArrayList<Card>();
	private Object eRank;

	public Deck(int NumofDeck) {

		for (int deck = 1; deck < NumofDeck; deck++) {
			for (eRank eRank : pkgEnum.eRank.values()) {
				for (eSuit eSuit : pkgEnum.eSuit.values()){
					cards.add(new Card(eSuit, eRank));}
				}
		}
		Collections.shuffle(cards);
	}
	public Deck() {
		this(1);
	}

	public Card draw() throws Exception {
		if (cards.size() == 0) {
			throw new Exception ("Deck is empty!");
		}
		return (cards.remove(0));
	}
	
	public int DeckSize() {
		return this.cards.size();
	}
	
	
	//new method getRemaining returns how many of a suit or rank are left in the deck
	public int getRemaining (Object eNum) {
		int sum = 0;
		if (eNum instanceof eSuit) {
			for (Card c: cards) {
				if (c.geteSuit() == eNum) {
					sum ++;
				}
			}
		}
		else if (eNum instanceof eRank) {
			for (Card c1: cards) {
				if (c1.geteRank() == eNum) {
					sum ++;
				}	
			}
		}
		return sum;
	}
			
}

