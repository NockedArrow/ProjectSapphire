package com.projectsapphire.engine.level;

public class NPC extends Entity{

	public NPC() {
		setLocation((float)(2.0f * BOUND * Math.random() - BOUND), (float)(2.0f * BOUND * Math.random() - BOUND), 0.0f);
		 angle = (float) (360*Math.random());
	}
	
	public void update() {

		addLocation(SPEED * (float) Math.cos(Math.toRadians(angle)), SPEED * (float) Math.sin(Math.toRadians(angle)), 0.0f);

		if(isNotInside())
			collided();//(float) (180*Math.random() + 1.0f);

		if(angle > 360.0f)
			angle -= 360.0f;
		if(angle < 0.0f)
			angle += 360.0f;
	}
	
	public void collided() {
		angle += 60;//(float) (180*Math.random() + 1.0f);
	}
}
