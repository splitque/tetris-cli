package splitque.tetris.objects.text;

import splitque.tetris.objects.GameObject;
import splitque.tetris.objects.ObjectComponent;

public class Text extends GameObject {
    public Text(int x, int y, String text) {
        for (int i = 0; i < text.length(); i++) {
            registerComponent(new ObjectComponent(text.charAt(i), x, y));
            x++;
        }
    }
}
