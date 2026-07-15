class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); result = result * 26 + (columnTitle.charAt(i) - 'A' + 1), i++);
        return result; 
    }
}