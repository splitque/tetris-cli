package splitque.tetris.events;

import splitque.tetris.Frame;

public abstract class KeyboardEvent {
    private final Frame frame;
    private final char character;

    public KeyboardEvent(Frame frame, char character) {
        this.frame = frame;
        this.character = character;
    }

    public abstract void handleEvent();

    public Frame getFrame() {
        return frame;
    }

    public char getCharacter() {
        return character;
    }
}
