package com.projectsapphire.engine.maths;

import com.projectsapphire.level.Entity;

public class Relations {

	public static float sqr(float value) {
		return value * value;
	}

	public static float distance(Entity target1, Entity target2) {
		return (float) Math.sqrt(sqr(target1.getLocation().y - target2.getLocation().y) + sqr(target1.getLocation().x - target2.getLocation().x));
	}	

	public static float angle(Entity target1, Entity target2) {
		if((target1.getLocation().x - target2.getLocation().x) != 0)
			return (float) Math.toDegrees(Math.atan((target1.getLocation().y - target2.getLocation().y)/ (target1.getLocation().x - target2.getLocation().x)));
		else
			return 90;
	}

	public static boolean checkCollision(Entity target1, Entity target2) {
		return (distance(target1, target2) < target1.getRADIUS() + target2.getRADIUS());
	}
}
