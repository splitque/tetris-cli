package splitque.tetris.objects.border;

import splitque.tetris.objects.GameObject;
import splitque.tetris.objects.ObjectComponent;

public class HorizontalBorder extends GameObject {
    public HorizontalBorder(int x, int y) {
        for (int i = 0; i <= x; i++) {
            registerComponent(new ObjectComponent('-', i, y));
        }
    }
}
