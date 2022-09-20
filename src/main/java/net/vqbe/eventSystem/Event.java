package net.vqbe.eventSystem;

public class Event {
    private final EventType type;
    protected boolean handled = false;

    protected Event(EventType type) {
        this.type = type;
    }

    public EventType getType() {
        return type;
    }
}
