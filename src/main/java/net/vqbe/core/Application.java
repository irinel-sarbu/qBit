package net.vqbe.core;

import net.vqbe.eventSystem.Event;
import net.vqbe.eventSystem.EventDispatcher;
import net.vqbe.eventSystem.Observer;
import net.vqbe.eventSystem.types.CoreEventType;
import net.vqbe.eventSystem.types.application.WindowCloseEvent;
import net.vqbe.opengl.Window;
import net.vqbe.utils.Time;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Application implements Observer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    private final Window window;
    private boolean running;

    public Application() {
        LOGGER.debug("Initializing application...");

        this.window = new Window();
        this.window.register(this);

        this.running = true;
    }

    public final void run() {

        double lastTime = Time.getTime();
        while (running) {
            // Frame time calculation
            double currentTime = Time.getTime();
            double dt = currentTime - lastTime;
            lastTime = currentTime;

            processInput();
            update();
            render();

            window.update();
        }

        window.shutdown();
    }

    public abstract void processInput();

    public abstract void update();

    public abstract void render();

    @Override
    public void onEvent(Event event) {
        EventDispatcher dispatcher = new EventDispatcher(event);

        dispatcher.dispatch(CoreEventType.WINDOW_CLOSED, (e) -> onWindowClose((WindowCloseEvent) e));
    }

    private boolean onWindowClose(WindowCloseEvent e) {
        LOGGER.debug("Application closing...");

        running = false;
        return true;
    }
}
