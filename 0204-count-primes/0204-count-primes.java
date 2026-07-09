class Solution {
    public int countPrimes(int n) {

        if(n<=2) return 0;

        boolean[] flag = new boolean[n];

        for(int i=2; i<n; i++){
            flag[i] = true;
        }

        for(int i=2; i*i<n; i++){
            if(flag[i]){
                for(int j=i*i; j<n; j+=i){
                    flag[j] = false;
                }
            }
        }

        int count=0;

        for(int i=2; i<n; i++){
            if(flag[i]){
                count++;
            }
        }  
        return count;
    }
}