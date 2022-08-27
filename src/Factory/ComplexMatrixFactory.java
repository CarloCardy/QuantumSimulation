package Factory;

import Model.ComplexMatrix;
import Model.ComplexNumber;
import Model.Constant;

public interface ComplexMatrixFactory {

    static ComplexMatrix zeroMatrix(int row , int col){
        ComplexNumber [][] matrix = new ComplexNumber[row][col] ;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j]= Constant.empty.clone();
            }
        }
        return new ComplexMatrix(matrix);
    }
    static ComplexMatrix emptyMatrix(int row , int col){
        ComplexNumber [][] matrix = new ComplexNumber[row][col] ;
        return new ComplexMatrix(matrix);
    }


    static ComplexMatrix identityMatrix (int dim){
        ComplexNumber [][] matrix = new ComplexNumber[dim][dim] ;

        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (i==j) matrix[i][j]=Constant.unitary.clone();
                else matrix[i][j]=Constant.empty.clone();
            }
        }
        return new ComplexMatrix(matrix);
    }


}
