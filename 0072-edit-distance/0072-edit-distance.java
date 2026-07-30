class Solution {

    private int recursive(int i, int j, String s, String t){
        if(i == 0){
            return j+1;
        }

        if(j == 0){
            return i+1;
        }

        if(s.charAt(i) == t.charAt(j)){
            return recursive(i-1, j-1, s, t);
        }

        return 1 + Math.min(
                recursive(i-1, j, s, t),
                Math.min(
                        recursive(i, j-1, s, t),
                        recursive(i-1, j-1, s, t)
                )
        );
    }

    private int memoization(int i, int j, String s, String t, int[][] dp){

        if(i == 0){
            return j;
        }

        if(j == 0){
            return i;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s.charAt(i-1) == t.charAt(j-1)){
            return dp[i][j] = memoization(i-1, j-1, s, t, dp);
        }

        int insert = memoization(i, j-1, s, t, dp);
        int delete = memoization(i-1, j, s, t, dp);
        int replace = memoization(i-1, j-1, s, t, dp);

        return dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
    }

    private int tabulation(String word1, String word2){

        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i = 0; i <= n; i++){
            dp[i][0] = i;
        }

        for(int j = 0; j <= m; j++){
            dp[0][j] = j;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){

                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{

                    int insert = dp[i][j-1];
                    int delete = dp[i-1][j];
                    int replace = dp[i-1][j-1];

                    dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[n][m];
    }

    private int ultimateSpaceOptimization(String word1, String word2){

        int n = word1.length();
        int m = word2.length();

        int[] prev = new int[m+1];

        for(int j = 0; j <= m; j++){
            prev[j] = j;
        }

        for(int i = 1; i <= n; i++){

            int[] curr = new int[m+1];
            curr[0] = i;

            for(int j = 1; j <= m; j++){

                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    curr[j] = prev[j-1];
                }else{

                    int insert = curr[j-1];
                    int delete = prev[j];
                    int replace = prev[j-1];

                    curr[j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }

            prev = curr;
        }

        return prev[m];
    }

    public int minDistance(String word1, String word2){

        return ultimateSpaceOptimization(word1, word2);
    }
}