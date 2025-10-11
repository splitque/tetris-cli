package splitque.tetris;

import lombok.Getter;
import splitque.tetris.events.Event;
import splitque.tetris.events.EventManager;
import splitque.tetris.objects.GameObject;
import splitque.tetris.objects.ObjectComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Frame implements AutoCloseable {
    @Getter
    private final List<GameObject> objects = new CopyOnWriteArrayList<>();
    @Getter
    private final int maxX;
    @Getter
    private final int maxY;
    @Getter
    private boolean closed = false;

    public Frame(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public void start() {
        Renderer.render(this);
        while (!closed) {
            loop();
        }
    }

    public abstract void loop();

    public void registerObject(GameObject object) {
        objects.add(object);
    }

    public void registerEvent(Event event) {
        EventManager.getInstance().registerEvent(event);
    }

    public List<ObjectComponent> getAllComponents() {
        List<ObjectComponent> components = new ArrayList<>();
        for (GameObject object : objects) {
            components.addAll(object.getComponents());
        }
        return components;
    }

    @Override
    public void close() {
        objects.clear();
        EventManager.getInstance().clear();
        closed = true;
    }
}
