package com.mygdx.game;

public class Stats {
	
	public int healPoint = 100;
	float drinkPoint = 1;
	float foodPoint = 1;
	
	public Stats(int hp){
		healPoint =  hp;
	}
	
	public int getHP(){
		return healPoint;
	}
	
	public void updHP(int hp){
		healPoint += hp;
	}
}
