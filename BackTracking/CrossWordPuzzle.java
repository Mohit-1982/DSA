public class CrossWord {
    public static void main(String[] args) {
        char[][] grid = {
                {'+','-','-','-','-','-','-','+','+','+'},
                {'+','-','-','-','-','-','+','+','+','+'},
                {'+','+','+','-','+','+','+','+','+','+'},
                {'+','+','+','-','+','+','+','+','+','+'},
                {'+','+','+','-','-','-','-','-','+','+'},
                {'+','+','+','-','+','+','-','+','+','+'},
                {'+','+','+','+','+','+','-','+','+','+'},
                {'+','+','+','+','+','+','-','+','+','+'},
                {'+','+','+','+','+','+','-','+','+','+'},
                {'+','+','+','+','+','+','+','+','+','+'}
        };
        String[] words = {"LHASA","SPAIN","INDIA","POLAND"};
        crossWord(grid,words,0);
    }
    static void crossWord(char[][] grid,String[] words,int idx) {
        if(idx == words.length) {
            print(grid);
            System.out.println();
            return;
        }
        String word = words[idx];
        for(int i = 0;i < grid.length;i++) {
            for(int j = 0;j < grid[0].length;j++) {
                //check that we can place the word horizontally or vertically
                if(canWePlaceHorizontally(grid,word,i,j)) {
                    boolean[] wePlaced = placeHorizontally(grid,word,i,j);
                    crossWord(grid,words,idx + 1);
                    removeHorizontally(grid,wePlaced,i,j);//backtracking --> removing words we have placed
                }
                if(canWePlaceVertically(grid,word,i,j)) {
                    boolean[] wePlaced = placeVertically(grid,word,i,j);
                    crossWord(grid,words,idx + 1);
                    removeVertically(grid,wePlaced,i,j);//backtracking --> removing words we have placed
                }
            }
        }
    }
    static void removeHorizontally(char[][] grid,boolean[] wePlaced,int i,int j) {
        for(int col = 0;col < wePlaced.length;col++) {
            if(wePlaced[col]) {
                grid[i][j + col] = '-';
            }
        }
    }
    static void removeVertically(char[][] grid,boolean[] wePlaced,int i,int j) {
        for(int row = 0;row < wePlaced.length;row++) {
            if(wePlaced[row]) {
                grid[i + row][j] = '-';
            }
        }
    }
    static boolean[] placeHorizontally(char[][] grid,String word,int i,int j) {
        boolean[] wePlaced = new boolean[word.length()];
        for(int col = 0;col < word.length();col++) {
            if(grid[i][j + col] == '-') {
                grid[i][j + col] = word.charAt(col);
                wePlaced[col] = true;
            }
        }
        return wePlaced;
    }
    static boolean[] placeVertically(char[][] grid,String word,int i,int j) {
        boolean[] wePlaced = new boolean[word.length()];
        for(int row = 0;row < word.length();row++) {
            if(grid[i + row][j] == '-') {
                grid[i + row][j] = word.charAt(row);
                wePlaced[row] = true;
            }
        }
        return wePlaced;
    }
    static boolean canWePlaceHorizontally(char[][] grid,String word,int i,int j) {
        //boundary and valid word condition check
        if(j - 1 >= 0 && grid[i][j - 1] != '+') {
            return false;
        }
        else if(j + word.length() < grid[0].length && grid[i][j + word.length()] != '+') {
            return false;
        }
        for(int col = 0;col < word.length();col++) {
            if(j + col >= grid[0].length) {
                return false;
            }
            if(grid[i][j + col] == '-' || grid[i][j + col] == word.charAt(col)) {
                continue;
            }else {
                return false;
            }
        }
        return true;
    }
    static boolean canWePlaceVertically(char[][] grid,String word,int i,int j) {
        //boundary and valid word condition check
        if(i - 1 >= 0 && grid[i - 1][j] != '+') {
            return false;
        }
        else if(i + word.length() < grid.length && grid[i + word.length()][j] != '+') {
            return false;
        }
        for(int row = 0;row < word.length();row++) {
            if(i + row >= grid.length) {
                return false;
            }
            if(grid[i + row][j] == '-' || grid[i + row][j] == word.charAt(row)) {
                continue;
            }else {
                return false;
            }
        }
        return true;
    }
    static void print(char[][] grid) {
        for(int i = 0;i < grid.length;i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
