package Operation;

import Factory.ComplexVectorFactory;
import Model.ComplexNumber;
import Model.ComplexVector;

public interface CVOperation {

    static ComplexVector add (ComplexVector a , ComplexVector b){
        if (a.getLenght()!= b.getLenght()) return null;
        ComplexVector out = ComplexVectorFactory.emptyVector(a.getLenght());
        for (int i = 0; i < a.getLenght(); i++) {
            a.setElement(i,CNOperation.add(a.getElement(i),b.getElement(i)));
        }
        return out;
    }

    static ComplexVector negate (ComplexVector complexVector){
        ComplexVector out = complexVector.clone();
        out.selfNegate();
        return out;
    }

    static void selfScalarProduct(ComplexVector complexVector ,ComplexNumber scalar){
        for (int i = 0; i < complexVector.getLenght(); i++) complexVector.setElement(i,CNOperation.prod(scalar,complexVector.getElement(i)));
    }

    static ComplexVector sclarProduct (ComplexVector complexVector, ComplexNumber sclar)
    {
        ComplexVector out =complexVector.clone();
        selfScalarProduct(out,sclar);
        return out;
    }

}
