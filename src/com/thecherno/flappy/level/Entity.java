package com.thecherno.flappy.level;

import com.thecherno.flappy.graphics.Shader;
import com.thecherno.flappy.graphics.Texture;
import com.thecherno.flappy.graphics.VertexArray;
import com.thecherno.flappy.maths.Matrix4f;
import com.thecherno.flappy.maths.Vector3f;

public class Entity {

	protected float x;
	protected float y;
	protected float angle;
	private final float RADIUS = 0.05f;
	protected final float SPEED = 0.01f;
	protected final float BOUND = 1.0f;

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
	}

	public void update() {
		//Common functions
	}

	public void render() {
		bgTexture.bind();
		Shader.BG.enable();
		background.bind();
		Shader.BG.setUniformMat4f("vw_matrix", Matrix4f.translate(new Vector3f(x, y, 0.0f)));
		background.draw();
		Shader.BG.disable();
		bgTexture.unbind();
	}

	public boolean isNotInside() {
		if((x > BOUND)||(y > BOUND)||(x < -BOUND)||( y < -BOUND))
			return true;
		else 
			return false;
	}
}