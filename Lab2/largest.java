public class largest {
    public static void main(String[] args) {
        int max = Integer.parseInt(args[0]);
        for(int i=0; i<args.length; i++){
            int n = Integer.parseInt(args[i]);
            if(n > max) max = n;
        }
        System.out.println(max);
    }
}
