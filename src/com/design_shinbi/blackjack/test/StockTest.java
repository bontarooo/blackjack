package com.design_shinbi.blackjack.test;

import org.junit.jupiter.api.Test;

import com.design_shinbi.blackjack.model.Card;
import com.design_shinbi.blackjack.model.Stock;

class StockTest {

	@Test
	void testStock() {
		Stock stock = new Stock();
		while (stock.getNumberOfCards() > 0) {
			Card card = stock.pickCard();
			System.out.println(card);
		}
	}

}