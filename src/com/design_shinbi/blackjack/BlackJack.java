package com.design_shinbi.blackjack;

import java.util.Scanner;

import com.design_shinbi.blackjack.model.Attender;
import com.design_shinbi.blackjack.model.Dealer;
import com.design_shinbi.blackjack.model.Player;
import com.design_shinbi.blackjack.model.Stock;

public class BlackJack {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		start(scanner);
		scanner.close();
	}

	public static void start(Scanner scanner) {

		
		Player player = new Player(scanner);
		Dealer dealer = new Dealer();
		Stock stock = new Stock();
		
		player.start(stock);
		// 実装してみよう
		dealer.start(stock);
		
		dealer.display();
		
		
		player.play(stock);
		dealer.play(stock);
		
		showResult(player, dealer);
	}

	public static void showResult(Attender player, Attender dealer) {

		// 実装してみよう
		dealer.display();
		player.display();
		
		int dealerStrength = dealer.calculateStrength();
		int playerStrength = player.calculateStrength();
		
		if(playerStrength > dealerStrength) {
			System.out.println("勝ちです。");
		}
		else if(playerStrength < dealerStrength) {
			System.out.println("負けです。");
		} else {
			System.out.println("引き分けです。");
		}
	}
}