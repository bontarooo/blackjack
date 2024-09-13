package com.design_shinbi.blackjack.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Attender {
	protected List<Card> cards;
	protected String name;

	public Attender(String name) {
		this.name = name;
		initialize();
	}

	public void initialize() {
		this.cards = new ArrayList<Card>();
	}

	public void start(Stock stock) {
		this.cards.clear();
		for (int i = 0; i < 2; i++) {
			Card card = stock.pickCard();
			this.cards.add(card);
		}
	}

	public String getName() {
		return name;
	}

	public void hit(Stock stock) {
		Card card = stock.pickCard();
		this.cards.add(card);
	}

	public static int calculateStrengthFromList(List<Card> list) {
		int strength = 0; //カードの合計値
		
		// 実装してみよう
		int aceCount = 0; //Aのカード
		
		for(Card card : list) {
			int number = card.getNumber();
			
			if(number >= 2 && number <= 10) { //2から10までのカード
				strength += number;
			} else if (number >= 11 && number <= 13) { //11.12.13のカードの処理
				strength += 10;
			} else if (number == 1) { //Aのカードを１として加算
				strength += 1;
				aceCount++;
			}
 		}
		
		while(aceCount > 0 && strength + 10 <= 21) { //Aを11としてカウントする時
			strength += 10;
			aceCount--;
		}
		
		if(strength > 21) { //21を超えたらバースト
			strength = 0;
		}

		return strength;//値を返す
	}
	
	//ここまで

	public int calculateStrength() {
		int strength = calculateStrengthFromList(this.cards);
		return strength;
	}

	public String toString() {
		String string = name + ": ";
		for (int i = 0; i < this.cards.size(); i++) {
			Card card = this.cards.get(i);
			string = string + card.toString();
		}
		return string;
	}

	public void display() {
		System.out.println(this.toString());
	}

	public abstract void play(Stock stock) throws IOException;
}