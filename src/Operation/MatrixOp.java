package Operation;

import Model.ComplexMatrix;

//Complex Matrix Operatio
public interface MatrixOp {
    //Self Operation
    static void selfNegate(ComplexMatrix complexMatrix)
    {
        for (int i = 0; i <complexMatrix.getRows() ; i++) {
            for (int j = 0; j < complexMatrix.getColumns(); j++) {
                NumberOp.negate(complexMatrix.getElement(i,j));
            }
        }
    }

    //Output Operation
    static ComplexMatrix negate (ComplexMatrix complexMatrix)
    {
        ComplexMatrix output =complexMatrix.clone();
        MatrixOp.selfNegate(complexMatrix);
        return output;
    }


}
