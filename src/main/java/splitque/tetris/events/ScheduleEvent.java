package splitque.tetris.events;

import splitque.tetris.Frame;

public abstract class ScheduleEvent {
    private final Frame frame;
    private final int period;

    public ScheduleEvent(Frame frame, int period) {
        this.frame = frame;
        this.period = period;
    }

    public abstract void handleEvent();

    public Frame getFrame() {
        return frame;
    }

    public int getPeriod() {
        return period;
    }
}
