package Operation;

import Model.ComplexNumber;

//complex Number Operation
public interface NumberOp {

    //Self Operation

    /**
     * TF = To the First
     *
     * @param a first element (is the container of addition)
     * @param b second element
     */
    static void addTF (ComplexNumber a, ComplexNumber b ){a.setBoth(a.getReal()+ b.getReal(),a.getImaginary()+ b.getImaginary());}
    /**
     * TF = To the First
     *
     * @param a first element (is the container of addition)
     * @param b second element
     */
    static void subTF (ComplexNumber a ,ComplexNumber b){ a.setBoth(a.getReal()- b.getReal(),a.getImaginary()- b.getImaginary());}
    /**
     * TF = To the First
     *
     * @param a first element (is the container of addition)
     * @param b second element
     */
    static void prodTF(ComplexNumber a, ComplexNumber b){
        if (a.getImaginary()==0 && b.getImaginary()==0) a.setReal(a.getReal()*b.getReal());
        else a.setBoth((a.getReal()*b.getReal())-(a.getImaginary()*b.getImaginary()),(a.getReal()*b.getImaginary())+(b.getReal()*a.getImaginary()));
    }
    /**
     * TF = To the First
     *
     * @param a first element (is the container of addition)
     * @param b second element
     */
    static boolean divTF(ComplexNumber a, ComplexNumber b){
        double sqMod = sqModule(b);
        if (sqMod == 0) return false;
        //per ottimizzazione separo il caso in cui la parte immaginaria è nulla e quella in cui non lo è
        if (a.getImaginary()==0 && b.getImaginary()==0) a.setReal(a.getReal()/b.getReal());
        else a.setBoth(((a.getReal()*b.getReal()+(a.getImaginary())*b.getImaginary())/sqMod),(((b.getReal()*a.getImaginary())-(a.getReal()*b.getImaginary()))/sqMod));
        return true;
    }
    static void selfNegate(ComplexNumber a){a.setBoth(-a.getReal(),-a.getImaginary());}

    static void selfConiugate(ComplexNumber a){a.setImaginary(-a.getImaginary());}
    //Output Operation
    static Double angle(ComplexNumber complexNumber){return Math.atan2(complexNumber.getImaginary(),complexNumber.getReal());}

    static Double sqModule(ComplexNumber complexNumber){return ((complexNumber.getReal()*complexNumber.getReal())+(complexNumber.getImaginary()*complexNumber.getImaginary()));}

    static Double module(ComplexNumber complexNumber){return Math.sqrt(sqModule(complexNumber));}

    static ComplexNumber add(ComplexNumber a ,ComplexNumber b){return new ComplexNumber((a.getReal()+ b.getReal()),a.getImaginary()+ b.getImaginary());}

    static ComplexNumber sub(ComplexNumber a ,ComplexNumber b){return new ComplexNumber((a.getReal()- b.getReal()),a.getImaginary()- b.getImaginary());}

    static ComplexNumber negate(ComplexNumber complexNumber){return new ComplexNumber(-complexNumber.getReal(),-complexNumber.getImaginary());}

    static ComplexNumber coniugate(ComplexNumber complexNumber){return new ComplexNumber(complexNumber.getReal(),-complexNumber.getImaginary());}

    static ComplexNumber prod(ComplexNumber a , ComplexNumber b){
        ComplexNumber out = a.clone();
        prodTF(out,b);
        return out;
    }

    static ComplexNumber div(ComplexNumber a, ComplexNumber b){
        ComplexNumber out = a.clone();
        if (divTF(out,b)) return out;
        return null;
    }
}
