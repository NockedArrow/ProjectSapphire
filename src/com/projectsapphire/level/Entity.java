package com.projectsapphire.level;

import com.projectsapphire.engine.graphics.Shader;
import com.projectsapphire.engine.graphics.Texture;
import com.projectsapphire.engine.graphics.VertexArray;
import com.projectsapphire.engine.maths.Matrix4f;
import com.projectsapphire.engine.maths.Vector3f;

public class Entity {

	private float angle;
	private float speed = 0.01f;
	protected Vector3f location;
	private int entityID;
	public static final float RADIUS = 0.05f;
	public static final float BOUND = 0.5f - RADIUS;

	private VertexArray background;
	protected Texture bgTexture;

	public Entity() {
		float[] vertices = new float[] {
				-RADIUS, RADIUS, 0.0f,
				-RADIUS, -RADIUS, 0.0f,
				RADIUS, -RADIUS, 0.0f,
				RADIUS, RADIUS, 0.0f
		};

		byte[] indices = new byte[] {
				0, 1, 3,
				3, 1, 2
		};

		float[] tcs = new float[] { 
				0, 0,
				0, 1,
				1, 1,
				1, 0
		};

		background = new VertexArray(vertices, indices, tcs);
		bgTexture = new Texture("res/circle.png");

		location = new Vector3f();
	}

	public void update() {
		//Common functions
	}

	public void render() {
		bgTexture.bind();
		Shader.BG.enable();
		background.bind();
		Shader.BG.setUniformMat4f("vw_matrix", Matrix4f.translate(location));
		background.draw();
		Shader.BG.disable();
		bgTexture.unbind();
	}

	public boolean isNotInside() {
		if((location.x > BOUND)||(location.y > BOUND)||(location.x < -BOUND)||( location.y < -BOUND))
			return true;
		else 
			return false;
	}

	public int getEntityID() {
		return entityID;
	}

	public void setEntityID(int entityID) {
		this.entityID = entityID + 1;
	}

	public Vector3f getLocation() {
		return location;
	}	
	
	public void setLocation(float x, float y, float z) {
		location.x = x;
		location.y = y;
		location.z = z;
	}
	
	public void addLocation(float x, float y, float z) {
		location.x += x;
		location.y += y;
		location.z += z;
	}
	
	public float getAngle() {
		return angle;
	}
	
	public void setAngle(float angle) {
		this.angle = angle;
	}
	
	public void addAngle(float angle) {
		this.angle += angle;
	}
	
	public float getSpeed() {
		return speed;
	}
}