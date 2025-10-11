package splitque.tetris.frames;

import splitque.tetris.Frame;
import splitque.tetris.objects.border.HorizontalBorder;
import splitque.tetris.objects.border.HorizontalBorderWithTitle;
import splitque.tetris.objects.border.VerticalBorder;

public class GameFrame extends Frame {
    public GameFrame(int maxX, int maxY) {
        super(maxX, maxY);

        registerObject(new HorizontalBorderWithTitle(maxX, 0, "Tetris"));
        registerObject(new HorizontalBorder(maxX, maxY));
        registerObject(new VerticalBorder(maxX , maxY - 1));
        registerObject(new VerticalBorder(0, maxY - 1));


    }

    @Override
    public void loop() {

    }
}
