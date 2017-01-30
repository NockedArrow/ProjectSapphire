package com.thecherno.flappy.level;

import static org.lwjgl.glfw.GLFW.*;

import com.thecherno.flappy.input.Input;

public class PC extends Entity{

	private float pcSPEED = 0.04f;

	public void update() {

		if(Input.isKeyDown(GLFW_KEY_W)){
			y += pcSPEED;
			bgTexture.setTexture("res/box.png");
		}
		else if(Input.isKeyDown(GLFW_KEY_S)){
			y -= pcSPEED;
			bgTexture.setTexture("res/box.png");
		}	
		else if(Input.isKeyDown(GLFW_KEY_A)){
			x -= pcSPEED;
			bgTexture.setTexture("res/box.png");
		}
		else if(Input.isKeyDown(GLFW_KEY_D)){
			x += pcSPEED;
			bgTexture.setTexture("res/box.png");
		}
		else
			bgTexture.setTexture("res/circle.png");
	}
}
