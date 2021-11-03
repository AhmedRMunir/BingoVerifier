class Answer_string {
    public static void main(String[] args) {
        // ///////////////////////////////////////////////////////////////////
        //                         5x5 Bingo Card
        // //////////////////////////////////////////////////////////////////

        // Given Bingo Card
        String[] bingoCard_5 = new String[]
            {"8", "29", "35", "54", "65",
            "13", "24", "44", "48", "67",
            "9", "21", "Free", "59", "63",
            "7", "19", "34", "53", "61",
            "1", "20", "33", "46", "72"};

        // Drawn Numbers
        
        // Should result in a win due to top left to bottom right diagonal
        String[] drawnNumbers5_0 = new String[]{"8", "24", "53", "72"};
        
        // Should result in a loss due to no matches
        String[] drawnNumbers5_1 = new String[] {"1", "33", "53", "65", "29", "75"};
        
        // Should result in a win due to bottom left to top right diagonal
        String[] drawnNumbers5_2 = new String[]{"1", "19", "48", "65"};

        boolean result5_0 = checkForBingo(bingoCard_5, drawnNumbers5_0);
        boolean result5_1 = checkForBingo(bingoCard_5, drawnNumbers5_1);
        boolean result5_2 = checkForBingo(bingoCard_5, drawnNumbers5_2);
        
        System.out.println("Results for the 5x5 Bingo Card Tests:");
        System.out.println();
        System.out.println("Top left to bottom right diagonal: " + result5_0);
        System.out.println("No matching happens: " + result5_1);
        System.out.println("Bottom left to Top right diagonal: " + result5_2);
        System.out.println();
         
        // ////////////////////////////////////////////////////////////////
        //                   3x3 Bingo Card
        // ////////////////////////////////////////////////////////////////

        // Given Bingo Card
        String[] bingoCard_3 = new String[]
            {"8", "29", "35",
            "13", "Free", "44",
            "9", "21", "24"};

        // Drawn Numbers

        // Should result in a win due to top left to bottom right diagonal
        String[] drawnNumbers3_0 = new String[]{"8", "24"};
        
        // Should result in a loss due to no matches
        String[] drawnNumbers3_1 = new String[] {"29", "35", "24", "13"};
        
        // Should result in a win due to bottom left to top right diagonal
        String[] drawnNumbers3_2 = new String[]{"9", "35"};

        boolean result3_0 = checkForBingo(bingoCard_3, drawnNumbers3_0);
        boolean result3_1 = checkForBingo(bingoCard_3, drawnNumbers3_1);
        boolean result3_2 = checkForBingo(bingoCard_3, drawnNumbers3_2);

        System.out.println("Results for the 5x5 Bingo Card Tests:");
        System.out.println();
        System.out.println("Top left to bottom right diagonal: " + result3_0);
        System.out.println("No matching happens: " + result3_1);
        System.out.println("Bottom left to Top right diagonal: " + result3_2);
        System.out.println();
    }

    public static boolean checkForBingo(String[] bingoCard, String[]drawnNumbers) {
        int size = (int)Math.sqrt(bingoCard.length);
        int[] rows = new int[size];
        int[] cols = new int[size];
        int[] diags = new int[2];

        for (int i = 0; i < bingoCard.length; i++) {
            int row = (int) Math.floor(i/size);
            int col = i % size;

            if (containsString(drawnNumbers, bingoCard[i]) || bingoCard[i] == "Free") {
                rows[row] += 1;
                cols[col] += 1;

                if (row == col) {
                    diags[0] += 1;
                }

                if (row + col == size - 1) {
                    diags[1] += 1;
                }
            }
        }

        return containsNum(rows, size) || containsNum(cols, size) || containsNum(diags, size);      
    }

    private static boolean containsString(String[] drawnNumbers, String num) {
        for (int i = 0; i < drawnNumbers.length; i++) {
            if (drawnNumbers[i] == num) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsNum(int[] drawnNumbers, int num) {
        for (int i = 0; i < drawnNumbers.length; i++) {
            if (drawnNumbers[i] == num) {
                return true;
            }
        }
        return false;
    }
    
}