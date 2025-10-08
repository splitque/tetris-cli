package splitque.tetris;

import splitque.tetris.objects.GameObject;
import splitque.tetris.objects.ObjectComponent;

import java.util.ArrayList;
import java.util.List;

public final class Renderer {
    private static final List<String> LIST = new ArrayList<>();
    private static final StringBuilder SB = new StringBuilder();

    public synchronized static void render(Frame frame) {
        for (int y = 0; y <= frame.getMaxY(); y++) {
            for (int x = 0; x <= frame.getMaxX(); x++) {
                ObjectComponent targetComponent = null;
                for (ObjectComponent component : frame.getAllComponents()) {
                    if (component.getY() == y && component.getX() == x) {
                        targetComponent = component;
                        break;
                    }
                }
                if (targetComponent != null) SB.append(targetComponent.getCharacter());
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
