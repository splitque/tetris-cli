package splitque.tetris;

import splitque.tetris.events.KeyboardEvent;
import splitque.tetris.events.EventManager;
import splitque.tetris.events.ScheduleEvent;
import splitque.tetris.objects.GameObject;
import splitque.tetris.objects.Tag;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Frame {
    private final EventManager eventManager = new EventManager();
    private final Set<GameObject> objects = new HashSet<>();
    private final Set<Tag> tags = new HashSet<>();
    private final int maxX;
    private final int maxY;

    public Frame(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public void registerObject(GameObject object) {
        tags.add(object.getTag());
        objects.add(object);
    }

    public void deleteObject(GameObject object) {
        objects.remove(object);
    }

    public void registerObjects(Tag tag) {
        tags.add(tag);
        if (tag.haveObjects()) objects.addAll(tag.getObjects());
    }

    public void registerKeyboardEvent(KeyboardEvent keyboardEvent) {
        eventManager.registerKeyboardEvent(keyboardEvent);
    }

    public void registerScheduleEvent(ScheduleEvent scheduleEvent) {
        eventManager.registerScheduleEvent(scheduleEvent);
    }

    public void close() {
        eventManager.close();
        objects.clear();
        tags.clear();
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public Set<GameObject> getObjects() {
        return objects;
    }

    public Set<Tag> getTags() {
        return tags;
    }
}
