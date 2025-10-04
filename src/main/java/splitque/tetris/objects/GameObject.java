package splitque.tetris.objects;

public class GameObject {
    private final Tag tag;
    private char character;
    private int x;
    private int y;

    public GameObject(Tag tag, char character, int x, int y) {
        this.tag = tag;
        this.character = character;
        this.x = x;
        this.y = y;
    }

    public Tag getTag() {
        return tag;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
