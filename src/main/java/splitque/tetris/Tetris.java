package splitque.tetris;

import splitque.tetris.events.Event;
import splitque.tetris.frames.DialogFrame;

public class Tetris {
    void main() {
        try (DialogFrame dialogFrame = new DialogFrame(40, 5, "Tetris", "Welcome to Tetris! Made by splitque.")) {
            dialogFrame.addButton("(E) Exit", new Event('e') {
                @Override
                public void handleEvent() {
                    System.exit(0);
                }
            }, Location.RIGHT);

            dialogFrame.addButton("(P) Play", new Event('p') {
                @Override
                public void handleEvent() {
                    dialogFrame.close();
                }
            }, Location.LEFT);

            dialogFrame.start();
        }

        try () {

        }
    }
}
