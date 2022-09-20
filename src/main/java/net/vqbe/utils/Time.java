package net.vqbe.utils;

import static org.lwjgl.glfw.GLFW.glfwGetTime;

public final class Time {
    private Time() {
    }

    /**
     * @return Time in seconds since application started
     */
    public static synchronized double getTime() {
        return glfwGetTime();
    }
}
