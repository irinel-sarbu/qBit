package net.vqbe.opengl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Window {
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

//        glfwSetWindowCloseCallback(m_Window, (window) -> notify(new WindowCloseEvent()));
//
//        glfwSetCharCallback(m_Window, (window, key) -> notify(new KeyTypedEvent(KeyCode.get(key))));
//        glfwSetKeyCallback(m_Window, (window, key, scancode, action, mods) -> {
//            switch (action) {
//                case GLFW_PRESS -> notify(new KeyPressedEvent(KeyCode.get(key), 0));
//                case GLFW_RELEASE -> notify(new KeyReleasedEvent(KeyCode.get(key)));
//                case GLFW_REPEAT -> notify(new KeyPressedEvent(KeyCode.get(key), 1));
//            }
//        });

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
