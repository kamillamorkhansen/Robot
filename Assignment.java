class Assignment extends Statement {

    private Identifier identifier;
    private String operation;

    public Assignment (Identifier identifier, String operation) {
        this.identifier = identifier;
        this.operation = operation;
    }

    public void interpret() { 
        for (Binding binding: r.bindings) {
            if (binding.getIdentifier().getName().equals(identifier.getName())) {
                switch(operation) {
                case "++":
                    binding.getExpression().increase();
                    break;
                case "--":
                    binding.getExpression().decrease();
                    break;
                }
            }
        }
    }
}