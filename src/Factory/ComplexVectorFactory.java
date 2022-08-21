package Factory;

import Model.ComplexNumber;
import Model.ComplexVector;

public interface ComplexVectorFactory {

    ComplexNumber empty = new ComplexNumber(0,0);
    ComplexNumber unitary = new ComplexNumber(1,0);

    static ComplexVector emptyVector (int lenght ){
        ComplexNumber[] vector = new ComplexNumber[lenght];
        for (int i = 0; i < lenght; i++) {
            vector[i]=empty.clone();
        }
        return new ComplexVector(vector);
    }

    static ComplexVector offOneVector (int lenght ){
        ComplexNumber[] vector = new ComplexNumber[lenght];
        for (int i = 0; i < lenght; i++) {
            vector[i]=unitary.clone();
        }
        return new ComplexVector(vector);
    }



}
