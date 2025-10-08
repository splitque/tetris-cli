package splitque.tetris;

import lombok.Getter;

public final class Transform implements ITransformable {
    @Getter
    private int X;
    @Getter
    private int Y;

    public Transform(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    @Override
    public void set(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    @Override
    public void add(int X, int Y) {
        this.X += X;
        this.Y += Y;
    }

    @Override
    public void sub(int X, int Y) {
        this.X -= X;
        this.Y -= Y;
    }

    @Override
    public String toString() {
        return "Transform[X=" + X + ", Y=" + Y + "]";
    }
}
