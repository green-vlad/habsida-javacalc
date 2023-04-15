import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private String               expression;
    private ArrayList<Integer>   numbers;
    private ArrayList<Character> operations;

    public Parser(String expression)
    {
        this.expression = expression;
        this.numbers    = new ArrayList<>();
        this.operations = new ArrayList<>();
    }

    public void doParse() throws NumberTooBigException, WrongInputException, NumberTooSmallException
    {
        Pattern pattern = Pattern.compile("((\\d+)([\\+\\-\\\\*\\/])(\\d+))||((\\d+)([\\+\\-\\\\*\\/])(\\d+)([\\+\\-\\\\*\\/])(\\d+))");
        Matcher matches = pattern.matcher(this.expression);
        if (matches.matches()) {
            if (matches.group(1) != null) {
                this.numbers.add(Integer.parseInt(matches.group(2)));
                this.numbers.add(Integer.parseInt(matches.group(4)));
                if (this.numbers.get(0) > 10 || this.numbers.get(1) > 10) {
                    throw new NumberTooBigException();
                } else if (this.numbers.get(0) < 1 || this.numbers.get(1) < 1) {
                    throw new NumberTooSmallException();
                }
                this.operations.add(matches.group(3).charAt(0));
            }
            if (matches.group(5) != null) {
                this.numbers.add(Integer.parseInt(matches.group(6)));
                this.numbers.add(Integer.parseInt(matches.group(8)));
                this.numbers.add(Integer.parseInt(matches.group(10)));
                if (this.numbers.get(0) > 10 || this.numbers.get(1) > 10 || this.numbers.get(2) > 10) {
                    throw new NumberTooBigException();
                } else if (this.numbers.get(0) < 1 || this.numbers.get(1) < 1) {
                    throw new NumberTooSmallException();
                }
                this.operations.add(matches.group(7).charAt(0));
                this.operations.add(matches.group(9).charAt(0));
            }
        } else {
            throw new WrongInputException();
        }
    }

    public ArrayList<Integer> getNumbers() {
        return this.numbers;
    }

    public ArrayList<Character> getOperations() {
        return this.operations;
    }
}
