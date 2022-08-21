import Factory.ComplexMatrixFactory;
import Factory.ComplexVectorFactory;
import Model.ComplexMatrix;
import Model.ComplexNumber;
import Model.ComplexVector;
import Operation.CMOperation;
import Operation.CVOperation;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


        ComplexVector app = ComplexVectorFactory.offOneVector(5);
        System.out.println(app);
        System.out.println(CVOperation.add(app,CVOperation.negate(app)));

    }
}
