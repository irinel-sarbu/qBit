package net.vqbe;

import net.vqbe.eventSystem.Event;
import net.vqbe.eventSystem.EventCallback;
import net.vqbe.eventSystem.EventDispatcher;
import net.vqbe.eventSystem.Observer;
import net.vqbe.eventSystem.types.application.WindowCloseEvent;
import net.vqbe.input.KeyCode;
import net.vqbe.input.Keyboard;
import net.vqbe.opengl.Window;
import org.lwjgl.Version;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.vqbe.eventSystem.types.CoreEventType.WINDOW_CLOSED;

public class Main implements Observer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private final Window window;
    private final Keyboard keyboard;

    public Main() {
        this.window = new Window();
        this.window.register(this);

        this.keyboard = Keyboard.getKeyboard();
    }

    public void run() {
        LOGGER.debug("Hello LWJGL {} !", Version.getVersion());

        while (!window.shouldClose()) {
            window.update();

            if (keyboard.isKeyJustPressed(KeyCode.KEY_SPACE)) {
                LOGGER.debug("Space pressed");
            }
        }

        window.shutdown();
    }

    public static void main(String[] args) {
        new Main().run();
    }

    @Override
    public void onEvent(Event event) {
        EventDispatcher dispatcher = new EventDispatcher(event);

        dispatcher.dispatch(WINDOW_CLOSED, (Event e) -> onWindowClose((WindowCloseEvent) e));
    }

    @EventCallback
    private boolean onWindowClose(WindowCloseEvent event) {
        LOGGER.debug("Window closed");
        return true;
    }
}