public class NumberTooBigException extends Exception
{
    public NumberTooBigException() {
        super("One of numbers is bigger than 10");
    }
}
