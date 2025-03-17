package sparse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/** class SparseMatrixTest, used to create test cases */
public class SparseMatrixTest {
    

    @Test
    public void transposeTest() {
        SparseMatrix input = new SparseMatrix(3,3,Arrays.asList(new Matrix(0,1,2), new Matrix(1,0,2)));
        SparseMatrix transposed = input.transpose();
        List<Matrix> expected = Arrays.asList(new Matrix(1,0,2), new Matrix(0,1,2));

        assertEquals(expected.size(), transposed.nonZeroElementsList.size());

    }
    @Test
    public void isSymmetricTest1(){
        List<Matrix> elements = Arrays.asList(new Matrix(0,1,5),
        new Matrix(1,2,8),
        new Matrix(2,0,3));
        SparseMatrix matrix = new SparseMatrix(3,3,elements);
        assertFalse(matrix.isSymmetric());
    }

    @Test
    public void testAdditionOfMatrix(){
        List<Matrix> elements1 = Arrays.asList(new Matrix(0,1,5),
        new Matrix(1,2,8));
        List<Matrix> elements2 = Arrays.asList(new Matrix(0,1,3),
        new Matrix(1,2,8),
        new Matrix(2,0,2));

        SparseMatrix matrix1 = new SparseMatrix(3,3,elements1);
        SparseMatrix matrix2 = new SparseMatrix(3,3,elements2);
        SparseMatrix result = matrix1.addMatrix(matrix2);

        result.printMatrix();

        assertEquals(8, getValueAt(result,0,1));
        assertEquals(16, getValueAt(result,1,2));
        assertEquals(2, getValueAt(result,2,0));
    }
    @Test
    public void testMultiplicationOfMatrix(){
        List<Matrix> elements1 = Arrays.asList(new Matrix(0,1,5),
        new Matrix(1,2,8));
        List<Matrix> elements2 = Arrays.asList(new Matrix(0,1,3),
        new Matrix(1,2,8),
        new Matrix(2,0,2));

        SparseMatrix matrix1 = new SparseMatrix(3,3,elements1);
        SparseMatrix matrix2 = new SparseMatrix(3,3,elements2);
        SparseMatrix result = matrix1.multiplyMatrix(matrix2);

        result.printMatrix();

        assertEquals(40, getValueAt(result,0,2));
        assertEquals(16, getValueAt(result,1,0));
        assertEquals(0, getValueAt(result,0,1));
    }


    private int getValueAt(SparseMatrix matrix, int row, int col){
        for(Matrix m : matrix.nonZeroElementsList){
            if(m.getRow() == row && m.getColumn() == col){
                return m.getValue();
            }
        }
        return 0;
    }

}
