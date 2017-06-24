package com.mygdx.game.Iokin;

import com.mygdx.game.Iokin.Animator;

public class Player{
	Animator animator;
	
	public Player(){
		
	}
	
	public void create(){
		animator = new Animator();
		animator.create();
	}
	
	public void render(){
		animator.render();
	}
	
}
