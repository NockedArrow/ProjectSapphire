package com.projectsapphire.engine;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.*;
import static org.lwjgl.system.MemoryUtil.*;

import org.lwjgl.opengl.GL;

import com.projectsapphire.engine.graphics.Shader;
import com.projectsapphire.engine.input.Input;
import com.projectsapphire.engine.level.EntityManager;
import com.projectsapphire.engine.maths.Matrix4f;

public class Main implements Runnable {

	private Thread thread;

	public final int width= 400;
	public final int height= 400;
	private long window;
	public EntityManager entityManager;

	public void start() {
		thread = new Thread(this, "Game");
		thread.start();
	}

	private void init() {
		glfwInit();
		window = glfwCreateWindow(width, height, "2D Physics test", NULL, NULL);
		
		glfwSetKeyCallback(window, new Input());

		glfwMakeContextCurrent(window);
		GL.createCapabilities();
		glActiveTexture(GL_TEXTURE1);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		Shader.loadAll();

		Matrix4f pr_matrix = Matrix4f.orthographic(-1.0f, 1.0f, -1.0f, 1.0f, -1.0f, 1.0f);
		Shader.BG.setUniformMat4f("pr_matrix", pr_matrix);
		Shader.BG.setUniform1i("tex", 1);

		entityManager = new EntityManager(2);
	}

	public void run() {
		init();
		while (glfwWindowShouldClose(window) == false) {
			glfwPollEvents();
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			glClearColor(0.5f, 0.0f, 0.5f, 1.0f);
			entityManager.render();
			glfwSetWindowTitle(window, "2D Physics test: " + entityManager.countInside());
			glfwSwapBuffers(window);
		}	
		glfwDestroyWindow(window);
		glfwTerminate();
	}
	
	public static void main(String[] args) {
		new Main().start();
	}
}
