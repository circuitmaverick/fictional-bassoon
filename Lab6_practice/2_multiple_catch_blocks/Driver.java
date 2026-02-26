class NegativeNumberException extends Exception {
    public NegativeNumberException(String msg) { super(msg); }
}

class ZeroNumberException extends Exception {
    public ZeroNumberException(String msg) { super(msg); }
}

class CheckNumber {
    public static void check(int num) throws NegativeNumberException, ZeroNumberException {
        if(num < 0) throw new NegativeNumberException("Entered number is negative");
        else if (num == 0) throw new ZeroNumberException("Entered number is zero");
        else System.out.println(num);
    }
}

public class Driver {
    public static void main(String[] args) {
        try {
            CheckNumber.check(0);
        } catch(NegativeNumberException e) {
            System.out.println(e);
        } catch(ZeroNumberException e) {
            System.out.println(e);
        }
    }
}
