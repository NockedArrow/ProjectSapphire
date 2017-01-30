package com.thecherno.flappy.level;

public class NPC extends Entity{

	public NPC() {
		x = (float) (2.0f * BOUND * Math.random() - BOUND);
		y = (float) (2.0f * BOUND * Math.random() - BOUND);
		 angle = (float) (360*Math.random());
	}
	
	public void update() {

		x += SPEED * Math.cos(Math.toRadians(angle));
		y += SPEED * Math.sin(Math.toRadians(angle));

		if(isNotInside())
			angle += (float) (180*Math.random() + 1.0f);

		if(angle > 360.0f)
			angle -= 360.0f;
		if(angle < 0.0f)
			angle += 360.0f;
	}
}
