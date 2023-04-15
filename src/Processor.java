public class Processor {

    private Parser parser;

    public Processor(Parser parser) {
        this.parser = parser;
    }

    public double getResult() {
        double result;
        if (parser.getOperations().size() == 1) {
            result = this.calcTwo(parser.getNumbers().get(0), parser.getNumbers().get(1), parser.getOperations().get(0));
        } else {
            if (parser.getOperations().get(1) == '*' || parser.getOperations().get(1) == '/') {
                result = this.calcTwo(parser.getNumbers().get(1), parser.getNumbers().get(2), parser.getOperations().get(1));
                result = this.calcTwo(parser.getNumbers().get(0), result, parser.getOperations().get(0));
            } else {
                result = this.calcTwo(parser.getNumbers().get(0), parser.getNumbers().get(1), parser.getOperations().get(0));
                result = this.calcTwo(result, parser.getNumbers().get(2), parser.getOperations().get(1));
            }
        }
        return result;
    }

    private double calcTwo(double a, double b, Character operation) {
        switch (operation) {
            case '*': return multiply(a, b);
            case '/': return divide(a, b);
            case '+': return sum(a, b);
            default:  return substruct(a, b);
        }
    }
    
    private double divide(double a, double b) {
        return a / b;
    }

    private double multiply(double a, double b) {
        return a * b;
    }

    private double sum(double a, double b) {
        return a + b;
    }

    private double substruct(double a, double b) {
        return a - b;
    }
}
