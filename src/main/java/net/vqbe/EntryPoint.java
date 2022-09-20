package net.vqbe;

import net.vqbe.core.Application;
import net.vqbe.eventSystem.Event;
import net.vqbe.eventSystem.EventDispatcher;

public class EntryPoint extends Application {

    public static void main(String[] args) {
        Application app = new EntryPoint();
        app.run();
    }

    @Override
    public void processInput() {

    }

    @Override
    public void update() {

    }

    @Override
    public void render() {

    }

    @Override
    public void onEvent(Event event) {
        // Super must be called to ensure that application closes correctly
        super.onEvent(event);
        if (event.isHandled()) return;

        EventDispatcher dispatcher = new EventDispatcher(event);
    }
}
