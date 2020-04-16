import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumLoss function below.
    static int minimumLoss(long[] price) {
        int nYears  = price.length;
        Long[] prices = new Long[nYears];
        List<Long> originalYears = new ArrayList<>();

        for(int i = 0; i < nYears; i++) {
            prices[i] = price[i];
            originalYears.add(prices[i]);
        }

        Arrays.sort(prices, Collections.reverseOrder());

        int minLoss = Integer.MAX_VALUE;
        for(int i = 0; i < nYears; i++) {
            if(i+1 >= nYears) {
                break;
            }
            long tmp = prices[i] - prices[i+1];
            if(tmp < minLoss) {
                if(originalYears.indexOf(prices[i]) < originalYears.indexOf(prices[i+1])) {
                    minLoss = (int)tmp;
                }
            }
        }

        return minLoss;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] price = new long[n];

        String[] priceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long priceItem = Long.parseLong(priceItems[i]);
            price[i] = priceItem;
        }

        int result = minimumLoss(price);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
