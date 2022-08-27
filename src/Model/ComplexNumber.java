package Model;

import java.util.Objects;

public class ComplexNumber {

    private Double real;
    private Double imaginary;

    public ComplexNumber (double real,double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    //get method
    public Double getImaginary() {
        return imaginary;
    }

    public Double getReal() {
        return real;
    }

    //set method
    public void setImaginary(Double imaginary) {
        this.imaginary = imaginary;
    }

    public void setReal(Double real) {
        this.real = real;
    }

    public void setBoth(Double real, Double imaginary){
        this.real=real;
        this.imaginary=imaginary;
    }

    public void setBoth(ComplexNumber complexNumber){setBoth(complexNumber.getReal(),complexNumber.getImaginary());}

    //generic method
    @Override
    public String toString() {

        int app;
        String out="";

        if (real ==0 && imaginary== 0) return "0";

        if (real!=0){
            app = (int)(double)real;
            if (real-app==0) out=""+app;
            else out=""+real;
        }

        if(imaginary !=0) {
            app = (int) (double) imaginary;
            if (imaginary - app == 0) out += "+i" + app;
            else out += "+i" + imaginary;
        }
        return out;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ComplexNumber)) return false;

        ComplexNumber that = (ComplexNumber) o;
        return (Math.abs(real - that.real) < Constant.epsilon && Math.abs(imaginary - that.imaginary) < Constant.epsilon);
    }

    public ComplexNumber clone(){
        return new ComplexNumber(real,imaginary);
    }


}
