package net.vqbe.opengl;

public class WindowProps {
    private final String title;
    private final int width, height;

    public WindowProps(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
    }

    public String getTitle() {
        return title;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "WindowProps { title='" + title + "', width=" + width + ", height=" + height + " }";
    }
}
