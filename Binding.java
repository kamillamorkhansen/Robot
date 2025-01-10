public class Binding {

    private Identifier identifier;
    private NumberExp expression;

    public Binding(Identifier identifier, NumberExp expression) {
        this.identifier = identifier;
        this.expression = expression;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public NumberExp getExpression() {
        return expression;
    }
}