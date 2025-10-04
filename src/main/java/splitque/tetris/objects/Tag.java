package splitque.tetris.objects;

import splitque.tetris.Frame;

import java.util.ArrayList;
import java.util.List;

public class Tag {
    private final List<GameObject> objects = new ArrayList<>();
    private final Frame frame;
    private final String name;

    public Tag(Frame frame, String name, GameObject object) {
        this.name = name;
        this.frame = frame;
        objects.add(object);
    }

    public Tag(Frame frame, String name) {
        this.name = name;
        this.frame = frame;
    }

    public void registerObject(GameObject object) {
        frame.registerObject(object);
        objects.add(object);
    }

    public void deleteObject(GameObject object) {
        frame.deleteObject(object);
        objects.remove(object);
    }

    public String getName() {
        return name;
    }

    public List<GameObject> getObjects() {
        return objects;
    }

    public boolean haveObjects() {
        return !objects.isEmpty();
    }

    public void clear() {
        objects.clear();
    }
}
