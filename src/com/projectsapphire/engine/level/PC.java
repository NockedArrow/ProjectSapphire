package com.projectsapphire.engine.level;

import static org.lwjgl.glfw.GLFW.*;

import com.projectsapphire.engine.input.Input;

public class PC extends Entity{

	private float pcSPEED = 0.01f;
	
	public PC() {
		//PC constructor stub
	}

	public void update() {

		if(Input.isKeyDown(GLFW_KEY_W)){
			location.y += pcSPEED;
			//bgTexture.setTexture("res/box.png");
		}
		if(Input.isKeyDown(GLFW_KEY_S)){
			location.y -= pcSPEED;
			//bgTexture.setTexture("res/box.png");
		}	
		if(Input.isKeyDown(GLFW_KEY_A)){
			location.x -= pcSPEED;
			//bgTexture.setTexture("res/box.png");
		}
		if(Input.isKeyDown(GLFW_KEY_D)){
			location.x += pcSPEED;
			//bgTexture.setTexture("res/box.png");
		}
		//else
			//bgTexture.setTexture("res/circle.png");
	}
}
