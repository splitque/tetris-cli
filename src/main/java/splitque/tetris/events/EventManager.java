package splitque.tetris.events;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class EventManager {
    @Getter
    private static final EventManager instance = new EventManager();
    private final List<Event> events = new CopyOnWriteArrayList<>();
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
                    handleEvent(e.getKeyChar());
                }
            });
        }, "Event-Thread");

        thread.start();
    }

    public void registerEvent(Event event) {
        events.add(event);
    }

    public void handleEvent(char c) {
        for (Event e : events) {
            if (e.getCharacter() == c) e.handleEvent();
        }
    }

    public void clear() {
        events.clear();
    }
}
