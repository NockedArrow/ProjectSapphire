package com.projectsapphire.level;

public class NPC extends Entity{

	public NPC() {
		setLocation((float)(2.0f * BOUND * Math.random() - BOUND), (float)(2.0f * BOUND * Math.random() - BOUND), 0.0f);
		 setAngle((float) (360*Math.random()));
	}
	
	public void update() {

		addLocation(getSpeed() * (float) Math.cos(Math.toRadians(getAngle())), 
				getSpeed() * (float) Math.sin(Math.toRadians(getAngle())), 0.0f);

		if(isNotInside())
			collided();

		if(getAngle() > 360.0f)
			setAngle(-360.0f);
		if(getAngle() < 0.0f)
			setAngle(360.0f);
	}
	
	public void collided() {
		setAngle((float) (360*Math.random() + 1.0f));
	}
}
