package splitque.tetris.events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EventManager {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final List<KeyboardEvent> keyboardEvents = new CopyOnWriteArrayList<>();
    private JFrame jframe;

    public EventManager() {
        Thread thread = new Thread(() -> {
            jframe = new JFrame();
            jframe.setUndecorated(true);
            jframe.setSize(400, 400);
            jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
            jframe.setLayout(new GridBagLayout());
            jframe.setOpacity(0.0f);
            jframe.setVisible(true);

            jframe.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {

                }

                @Override
                public void keyPressed(KeyEvent e) {

                }

                @Override
                public void keyReleased(KeyEvent e) {
                    handleKeyboardEvent(e.getKeyChar());
                }
            });
        }, "Event-Thread");

        thread.start();
    }

    public void registerKeyboardEvent(KeyboardEvent keyboardEvent) {
        keyboardEvents.add(keyboardEvent);
    }

    public void registerScheduleEvent(ScheduleEvent scheduleEvent) {
        scheduler.scheduleAtFixedRate(scheduleEvent::handleEvent, 0, scheduleEvent.getPeriod(), TimeUnit.SECONDS);
    }

    public void handleKeyboardEvent(char c) {
        for (KeyboardEvent e : keyboardEvents) {
            if (e.getCharacter() == c) e.handleEvent();
        }
    }

    public void close() {
        keyboardEvents.clear();
        jframe.setVisible(false);
        jframe.dispose();
        scheduler.shutdownNow();
    }
}
