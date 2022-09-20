package net.vqbe.input;

import static org.lwjgl.glfw.GLFW.*;

public final class Mouse {
    private enum ButtonStatus {
        RELEASED,
        PRESSED,
    }

    private static Mouse instance;

    private final ButtonStatus[] buttons;
    private float posX, posY;

    private Mouse() {
        this.buttons = new ButtonStatus[GLFW_MOUSE_BUTTON_LAST];
    }

    public static Mouse getMouse() {
        if (instance == null) {
            instance = new Mouse();
        }

        return instance;
    }

    public static synchronized void mousePosCallback(long window, double x, double y) {
        Mouse mouse = getMouse();
        mouse.posX = (float) x;
        mouse.posY = (float) y;
    }

    public static synchronized void mouseScrollCallback(long window, double x, double y) {
        Mouse mouse = getMouse();
        //TODO: implement scroll callback
    }

    public static synchronized void mouseButtonCallback(long window, int button, int action, int mods) {
        Mouse mouse = getMouse();

        switch (action) {
            case GLFW_RELEASE -> mouse.buttons[button] = ButtonStatus.RELEASED;
            case GLFW_PRESS -> mouse.buttons[button] = ButtonStatus.PRESSED;
        }
    }

    public synchronized float getPosX() {
        return posX;
    }

    public synchronized float getPosY() {
        return posY;
    }

    public synchronized boolean isButtonPressed(ButtonCode button) {
        return buttons[button.getValue()] == ButtonStatus.PRESSED;
    }
}
