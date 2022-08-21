package Operation;

import Model.ComplexMatrix;

//Complex Matrix Operatio
public interface CMOperation {

    static ComplexMatrix negate (ComplexMatrix complexMatrix)
    {
        ComplexMatrix output =complexMatrix.clone();
        for (int i = 0; i < output.getRows() ; i++) {
            for (int j = 0; j < output.getColumns() ; j++) {
                output.setElement(i,j,output.getElement(i,j).retNegate());
            }
        }
        return output;
    }


}
