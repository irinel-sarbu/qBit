package net.vqbe.eventSystem.types.application;

import net.vqbe.eventSystem.Event;

import static net.vqbe.eventSystem.types.CoreEventType.WINDOW_CLOSED;

public final class WindowCloseEvent extends Event {
    public WindowCloseEvent() {
        super(WINDOW_CLOSED);
    }
}

