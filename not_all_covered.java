import java.util.Scanner;

public class not_all_covered {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   
        int k = sc.nextInt();   
        int[] psum = new int[n+2]; 
        for (int i = 0; i < k; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            psum[l] += 1;
            psum[r+1] -= 1;
        }
        int mini = Integer.MAX_VALUE;
        for (int w = 1; w <= n; w++) {
            psum[w] += psum[w-1];
            mini = Math.min(mini, psum[w]);
        }
        System.out.println(mini);
        sc.close();
    }
}
