package jediGalaxy;

public class Field {
    private int[][] matrix;



    public Field(int rows, int cols, int beginValue){
        this.matrix=new int[rows][cols];
        this.fillValues(beginValue);
    }

    public Field(int rows, int cols) {
        this(rows,cols,0);
    }

    private void fillValues(int beginValue){
        for (int rows = 0; rows <this.matrix.length; rows++) {
            for (int cols = 0; cols < this.matrix[rows].length; cols++) {
               this.matrix[rows][cols] = beginValue++;
            }
        }
    }
    public boolean isInBounds(int row, int col) {
        return row >= 0 && col >= 0 && row < this.matrix.length && col < this.matrix[row].length;
    }

    public void setValue(int row,int col,int newValue){
        this.matrix[row][col]=newValue;
    }

    public int getValue(int r,int c){
        return matrix[r][c];
    }

    public int getCOlLength(int row){
return this.matrix[row].length;
    }

}
