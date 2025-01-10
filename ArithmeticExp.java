
public class ArithmeticExp extends Expression {

    private BinaryOp op;
    private Expression left;
    private Expression right;
   
    public ArithmeticExp(BinaryOp op, Expression leftValue, Expression rightValue) {
        this.op = op;
        this.left = leftValue;
        this.right = rightValue;
    }

    public BinaryOp getOp() {
        return op;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }
}
