package splitque.tetris;

import splitque.tetris.events.KeyboardEvent;
import splitque.tetris.events.ScheduleEvent;
import splitque.tetris.objects.GameObject;
import splitque.tetris.objects.Tag;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tetris {
    void getBorder(Frame frame, int X, int Y) {
        Tag tag = new Tag(frame, "Border");

        // HORIZONTAL
        for (int x = 0; x <= X; x++) {
            tag.registerObject(new GameObject(tag, '-', x, 0));
        }
        for (int x = 0; x <= X; x++) {
            tag.registerObject(new GameObject(tag, '-', x, Y));
        }

        // VERTICAL
        for (int y = 1; y < Y; y++) {
            tag.registerObject(new GameObject(tag, '|', 0, y));
        }
        for (int y = 1; y < Y; y++) {
            tag.registerObject(new GameObject(tag, '|', X, y));
        }
    }

    void main() throws IOException {
        Frame welcomeFrame = new Frame(40, 4);
        getBorder(welcomeFrame, 40, 4);

        Tag text = new Tag(welcomeFrame, "Text");
        String welcome = "Welcome to Tetris! Made by splitque.";
        int p = 2;
        for (int i = 0; i < welcome.length(); i++) {
            welcomeFrame.registerObject(new GameObject(text, welcome.charAt(i), p, 1));
            p++;
        }
        p = 2;

        Tag play = new Tag(welcomeFrame, "Play");
        String playText = "(P) Play";
        for (int i = 0; i < playText.length(); i++) {
            welcomeFrame.registerObject(new GameObject(play, playText.charAt(i), p, 3));
            p++;
        }
        p = 0;

        Renderer.render(welcomeFrame);

        welcomeFrame.registerKeyboardEvent(new KeyboardEvent(welcomeFrame, 'p') {
            @Override
            public void handleEvent() {
                Random rand = new Random();
                welcomeFrame.close();

                Frame gameFrame = new Frame(25, 15);
                Tag mainObject = new Tag(gameFrame, "main");
                Tag inactiveObject = new Tag(gameFrame, "inactive");
                getBorder(gameFrame, 25, 15);

                gameFrame.registerScheduleEvent(new ScheduleEvent(gameFrame, 1) {
                    @Override
                    public void handleEvent() {
                        // Проверка на заполненность линии
                        if (inactiveObject.haveObjects()) {
                            int minY = 100;
                            int maxY = 0;

                            // Get minY & maxY
                            for (GameObject object : inactiveObject.getObjects()) {
                                if (object.getY() < minY) minY = object.getY();
                                if (object.getY() > maxY) maxY = object.getY();
                            }

                            // Проверка линий
                            List<GameObject> objs = new ArrayList<>();
                            for (int i = minY; i <= maxY; i++) {
                                for (GameObject object : inactiveObject.getObjects()) {
                                    if (object.getY() == i) objs.add(object);
                                }
                                // Если линия полная
                                if (objs.size() == gameFrame.getMaxX() - 1) {
                                    for (GameObject object : objs) {
                                        inactiveObject.deleteObject(object);
                                    }
                                    for (GameObject object : inactiveObject.getObjects()) {
                                        if (object.getY() < i) object.setY(object.getY() + 1);
                                    }
                                }
                                objs.clear();
                            }
                        }

                        // Проверка на переполненность игрового поля
                        if (inactiveObject.haveObjects()) {
                            for (GameObject obj : inactiveObject.getObjects()) {
                                if (obj.getY() < 3) {
                                    System.exit(1);
                                }
                            }
                        }

                        // Если на поле все объекты приземлились
                        if (!mainObject.haveObjects()) {
                            int i = rand.nextInt(12);
                            int x = gameFrame.getMaxX() / 2;
                            int y = 1;

                            switch (i) {
                                case 0: {
                                    try {
                                        Files.writeString(Path.of("log.txt"), "0");
                                    } catch (IOException e) { }
                                    for (int j = 0; j <= 2; j++) {
                                        mainObject.registerObject(new GameObject(mainObject, '#', x, y));
                                        y++;
                                    }
                                    break;
                                }
                                case 1: {
                                    x--;
                                    for (int j = 0; j <= 2; j++) {
                                        mainObject.registerObject(new GameObject(mainObject, '#', x, y));
                                        x++;
                                    }
                                    break;
                                }
                                case 2: {
                                    x--;
                                    for (int j = 0; j <= 2; j++) {
                                        mainObject.registerObject(new GameObject(mainObject, '#', x, y));
                                        x++;
                                    }
                                    x--;
                                    mainObject.registerObject(new GameObject(mainObject, '#', x, y + 1));
                                    break;
                                }
                                case 3: {
                                    mainObject.registerObject(new GameObject(mainObject, '#', x, y));
                                    y++;
                                    x--;
                                    for (int j = 0; j <= 2; j++) {
                                        mainObject.registerObject(new GameObject(mainObject, '#', x, y));
                                        x++;
                                    }
                                    break;
                                }
                                case 4: {
                                    mainObject.registerObject(new GameObject(mainObject, '#', x, y + 1));
                                    x--;
                                    for (int j = 0; j <= 2; j++) {
                                        mainObject.registerObject(new GameObject(mainObject, '#', x, y));
                                        y++;
                                    }
                                    break;
                                }
                                case 5: {
                                    mainObject.registerObject(new GameObject(mainObject, '#', x, y + 1));
                                    x++;
                                    for (int j = 0; j <= 2; j++) {
                                        mainObject.registerObject(new GameObject(mainObject, '#', x, y));
                                        y++;
                                    }
                                    break;
                                }
                                case 6: {
                                    for (int j = 0; j <= 1; j++) {
                                        mainObject.registerObject(new GameObject(mainObject, '#', x, y));
                                        y++;
                                    }
                                    break;
                                }
                                case 7: {
                                    x--;
                                    for (int j = 0; j <= 1; j++) {
                                        mainObject.registerObject(new GameObject(mainObject, '#', x, y));
                                        x++;
                                    }
                                    break;
                                }
                                case 8: {
                                    mainObject.registerObject(new GameObject(mainObject, '#', x, y));
                                    x--;
                                    for (int j = 0; j <= 2; j++) {
                                        mainObject.registerObject(new GameObject(mainObject, '#', x, y));
                                        x++;
                                    }
                                    break;
                                }
                                case 9: {
                                    mainObject.registerObject(new GameObject(mainObject, '#', x, y));
                                    x++;
                                    for (int j = 0; j <= 2; j++) {
                                        mainObject.registerObject(new GameObject(mainObject, '#', x, y));
                                        y++;
                                    }
                                    break;
                                }
                                case 10: {
                                    mainObject.registerObject(new GameObject(mainObject, '#', x, y + 2));
                                    x--;
                                    for (int j = 0; j <= 2; j++) {
                                        mainObject.registerObject(new GameObject(mainObject, '#', x, y));
                                        y++;
                                    }
                                    break;
                                }
                                case 11: {
                                    mainObject.registerObject(new GameObject(mainObject, '#', x, y + 2));
                                    x++;
                                    for (int j = 0; j <= 2; j++) {
                                        mainObject.registerObject(new GameObject(mainObject, '#', x, y));
                                        y++;
                                    }
                                    break;
                                }
                            }
                        // Если на поле есть основной игровой объект, летящий вниз
                        } else {
                            // Проверки на то, нужно ли перевести основной объект к инактивным, тоесть приземлившимся
                            boolean stop = false;
                            // Проверка того, достиг ли основной объект предела поля
                            for (GameObject object : mainObject.getObjects()) {
                                if (object.getY() == gameFrame.getMaxY() - 1) {
                                    stop = true;
                                    break;
                                }
                            }
                            // Проверка того, есть ли под основным объектом инактивный
                            if (inactiveObject.haveObjects()) {
                                for (GameObject object : mainObject.getObjects()) {
                                    for (GameObject obj : inactiveObject.getObjects()) {
                                        if (obj.getY() == object.getY() + 1 && obj.getX() == object.getX()) {
                                            stop = true;
                                            break;
                                        }
                                    }
                                }
                            }

                            // Логика остановки основного объекта
                            if (stop) {
                                for (GameObject object : mainObject.getObjects()) {
                                    inactiveObject.registerObject(object);
                                }
                                mainObject.clear();
                            // Продолжение полёта
                            } else {
                                for (GameObject object : mainObject.getObjects()) {
                                    object.setY(object.getY() + 1);
                                }
                            }
                        }
                        Renderer.render(gameFrame);
                    }
                });

                gameFrame.registerKeyboardEvent(new KeyboardEvent(gameFrame, 'a') {
                    @Override
                    public void handleEvent() {
                        if (mainObject.haveObjects()) {
                            // Не упирается ли в стену
                            for (GameObject object : mainObject.getObjects()) {
                                if (object.getX() == 1) return;
                            }

                            // Нет ли рядом с основным объектом инактивных
                            for (GameObject object : mainObject.getObjects()) {
                                for (GameObject obj : inactiveObject.getObjects()) {
                                    if (object.getX() == obj.getX() + 1 || object.getX() == obj.getX() - 1) {
                                        if (object.getY() == obj.getY()) return;
                                    }
                                }
                            }

                            for (GameObject object : mainObject.getObjects()) {
                                object.setX(object.getX() - 1);
                            }
                        }
                        Renderer.render(gameFrame);
                    }
                });
                gameFrame.registerKeyboardEvent(new KeyboardEvent(gameFrame, 'd') {
                    @Override
                    public void handleEvent() {
                        if (mainObject.haveObjects()) {
                            // Не упирается ли в стену
                            for (GameObject object : mainObject.getObjects()) {
                                if (object.getX() == gameFrame.getMaxX() - 1) return;
                            }

                            // Нет ли рядом с основным объектом инактивных
                            for (GameObject object : mainObject.getObjects()) {
                                for (GameObject obj : inactiveObject.getObjects()) {
                                    if (object.getX() == obj.getX() + 1 || object.getX() == obj.getX() - 1) {
                                        if (object.getY() == obj.getY()) return;
                                    }
                                }
                            }

                            for (GameObject object : mainObject.getObjects()) {
                                object.setX(object.getX() + 1);
                            }
                        }
                        Renderer.render(gameFrame);
                    }
                });
                gameFrame.registerKeyboardEvent(new KeyboardEvent(gameFrame, 's') {
                    @Override
                    public void handleEvent() {
                        if (mainObject.haveObjects()) {
                            // Не упирается ли в стену
                            for (GameObject object : mainObject.getObjects()) {
                                if (object.getY() == gameFrame.getMaxY() - 1) return;
                            }

                            // Нет ли под основным объектом инактивных
                            for (GameObject object : mainObject.getObjects()) {
                                for (GameObject obj : inactiveObject.getObjects()) {
                                    if (object.getY() == obj.getY() - 1 && object.getX() == obj.getX()) return;
                                }
                            }

                            for (GameObject object : mainObject.getObjects()) {
                                object.setY(object.getY() + 1);
                            }
                        }
                        Renderer.render(gameFrame);
                    }
                });
            }
        });
    }
}
