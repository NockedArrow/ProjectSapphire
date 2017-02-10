package com.projectsapphire.level;

import static org.lwjgl.glfw.GLFW.*;

import com.projectsapphire.engine.utils.Input;

public class PC extends Entity {

	private int control;

	public PC() {
		control = 0;
	}

	public void update() {
		if(Input.isKeyDown(GLFW_KEY_LEFT)) 
			controlLocation(0);	//bgTexture.setTexture("res/box.png");
		if(Input.isKeyDown(GLFW_KEY_RIGHT)) 
			controlLocation(1);
		if(Input.isKeyDown(GLFW_KEY_S)) 
			controlLocation(2);
		if(Input.isKeyDown(GLFW_KEY_D)) 
			controlLocation(3);

		if(Input.isKeyDown(GLFW_KEY_E))
			control = (control + 1) % 2;
	}

	public int getControl() {
		return control;
	}

	public void controlLocation(int key) {
		if(control == 0) {
			if(key == 0)
				addLocation(0, getSpeed(), 0);
			if(key == 1)
				addLocation(-getSpeed(), 0, 0);
			if(key == 2)
				addLocation(0, -getSpeed(), 0);
			if(key == 3)
				addLocation(getSpeed(), 0, 0);
		}

		if(control == 1) {
			if(key == 0)
				addLocation(getSpeed() * (float) Math.cos(Math.toRadians(getAngle())), getSpeed() * (float) Math.sin(Math.toRadians(getAngle())), 0.0f);
			if(key == 1)
				addAngle(5.0f);
			if(key == 3)
				addAngle(-5.0f);
		}
	}
}
