package splitque.tetris;

import splitque.tetris.objects.GameObject;

import java.util.ArrayList;
import java.util.List;

public final class Renderer {
    private static final List<String> LIST = new ArrayList<>();
    private static final StringBuilder SB = new StringBuilder();

    public synchronized static void render(Frame frame) {
        for (int y = 0; y <= frame.getMaxY(); y++) {
            for (int x = 0; x <= frame.getMaxX(); x++) {
                GameObject object = null;
                for (GameObject gameObject : frame.getObjects()) {
                    if (gameObject.getY() == y && gameObject.getX() == x) {
                        object = gameObject;
                        break;
                    }
                }
                if (object != null) SB.append(object.getCharacter());
                else SB.append(" ");
            }
            LIST.add(SB.toString());
            SB.setLength(0);
        }

        System.out.print("\033[H\033[J");
        for (String str : LIST) {
            System.out.println(str);
        }

        LIST.clear();
    }
}
