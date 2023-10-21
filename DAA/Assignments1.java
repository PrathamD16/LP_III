public class Assignments1 {
    //Fibonacci using recursion
    static int fib_numR(int n){
        if(n <= 0)return 0;
        if(n == 1)return 1;
        return (fib_numR(n-1) + fib_numR(n-2));
    }

    static int fib_numI(int n){
        int a = 0, b = 1;
        int c = a + b;
        for(int i = 2; i <= n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
    public static void main(String[] args) {
        System.out.println(fib_numR(8)); 
        System.out.println(fib_numI(8));
    }
}
