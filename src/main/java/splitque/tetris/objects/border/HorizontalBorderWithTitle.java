package splitque.tetris.objects.border;

import splitque.tetris.objects.GameObject;
import splitque.tetris.objects.ObjectComponent;

public class HorizontalBorderWithTitle extends GameObject {
    public HorizontalBorderWithTitle(int x, int y, String title) {
        boolean border = true;

        int midX = x / 2;
        int midTitle = title.length() / 2;
        int titleSize = title.length();
        int charAt = 0;

        for (int i = 0; i <= x; i++) {
            if (i + midTitle == midX) border = false;

            if (border) {
                registerComponent(new ObjectComponent('-', i, y));
            } else {
                registerComponent(new ObjectComponent(title.charAt(charAt), i, y));
                charAt++;
                titleSize--;
            }

            if (titleSize == 0) border = true;
        }

    }
}
