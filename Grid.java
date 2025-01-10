public class Grid {

    private NumberExp len;
    private NumberExp wid;

    public Grid(NumberExp len, NumberExp wid) {
        this.len = len;
        this.wid = wid;
    }

    public int getLen() {
        return len.getNum();
    }

    public int getWid() {
        return wid.getNum();
    }

    public int getSize() {
        return len.getNum() * wid.getNum();
    }
}
