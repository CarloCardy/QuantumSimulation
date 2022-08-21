package Operation;

import Model.ComplexMatrix;

//Complex Matrix Operatio
public interface CMOperation {

    static ComplexMatrix negate (ComplexMatrix complexMatrix)
    {
        ComplexMatrix output =complexMatrix.clone();
        output.selfNegate();
        return output;
    }


}
