class Spreadsheet {
    int[][] sheet;
    public Spreadsheet(int rows) {
        sheet = new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        sheet[Integer.parseInt(cell.substring(1)) - 1][cell.charAt(0) - 'A'] = value;
    }
    
    public void resetCell(String cell) {
        sheet[Integer.parseInt(cell.substring(1)) - 1][cell.charAt(0) - 'A'] = 0;
    }
    
    public int getValue(String formula) {
        String[] values = formula.split("\\+");

        String first = values[0].substring(1);
        String second = values[1];

        if(Character.isLetter(first.charAt(0)) && Character.isLetter(second.charAt(0))){
            int f = sheet[Integer.parseInt(first.substring(1)) - 1][first.charAt(0) - 'A'];
            int s = sheet[Integer.parseInt(second.substring(1)) - 1][second.charAt(0) - 'A'];

            return f + s;
        }
        else if(Character.isLetter(first.charAt(0))){
            int f = sheet[Integer.parseInt(first.substring(1)) - 1][first.charAt(0) - 'A'];
            
            return f + Integer.parseInt(second);
        }
        else if(Character.isLetter(second.charAt(0))){
            int s = sheet[Integer.parseInt(second.substring(1)) - 1][second.charAt(0) - 'A'];

            return s + Integer.parseInt(first);
        }
        else{
            return Integer.parseInt(first) + Integer.parseInt(second);
        }
    }

}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */