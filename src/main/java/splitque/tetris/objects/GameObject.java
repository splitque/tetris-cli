package splitque.tetris.objects;

import lombok.Getter;
import splitque.tetris.ITransformable;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class GameObject implements ITransformable {
    @Getter
    private final List<ObjectComponent> components = new CopyOnWriteArrayList<>();

    public void registerComponent(ObjectComponent component) {
        components.add(component);
    }

    @Override
    public void set(int X, int Y) {
        for (ObjectComponent component : components) {
            component.set(X, Y);
        }
    }

    @Override
    public void add(int X, int Y) {
        for (ObjectComponent component : components) {
            component.add(X, Y);
        }
    }

    @Override
    public void sub(int X, int Y) {
        for (ObjectComponent component : components) {
            component.sub(X, Y);
        }
    }
}
