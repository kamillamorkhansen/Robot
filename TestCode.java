import java.util.ArrayList;

class TestCode {

    void runProgram1() {
        
        ArrayList<Statement> statements = new ArrayList<>();
        
        System.out.println("\nPROGRAM 1\n");
        Grid grid = new Grid(new NumberExp(64), new NumberExp(64));
        Start start = new Start(new NumberExp(23), new NumberExp(30));
        statements.add(new Turn(Direction.clockwise));
        statements.add(new Turn(Direction.clockwise));
        statements.add(new Step(new NumberExp(15)));
        statements.add(new Turn(Direction.counterclockwise));
        statements.add(new Step(new NumberExp(15)));
        statements.add(new Turn(Direction.counterclockwise));
        statements.add(new Step(new ArithmeticExp(BinaryOp.addition, new NumberExp(2), new NumberExp(3))));
        statements.add(new Turn(Direction.counterclockwise));
        statements.add(new Step(new ArithmeticExp(BinaryOp.addition, new NumberExp(17), new NumberExp(20))));
        statements.add(new Stop());
        
        Robot robot = new Robot(start);
        robot.statements = statements;
        robot.grid = grid;
        Program program = new Program(grid,robot);
        
        program.interpret();
        
        robot.printPosision();
    }

    void runProgram2() {

        ArrayList<Statement> statements = new ArrayList<>();
        ArrayList<Binding> bindings = new ArrayList<>();

        System.out.println("\nPROGRAM 2\n");
        Grid grid = new Grid(new NumberExp(64), new NumberExp(64));
        Start start = new Start(new NumberExp(23), new NumberExp(6));
        Identifier i = new Identifier("i");
        Identifier j = new Identifier("j");
      
        bindings.add(new Binding(i, new NumberExp(5)));
        bindings.add(new Binding(j, new NumberExp(3)));

        statements.add(new Turn(Direction.counterclockwise));
        statements.add(new Step(new ArithmeticExp(BinaryOp.multiplication, new NumberExp(3), i)));
        statements.add(new Turn(Direction.clockwise));
        statements.add(new Step(new NumberExp(15)));
        statements.add(new Turn(Direction.clockwise));
        statements.add(new Step(new ArithmeticExp(BinaryOp.substraction, new ArithmeticExp(BinaryOp.substraction, new NumberExp(12), i), j)));
        statements.add(new Turn(Direction.clockwise));
        statements.add(new Step(new ArithmeticExp(BinaryOp.addition, new ArithmeticExp(BinaryOp.addition, new ArithmeticExp(BinaryOp.multiplication, new NumberExp(2), i), new ArithmeticExp(BinaryOp.multiplication, new NumberExp(3), j)), new NumberExp(1))));
        statements.add(new Stop());

        Robot robot = new Robot(start);
        robot.statements = statements;
        robot.bindings = bindings;
        robot.grid = grid;
        Program program = new Program(grid,robot);
        
        program.interpret();
        
        robot.printPosision();
    }

    void runProgram3() {

        ArrayList<Statement> statements = new ArrayList<>();
        ArrayList<Binding> bindings = new ArrayList<>();
        ArrayList<Statement> whilebody = new ArrayList<>();

        System.out.println("\nPROGRAM 3\n");
        Grid grid = new Grid(new NumberExp(64), new NumberExp(64));
        Start start = new Start(new NumberExp(23), new NumberExp(6));

        Identifier i = new Identifier("i");
        Identifier j = new Identifier("j");
        bindings.add(new Binding(i, new NumberExp(5)));
        bindings.add(new Binding(j, new NumberExp(3)));

        statements.add(new Turn(Direction.counterclockwise));
        statements.add(new Step(new ArithmeticExp(BinaryOp.multiplication, new NumberExp(3), i)));
        statements.add(new Turn(Direction.counterclockwise));
        statements.add(new Step(new NumberExp(15)));
        statements.add(new Turn(Direction.clockwise));
        statements.add(new Turn(Direction.clockwise));
        statements.add(new Step(new NumberExp(4)));
        statements.add(new Turn(Direction.clockwise));

        whilebody.add(new Step(j));
        whilebody.add(new Assignment(j, "--"));
        statements.add(new Loop(whilebody, new ArithmeticExp(BinaryOp.greater, j, new NumberExp(1))));

        statements.add(new Stop());

        Robot robot = new Robot(start);
        robot.statements = statements;
        robot.bindings = bindings;
        robot.grid = grid;
        Program program = new Program(grid,robot);
        
        program.interpret();
        
        robot.printPosision();
    }

    void runProgram4() {

        ArrayList<Statement> statements = new ArrayList<>();
        ArrayList<Binding> bindings = new ArrayList<>();
        ArrayList<Statement> whilebody = new ArrayList<>();

        System.out.println("\nPROGRAM 4\n");
        Grid grid = new Grid(new NumberExp(64), new NumberExp(64));
        Start start = new Start(new NumberExp(1), new NumberExp(1));

        Identifier i = new Identifier("i");
        bindings.add(new Binding(i, new NumberExp(8)));

        whilebody.add(new Step(i));
        statements.add(new Loop(whilebody, new ArithmeticExp(BinaryOp.less, i, new NumberExp(10))));
        
        statements.add(new Stop());

        Robot robot = new Robot(start);
        robot.statements = statements;
        robot.bindings = bindings;
        robot.grid = grid;
        Program program = new Program(grid,robot);
        
        program.interpret();
    }

    void runProgram5() {

        ArrayList<Statement> statements = new ArrayList<>();
        ArrayList<Binding> bindings = new ArrayList<>();
        
        System.out.println("\nPROGRAM 5\n");
        Grid grid = new Grid(new NumberExp(64), new NumberExp(64));
        Start start = new Start(new NumberExp(23), new NumberExp(30));

        statements.add(new Turn(Direction.clockwise));
        statements.add(new Turn(Direction.clockwise));
        statements.add(new Step(new NumberExp(15)));
        statements.add(new Turn(Direction.counterclockwise));
        statements.add(new Step(new NumberExp(15)));
        statements.add(new ReportSteps());
        statements.add(new Stop());

        Robot robot = new Robot(start);
        robot.statements = statements;
        robot.bindings = bindings;
        robot.grid = grid;
        Program program = new Program(grid,robot);
        
        program.interpret();
        
        robot.printPosision();
    }

    void runProgram6() {

        ArrayList<Statement> statements = new ArrayList<>();
        ArrayList<Binding> bindings = new ArrayList<>();
    
        System.out.println("\nPROGRAM 6\n");
        Grid grid = new Grid(new NumberExp(64), new NumberExp(64));
        Start start = new Start(new NumberExp(23), new NumberExp(30));

        statements.add(new Log("Starting operation"));
        statements.add(new Step(new NumberExp(5)));
        statements.add(new Turn(Direction.clockwise));
        statements.add(new Log("Turned clockwise"));
        statements.add(new Step(new NumberExp(3)));
        statements.add(new Stop());

        Robot robot = new Robot(start);
        robot.statements = statements;
        robot.bindings = bindings;
        robot.grid = grid;
        Program program = new Program(grid,robot);
        
        program.interpret();
        
        robot.printPosision();
    }

    void runAll() {
        runProgram1();
        runProgram2();
        runProgram3();
        //runProgram4();
        runProgram5();
        runProgram6();
    }
}