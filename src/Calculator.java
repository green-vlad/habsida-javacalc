import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        
        System.out.println("Hello, I am Calculator.");
        System.out.println("Type stop if you wanna quit. Operations + - * /");
        System.out.println("Please type what you wanna calculate.");

        String input;
        Parser parser;
        Processor proc;
        while (true) {
            input = userInput.next();
            parser = new Parser(input);
            if (input.equals("stop")) {
                break;
            }
            try {
                parser.doParse();
                proc = new Processor(parser);
                System.out.println(proc.getResult()); 
            } catch (NumberTooBigException e) {
                System.out.println(e.getMessage());
                break;
            } catch (NumberTooSmallException e) {
                System.out.println(e.getMessage());
                break;
            } catch (WrongInputException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
        userInput.close();
    }
}
