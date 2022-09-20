package net.vqbe.eventSystem;

import java.util.ArrayList;
import java.util.List;

public class Observable {
    private final List<Observer> observers = new ArrayList<>();

    public final synchronized void register(Observer observer) {
        observers.add(observer);
    }

    public final synchronized void notify(Event event) {
        observers.forEach(observer -> observer.onEvent(event));
    }
}
