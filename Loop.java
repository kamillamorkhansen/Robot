import java.util.List;

class Loop extends Statement {

    private List<Statement> statements;
    private ArithmeticExp condition;

    public Loop (List<Statement> stmts, ArithmeticExp bool) {
        statements = stmts;
        condition = bool;
    }

    public void interpret() { 
        while (r.evaluate(condition) == 1) {
            for (Statement stmt : statements) {
                stmt.setRobot(r);
                stmt.interpret();

            }   
        }
    }
}