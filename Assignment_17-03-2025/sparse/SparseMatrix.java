package sparse;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/** class SparseMatrix, have constructor to initialize the values and perform operations on matrix like,
 * transpose, addition, multiplication, check symmetric or not
 */
public final class SparseMatrix {
    private  final List<Matrix> nonZeroElementsList;
    private final int rows;
    private final int cols;

    public SparseMatrix(int rows, int cols, List<Matrix> nonZeroElementsList) {
        this.nonZeroElementsList = new ArrayList<>(nonZeroElementsList);
        this.rows = rows;
        this.cols = cols;
        Collections.sort(this.nonZeroElementsList, (a, b) -> Integer.compare(b.getRow(), a.getRow()));
    }

    /** Method transpose, used to transpose the matrix
     * and return the object of SparseMatrix having transpose matrix
     */
    public SparseMatrix transpose(){
        final List<Matrix> transpoedValues = new ArrayList<>();
        for( Matrix m : nonZeroElementsList){
            transpoedValues.add(new Matrix(m.getColumn(), m.getRow(), m.getValue()));
        }
        return new SparseMatrix(cols, rows, transpoedValues);
    }

    /** Method isSymmetric, used to check the matrix is symmetric or not
     * and return the boolean value
     */
    public boolean isSymmetric(){
        if( rows != cols){
            return false;
        }
        SparseMatrix transposed = this.transpose();
        return new HashSet<>(nonZeroElementsList).equals(new HashSet<>(transposed.nonZeroElementsList));
    }

    /** Method addMatrix, used to perform the matrix addition 
     * store the result in new Object of sparseMatrix class
     * @ param SparseMatrix class object named 'other'
     */
    public SparseMatrix addMatrix(SparseMatrix other){
        if(this.rows != other.rows || this.cols != other.cols){
            throw new AssertionError("Addition is not possible in this case");
        }
        
        final List<Matrix> additionResult = new ArrayList<>();
        Map<String, Integer> sum = new HashMap<>();
        for(Matrix m : this.nonZeroElementsList){
            sum.put(m.getRow() + "," + m.getColumn(), m.getValue());
        }
        for(Matrix m : other.nonZeroElementsList){
            sum.put(m.getRow() + "," + m.getColumn(),sum.getOrDefault(m.getRow() + "," + m.getColumn(), 0) + m.getValue());
        }
        for(Map.Entry<String, Integer> entry : sum.entrySet()){
            if(entry.getValue() != 0){
                String[] indices = entry.getKey().split(",");
                additionResult.add(new Matrix(Integer.parseInt(indices[0]), Integer.parseInt(indices[1]), entry.getValue()));
            }
        }

        return new SparseMatrix(rows, cols, additionResult);
    }

    public List<Matrix> getNonZeroElementsList(){
        return nonZeroElementsList;
    }

    /** Method multiplyMatrix, used to perform the matrix multiplication 
     * store the result in new Object of sparseMatrix class
     * @ param SparseMatrix class object named 'other'
     * 
     */
    public SparseMatrix multiplyMatrix(SparseMatrix other){
        if(this.cols != other.rows){
            throw new AssertionError("Multiplication is not possible");
        }
        final List<Matrix> multiplyResult = new ArrayList<>();
        Map<String, Integer> product = new HashMap<>();
        for(Matrix m : this.nonZeroElementsList){
            for(Matrix n : other.nonZeroElementsList){
                if(m.getColumn() == n.getRow()){
                    String key = m.getRow() + "," + n.getColumn();
                    product.put(key, product.getOrDefault(key, 0) + m.getValue() * n.getValue());
                }
            }
        }
        for(Map.Entry<String, Integer> entry : product.entrySet()){
            if(entry.getValue() != 0){
                String[] indices = entry.getKey().split(",");
                multiplyResult.add(new Matrix(Integer.parseInt(indices[0]), Integer.parseInt(indices[1]), entry.getValue()));
            }
        }
        return new SparseMatrix(rows, cols, multiplyResult);
    }

    /** Method printMatrix, used to print the matrix  */
    public void printMatrix(){
        int[][] matrixPrint = new int[rows][cols];
        for(Matrix m : nonZeroElementsList){
            matrixPrint[m.getRow()][m.getColumn()] = m.getValue();
        }
        for(int[] row : matrixPrint){
            System.out.println(Arrays.toString(row));
        }

    }

}
