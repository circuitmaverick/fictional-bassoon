class NegativeNumberException extends Exception {
    public NegativeNumberException(String msg) { super(msg); }
}

class ProcessNumber {
    public static void checkNumber(int num) throws NegativeNumberException {
        if(num < 0) throw new NegativeNumberException(num+" is negative");
        else System.out.println(num*2);
    }
}

public class Driver {
    public static void main(String[] args) {
        try {
            ProcessNumber.checkNumber(4);
            ProcessNumber.checkNumber(-9);
        } catch(NegativeNumberException e) {
            System.out.println(e);
        }
    }
}