package net.vqbe.input;

import static org.lwjgl.glfw.GLFW.*;

public final class Keyboard {
    private enum KeyStatus {
        RELEASED,
        PRESSED,
        REPEATED
    }

    private static Keyboard instance;

    private final KeyStatus[] keys;

    private Keyboard() {
        this.keys = new KeyStatus[GLFW_KEY_LAST];
    }

    public static Keyboard getKeyboard() {
        if (instance == null) {
            instance = new Keyboard();
        }
        return instance;
    }

    public static synchronized void keyCallback(long window, int key, int scancode, int action, int mods) {
        Keyboard keyboard = getKeyboard();
        switch (action) {
            case GLFW_RELEASE -> keyboard.keys[key] = KeyStatus.RELEASED;
            case GLFW_PRESS -> keyboard.keys[key] = KeyStatus.PRESSED;
            case GLFW_REPEAT -> keyboard.keys[key] = KeyStatus.REPEATED;
        }
    }

    public synchronized boolean isKeyJustPressed(KeyCode key) {
        if (keys[key.getValue()] == KeyStatus.PRESSED) {
            keys[key.getValue()] = KeyStatus.REPEATED;
            return true;
        }
        return false;
    }

    public synchronized boolean isKeyPressed(KeyCode key) {
        if (keys[key.getValue()] == KeyStatus.PRESSED) {
            keys[key.getValue()] = KeyStatus.REPEATED;
            return true;
        }

        return keys[key.getValue()] == KeyStatus.REPEATED;
    }
}
