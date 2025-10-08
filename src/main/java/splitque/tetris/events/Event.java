package splitque.tetris.events;

import lombok.Getter;

public abstract class Event {
    @Getter
    private final char character;

    public Event(char character) {
        this.character = character;
    }

    public abstract void handleEvent();
}
