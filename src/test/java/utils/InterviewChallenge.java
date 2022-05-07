package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InterviewChallenge {
    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) throws InterruptedException {

    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        List<Integer> arrayOfDivides3 = new ArrayList<Integer>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 3 == 0) {
                arrayOfDivides3.add(A[i]);
            }
        }

        int max = Collections.max(arrayOfDivides3);

        return max;
    }
}


