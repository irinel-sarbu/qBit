package net.vqbe.opengl;

import net.vqbe.eventSystem.Observable;
import net.vqbe.eventSystem.types.application.WindowCloseEvent;
import net.vqbe.input.Keyboard;
import net.vqbe.input.Mouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Window extends Observable {
    private static final Logger LOGGER = LoggerFactory.getLogger(Window.class);

    private long glWindow;
    private GraphicsContext context;
    private boolean vSync;

    public Window() {
        init();
    }

    private void init() {
        if (!glfwInit())
            throw new RuntimeException("Unable to initialize GLFW");

        glWindow = glfwCreateWindow(1280, 720, "TODO REPLACE TITLE", NULL, NULL);
        if (glWindow == NULL)
            throw new RuntimeException("Failed to create the GLFW m_Window");

        context = new GraphicsContext(this);
        context.init();

        setVsync(false);

        glfwSetWindowCloseCallback(glWindow, (window) -> notify(new WindowCloseEvent()));

        glfwSetCursorPosCallback(glWindow, Mouse::mousePosCallback);
        glfwSetScrollCallback(glWindow, Mouse::mouseScrollCallback);
        glfwSetMouseButtonCallback(glWindow, Mouse::mouseButtonCallback);

        glfwSetKeyCallback(glWindow, Keyboard::keyCallback);
    }

    public long getGlWindow() {
        return glWindow;
    }

    public boolean shouldClose() {
        return glfwWindowShouldClose(glWindow);
    }

    public void shutdown() {
        glfwDestroyWindow(glWindow);
        glfwTerminate();
    }

    public void update() {
        glfwPollEvents();
        glfwSwapBuffers(glWindow);
    }

    public void setVsync(boolean enabled) {
        this.vSync = enabled;

        glfwSwapInterval(enabled ? 1 : 0);
    }

    public boolean isVSync() {
        return vSync;
    }

}
