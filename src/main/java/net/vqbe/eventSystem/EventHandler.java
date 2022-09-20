package net.vqbe.eventSystem;

@FunctionalInterface
public interface EventHandler {
    boolean handle(Event event);
}
