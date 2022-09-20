package net.vqbe.opengl;

import org.lwjgl.opengl.GL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.opengl.GL41.*;

class GraphicsContext {
    private final static Logger LOGGER = LoggerFactory.getLogger(GraphicsContext.class);
    private final Window window;

    public GraphicsContext(Window window) {
        this.window = window;
    }

    public void init() {
        final String prefix = "init - ";

        glfwMakeContextCurrent(window.getGlWindow());
        GL.createCapabilities();

        LOGGER.debug("{} Vendor:   {}", prefix, glGetString(GL_VENDOR));
        LOGGER.debug("{} Renderer: {}", prefix, glGetString(GL_RENDERER));
        LOGGER.debug("{} Version:  {}", prefix, glGetString(GL_VERSION));
    }
}
