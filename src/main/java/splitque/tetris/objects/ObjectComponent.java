package splitque.tetris.objects;

import lombok.Getter;
import splitque.tetris.ITransformable;
import splitque.tetris.Transform;

public class ObjectComponent implements ITransformable {
    @Getter
    private final char character;
    private final Transform transform;

    public ObjectComponent(char character, int x, int y) {
        this.character = character;
        this.transform = new Transform(x, y);
    }

    @Override
    public void set(int X, int Y) {
        transform.set(X, Y);
    }

    @Override
    public void add(int X, int Y) {
        transform.add(X, Y);
    }

    @Override
    public void sub(int X, int Y) {
        transform.sub(X, Y);
    }

    public int getX() {
        return transform.getX();
    }

    public int getY() {
        return transform.getY();
    }
}
