package test;

public class FizzBuzz {
    public static void main(String[] args) {

        for (int i = 1; i <= 101; i++) {
//            System.out.println(i);
            if (i % 15 == 0) {
                System.out.println("FizzBuzz " + i);
            } else if (i % 3 == 0) {
                System.out.println("Fizz " + i);
            } else if (i % 5 == 0) {
                System.out.println("Buzz " + i);
            }
        }


//        String s = "" + i;
//        if ((i % 3) == 0) {
//            s += " Fizz";
//        }
//        if ((i % 5) == 0) {
//            s+= " Buzz";
//        }
//        System.out.println(s);
//        This code snippet placed in a loop will print Fizz, Buzz and Fizz Buzz on i divisible by 3, 5 and 15 respectively.
    }
}
