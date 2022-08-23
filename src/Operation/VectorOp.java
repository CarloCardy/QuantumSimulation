package Operation;

import Factory.ComplexVectorFactory;
import Model.ComplexNumber;
import Model.ComplexVector;

public interface VectorOp {

    //Self Operation
    /**
     * TF = To the First
     *
     * @param a first element (is the container of addition)
     * @param b second element
     */
    static boolean addTF(ComplexVector a , ComplexVector b){
        if (a.getLenght()!= b.getLenght()) return false;
        for (int i = 0; i < a.getLenght(); i++) NumberOp.addTF(a.getElement(i),b.getElement(i));
        return true;
    }

    static void selfScalarProduct(ComplexVector complexVector ,ComplexNumber scalar){for (int i = 0; i < complexVector.getLenght(); i++) NumberOp.prod(complexVector.getElement(i),scalar);}


    static void selfNegate(ComplexVector a) {for (int i = 0; i < a.getLenght(); i++) NumberOp.selfNegate(a.getElement(i));}

    //Output Operation

    static ComplexVector add (ComplexVector a , ComplexVector b){
        ComplexVector out = a.clone();
        if (!addTF(a,b)) return null;
        return out;
    }

    static ComplexVector negate (ComplexVector complexVector){
        ComplexVector out = complexVector.clone();
        selfNegate(out);
        return out;
    }

    static ComplexVector sclarProduct (ComplexVector complexVector, ComplexNumber sclar)
    {
        ComplexVector out =complexVector.clone();
        selfScalarProduct(out,sclar);
        return out;
    }

}
