public class Start {
    
    private int x;
    private int y;
    
    public Start(NumberExp x, NumberExp y) {
        this.x = x.getNum();
        this.y = y.getNum();
    } 

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}


