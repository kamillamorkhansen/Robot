public class Stop extends Statement {

    @Override
    public void interpret() {
        System.out.println("Robot stopped!\n");
        return;
    }
}
