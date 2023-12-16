import java.util.Scanner;

public class SalesmanDays {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Input for the number of towns (N)
        int num = in.nextInt();

        // Input for the maximum number of times each town can be chosen
        int[] countTown = new int[num];
        for (int idx = 0; idx < num; idx++) {
            countTown[idx] = in.nextInt();
        }

        // Calculate and print the maximum number of days
        int result = maxDays(num, countTown);
        System.out.println(result);
    }

    // Function to calculate the maximum number of days
    private static int maxDays(int num, int[] countTown) {
        int answer = 0;

        // Iterate through the towns
        for (int idx = 0; idx < num; idx++) {
            // Check if the town can be chosen more than zero times
            if (countTown[idx] > 0) {
                // Choose the town and update the count
                answer++;
                countTown[idx]--;

                // Check if the next town is different
                if (idx + 1 < num && countTown[idx + 1] > 0) {
                    // Choose the next town and update the count
                    answer++;
                    countTown[idx + 1]--;
                }
            }
        }

        return answer;
    }
}