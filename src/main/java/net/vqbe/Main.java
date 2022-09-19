package net.vqbe;

import net.vqbe.opengl.Window;
import org.lwjgl.Version;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private final Window window;

    public Main() {
        this.window = new Window();
    }

    public void run() {
        LOGGER.debug("Hello LWJGL {} !", Version.getVersion());

        while (!window.shouldClose()) {
            window.update();
        }

        window.shutdown();
    }

    public static void main(String[] args) {
        new Main().run();
    }

}