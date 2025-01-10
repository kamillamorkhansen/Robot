import java.util.ArrayList;

class Robot implements Robol {

    private Start start;
    ArrayList<Statement> statements;
    ArrayList<Binding> bindings = new ArrayList<>();
    Grid grid;
    private String direction = "east";
    private int x;
    private int y;
    private int totalsteps = 0;

    public Robot(Start start) {
        this.start = start;
        this.x = start.getX();
        this.y = start.getY();
        System.out.println("You're starting at: (" + start.getX() + " , " + start.getY() + ")");
        System.out.println("With direction " + direction.toUpperCase());
    } 

    public int getXpos() {
        return x;
    }

    public int getYpos() {
        return y;
    }

    public Grid getGrid() {
        return grid;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String dir) {
        this.direction = dir;
    }

    public void moveHorizontally(int steps) {
        x += steps;
        System.out.println("Robot is moving horizontally " + steps + " steps\n");
        System.out.println("Robot is now at (" + getXpos() + " , " + getYpos() + ")");
        totalsteps += Math.abs(steps);
    }

    public void moveVertically(int steps) {
        y += steps;
        System.out.println("Robot is moving vertically " + steps + " steps\n");
        System.out.println("Robot is now at (" + getXpos() + " , " + getYpos() + ")");
        totalsteps += Math.abs(steps);
    }

    public void printPosision() {
        System.out.println("Robots current position: (" + getXpos() + " , " + getYpos() + ")");
    } 

    public int getSteps() {
        return totalsteps;
    }

    public int evaluate(Expression exp) {
        
        if (exp instanceof NumberExp) {
            return ((NumberExp) exp).getNum();
        } else if (exp instanceof Identifier) {
            String name = ((Identifier) exp).getName();
            for (Binding binding: bindings) {
                if (binding.getIdentifier().getName().equals(name)) {
                    return evaluate(binding.getExpression());
                }
            }
        } else if (exp instanceof ArithmeticExp) {
            ArithmeticExp aexp = (ArithmeticExp) exp;
            int right = evaluate(aexp.getRight());
            int left = evaluate(aexp.getLeft());

            switch (aexp.getOp()) {
                case addition:                   
                    return left + right;
                case substraction:               
                    return left - right;
                case multiplication:               
                    return left * right;
                case greater:    
                    return left > right? 1:0;
                case less:           
                    return left < right? 1:0;
                case equal:
                    return left == right? 1:0;
            }
        }
        return 0;
    }


    public void interpret() {

        if (start.getX() > grid.getLen() && start.getY() > grid.getWid()) {
            System.out.println("Error: The start is outside the grid!");
            return;
        }

        for (Statement stmt : statements) {
            stmt.setRobot(this);
            if (stmt instanceof Turn) {
                Turn turn = (Turn)stmt;
                turn.interpret();
            }

            else if (stmt instanceof Step) {
                Step step = (Step)stmt;
                step.interpret();
            }

            else if (stmt instanceof Assignment) {
                Assignment asm = (Assignment) stmt;
                asm.interpret();
            }

            else if (stmt instanceof Stop) {
                Stop stop = (Stop) stmt;
                stop.interpret();
            }

            else if (stmt instanceof Loop) {
                Loop loop = (Loop) stmt;
                loop.interpret();
            }

            else if (stmt instanceof ReportSteps) {
                ReportSteps rs = (ReportSteps) stmt;
                rs.interpret();
            }

            else if (stmt instanceof Log) {
                Log log = (Log) stmt;
                log.interpret();
            }
        }
    }
}