public class NumberExp extends Expression {
    
    private int num;

    public NumberExp(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void increase() {
        num++;
    }

    public void decrease() {
        num--;
    }
}
