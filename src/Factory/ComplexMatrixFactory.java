package Factory;

import Model.ComplexMatrix;
import Model.ComplexNumber;

public interface ComplexMatrixFactory {

     ComplexNumber empty = new ComplexNumber(0,0);
     ComplexNumber unitary = new ComplexNumber(1,0);

    static ComplexMatrix emptyBuild(int row , int col){
        ComplexNumber [][] matrix = new ComplexNumber[row][col] ;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j]=empty.clone();
            }
        }
        return new ComplexMatrix(matrix);
    }
    static ComplexMatrix identityBuild (int dim){
        ComplexNumber [][] matrix = new ComplexNumber[dim][dim] ;

        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (i==j) matrix[i][j]=unitary.clone();
                else matrix[i][j]=empty.clone();
            }
        }
        return new ComplexMatrix(matrix);
    }


}
