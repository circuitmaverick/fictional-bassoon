public class evenodd {
    public static void main(String[] args) {
        int even = 0, odd = 0;
        for(int i=0; i<args.length; i++) {
            int n = Integer.parseInt(args[i]);
            if(n%2 == 0) even++;
            else odd++;
        }
        System.out.println("Evens: "+even);
        System.out.println("Odds: "+odd);
    }
}
