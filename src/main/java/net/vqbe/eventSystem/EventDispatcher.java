package net.vqbe.eventSystem;

public final class EventDispatcher {
    private final Event event;

    public EventDispatcher(Event event) {
        this.event = event;
    }

    public void dispatch(EventType type, EventHandler handler) {
        if (event.handled) return;

        if (event.getType() == type) {
            event.handled = handler.handle(event);
        }
    }
}
