package splitque.tetris.frames;

import splitque.tetris.Frame;
import splitque.tetris.Location;
import splitque.tetris.events.Event;
import splitque.tetris.objects.border.HorizontalBorder;
import splitque.tetris.objects.border.HorizontalBorderWithTitle;
import splitque.tetris.objects.border.VerticalBorder;
import splitque.tetris.objects.text.Text;

public class DialogFrame extends Frame {
    public DialogFrame(int maxX, int maxY, String title, String description) {
        super(maxX, maxY);

        int borderMaxY = maxY - 1;

        registerObject(new HorizontalBorderWithTitle(maxX, 0, title));
        registerObject(new HorizontalBorder(maxX, borderMaxY));
        registerObject(new VerticalBorder(maxX , borderMaxY - 1));
        registerObject(new VerticalBorder(0, borderMaxY - 1));
        registerObject(new Text(2, borderMaxY / 2, description));
    }

    public void addButton(String text, Event event, Location location) {
        switch(location) {
            case LEFT: {
                registerObject(new Text(0, getMaxY(), text));
                registerEvent(event);
                break;
            }
            case RIGHT: {
                int textX = getMaxX() - text.length();
                registerObject(new Text(textX, getMaxY(), text));
                registerEvent(event);
                break;
            }
        }
    }

    @Override
    public void loop() {
    }
}
