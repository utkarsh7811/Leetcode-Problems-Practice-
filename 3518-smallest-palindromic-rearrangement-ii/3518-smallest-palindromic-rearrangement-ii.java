class Solution {
    public String smallestPalindrome(String s, int kx) {
        int[] arr = new int[26];
        long k = kx;
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            arr[i] /= 2;
        }
        if (perm(arr, kx) < kx) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int ix = 0; ix < n / 2; ix++) {
            for (int i = 0; i < 26; i++) {
                if (arr[i] == 0) continue;

                arr[i]--;
                long per = perm(arr, k);
                if (per >= k) {
                    sb.append((char) ('a' + i));
                    break;
                } else {
                    k -= per;
                    arr[i]++;
                }
            }
        }
        return (n % 2 == 0)
            ? sb.toString() + sb.reverse().toString()
            : sb.toString() + s.charAt(n / 2) + sb.reverse().toString();
    }
    public long nCr(int n, int r, long lim) {
        long res = 1;
        r = Math.min(r, n - r);
        for (int i = 1; i <= r; i++) {
            res *= (n - i + 1);
            res /= i;
            if (res > lim) return lim + 1;
        }
        return res;
    }
    public long perm(int[] arr, long lim) {
        int total = 0;
        for (int i : arr) total += i;
        long res = 1;
        for (int i = 0; i < 26; i++) {
            long choices = nCr(total, arr[i], lim);
            if (choices == lim + 1) return lim + 1;

            res *= choices;
            if (res > lim) return lim;

            total -= arr[i];
        }
        return res;
    }
}