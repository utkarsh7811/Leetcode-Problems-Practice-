class Solution {
    public boolean isValidSudoku(char[][] board) {
        //M1: HashSet-based duplicate tracking or Hashset-based

        // 9 sets for rows
        HashSet<Character>[] rows = new HashSet[9];

        // 9 sets for columns
        HashSet<Character>[] cols = new HashSet[9];

        // 9 sets for boxes
        HashSet<Character>[] box = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            box[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];

                if (ch == '.')
                    continue;

                int box_no = (i / 3) * 3 + (j / 3);

                if (rows[i].contains(ch) || cols[j].contains(ch) || box[box_no].contains(ch)) {
                    return false;
                }

                rows[i].add(ch);
                cols[j].add(ch);
                box[box_no].add(ch);
            }
        }

        return true;
    }
}