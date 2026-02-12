class ArgsLengthException extends Exception {
    public ArgsLengthException(String msg) { super(msg); }
}

class CheckArgs {
    public void check(String[] args) throws ArgsLengthException {
        if(args.length < 4) throw new ArgsLengthException("Arguments are less than 4");
        else {
            int sum=0;
            for(String arg: args) {
                sum+=(Integer.parseInt(arg)*Integer.parseInt(arg));
            }
            System.out.println(sum);
        }
    }
}

public class Driver {
    public static void main(String[] args) {
        CheckArgs c = new CheckArgs();
        try {
            c.check(args);
        } catch(ArgsLengthException e) {
            System.out.println(e);
        }
    }
}
