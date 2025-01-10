public class Log extends Statement {
    private String message;

    public Log(String message) {
        this.message = message;
    }

    public void interpret() {
        System.out.println(message);
    }
}
