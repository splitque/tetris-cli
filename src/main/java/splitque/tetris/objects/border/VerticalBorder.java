package splitque.tetris.objects.border;

import splitque.tetris.objects.GameObject;
import splitque.tetris.objects.ObjectComponent;

public class VerticalBorder extends GameObject {
    public VerticalBorder(int x, int y) {
        super(x, y);

        for (int i = 1; i <= y; i++) {
            registerComponent(new ObjectComponent('|', x, i));
        }
    }
}
