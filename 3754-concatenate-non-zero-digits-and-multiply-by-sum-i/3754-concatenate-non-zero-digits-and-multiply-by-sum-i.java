class Solution {
    public long sumAndMultiply(int n) {
        long total = 0;
        long x = 0;

        while (n > 0) {
            int digit = n % 10;
            total += digit;

            if (digit != 0) {
                x = x * 10 + digit;
            }

            n /= 10;
        }

        return reverse(x) * total;
    }

    private long reverse(long n) {
        long result = 0;

        while (n > 0) {
            result = result * 10 + (n % 10);
            n /= 10;
        }

        return result;
    }
}