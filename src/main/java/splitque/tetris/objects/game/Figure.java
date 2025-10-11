package splitque.tetris.objects.game;

import splitque.tetris.objects.GameObject;

import java.util.Random;

public class Figure extends GameObject {
    private final Random rand = new Random();

    public Figure(int x, int y) {
        int i = rand.nextInt(16);

        switch(i) {
            case 0: {
                registerComponent();
            }
        }
    }
}
