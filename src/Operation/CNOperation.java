package Operation;

import Model.ComplexNumber;

//complex Number Operation
public interface CNOperation {

    static Double sqModule(ComplexNumber complexNumber){
        return ((complexNumber.getReal()*complexNumber.getReal())+(complexNumber.getImaginary()*complexNumber.getImaginary()));
    }

    static Double module(ComplexNumber complexNumber){
        return Math.sqrt(sqModule(complexNumber));
    }
    static Double angle(ComplexNumber complexNumber){
        return Math.atan2(complexNumber.getImaginary(),complexNumber.getReal());
    }

    static ComplexNumber add(ComplexNumber a ,ComplexNumber b){
        return new ComplexNumber((a.getReal()+ b.getReal()),a.getImaginary()+ b.getImaginary());
    }
    static ComplexNumber sub(ComplexNumber a ,ComplexNumber b){
        return new ComplexNumber((a.getReal()- b.getReal()),a.getImaginary()- b.getImaginary());
    }
    static ComplexNumber negate(ComplexNumber complexNumber){
        return new ComplexNumber(-complexNumber.getReal(),-complexNumber.getImaginary());
    }
    static ComplexNumber coniugate(ComplexNumber complexNumber){
        return new ComplexNumber(complexNumber.getReal(),-complexNumber.getImaginary());
    }
    static ComplexNumber prod(ComplexNumber a , ComplexNumber b){
        return new ComplexNumber(((a.getReal()*b.getReal())-(a.getImaginary()*b.getImaginary())),((a.getReal()*b.getImaginary())+(b.getReal()*a.getImaginary())));
    }

    static ComplexNumber div(ComplexNumber a, ComplexNumber b){
        Double sqMod = sqModule(b);
        if (sqMod == 0) return null;
        return new ComplexNumber(((a.getReal()*b.getReal()+(a.getImaginary())*b.getImaginary())/sqMod),(((b.getReal()*a.getImaginary())-(a.getReal()*b.getImaginary()))/sqMod));
    }


}
