package sparse;

/** class Matrix , used to initialize the values and have getters for that */
public class Matrix {
    private int row;
    private int col;
    private int value;

    public Matrix(int row, int col, int value){
        this.row = row;
        this.col = col;
        this.value = value;
    }

    // getters of this class
    public int getRow(){
        return row;
    }
    public int getColumn(){
        return col;
    }
    public int getValue(){
        return value;
    }
}
