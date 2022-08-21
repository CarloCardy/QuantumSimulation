package Operation;

import Model.ComplexNumber;

//complex Number Operation
public interface CNOperation {

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
        //per ottimizzazione separo il caso in cui la parte immaginaria è nulla e quella in cui non lo è
        if (a.getImaginary()==0 && b.getImaginary()==0) return new ComplexNumber(a.getReal()*b.getReal(),0);
        return new ComplexNumber(((a.getReal()*b.getReal())-(a.getImaginary()*b.getImaginary())),((a.getReal()*b.getImaginary())+(b.getReal()*a.getImaginary())));
    }

    static ComplexNumber div(ComplexNumber a, ComplexNumber b){
        Double sqMod = b.sqModule();
        if (sqMod == 0) return null;
        //per ottimizzazione separo il caso in cui la parte immaginaria è nulla e quella in cui non lo è
        if (a.getImaginary()==0 && b.getImaginary()==0) return new ComplexNumber(a.getReal()/b.getReal(),0);
        return new ComplexNumber(((a.getReal()*b.getReal()+(a.getImaginary())*b.getImaginary())/sqMod),(((b.getReal()*a.getImaginary())-(a.getReal()*b.getImaginary()))/sqMod));
    }
}
