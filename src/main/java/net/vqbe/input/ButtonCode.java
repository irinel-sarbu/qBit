package net.vqbe.input;

public enum ButtonCode {
    BUTTON_1(0),
    BUTTON_2(1),
    BUTTON_3(2),
    BUTTON_4(3),
    BUTTON_5(4),
    BUTTON_6(5),
    BUTTON_7(6),
    BUTTON_8(7),
    BUTTON_LEFT(0),
    BUTTON_RIGHT(1),
    BUTTON_MIDDLE(2);

    private final int value;

    ButtonCode(int value) {
        this.value = value;
    }

    public synchronized int getValue() {
        return value;
    }
}
