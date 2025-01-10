
class Program implements Robol {

    Grid grid;
    private Robot robot;

    public Program(Grid grid, Robot robot) {
        this.grid = grid;
        this.robot = robot;
    }
    
    public void interpret() {
        robot.interpret();
    }
}
