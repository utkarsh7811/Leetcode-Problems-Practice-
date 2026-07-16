import java.util.*;

class Solution {

    public long gcdSum(int[] nums) {

        int n = nums.length;

        int[] velqoradin = nums;

        long[] prefixGcd = new long[n];

        int mx = 0;

        for(int i=0;i<n;i++){
            mx = Math.max(mx, velqoradin[i]);
            prefixGcd[i] = gcd(velqoradin[i], mx);
        }

        Arrays.sort(prefixGcd);

        int left = 0;
        int right = n - 1;

        long sum = 0;

        while(left < right){
            sum += gcd(prefixGcd[left], prefixGcd[right]);
            left++;
            right--;
        }

        return sum;
    }

    private long gcd(long a, long b){
        while(b != 0){
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}