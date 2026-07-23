class Solution {
    public int nextNumber(int n){
        int sum=0;
        while(n>0){
            int lastDigit=n%10; 
            sum+=lastDigit*lastDigit; 
            n=n/10; 
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int slow=n;
        int fast=n;

        do{
        slow=nextNumber(slow);  
        fast=nextNumber(nextNumber(fast)); 
        }while(slow!=fast);
        return fast==1;
    }
}