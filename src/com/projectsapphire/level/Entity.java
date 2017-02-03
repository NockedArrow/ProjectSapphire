package com.projectsapphire.level;

import com.projectsapphire.engine.graphics.Shader;
import com.projectsapphire.engine.graphics.Texture;
import com.projectsapphire.engine.graphics.VertexArray;
import com.projectsapphire.engine.maths.Matrix4f;
import com.projectsapphire.engine.maths.Vector3f;

public class Entity {

	protected Vector3f location; 
	protected float angle;
	private int entityID;
	private final float RADIUS = 0.05f;
	protected final float SPEED = 0.01f;
	protected final float BOUND = 0.5f-getRADIUS();

	private VertexArray background;
	protected Texture bgTexture;

	public Entity() {
		float[] vertices = new float[] {
				-getRADIUS(), getRADIUS(), 0.0f,
				-getRADIUS(), -getRADIUS(), 0.0f,
				getRADIUS(), -getRADIUS(), 0.0f,
				getRADIUS(), getRADIUS(), 0.0f
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

	public float getRADIUS() {
		return RADIUS;
	}
}