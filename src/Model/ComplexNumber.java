package Model;

import java.util.Objects;

public class ComplexNumber {

    private Double real;
    private Double imaginary;

    public ComplexNumber (double real,double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Double getImaginary() {
        return imaginary;
    }

    public Double getReal() {
        return real;
    }

    public void setImaginary(Double imaginary) {
        this.imaginary = imaginary;
    }

    public void setReal(Double real) {
        this.real = real;
    }


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
        ComplexNumber that = (ComplexNumber) o;
        return Objects.equals(real, that.real) && Objects.equals(imaginary, that.imaginary);
    }

    public Double sqModule(){
        return ((real*real)+(imaginary*imaginary));
    }

    public Double module(){
        return Math.sqrt(sqModule());
    }

    public void selfNegate(){
        real=-real;
        imaginary=-imaginary;
    }

    public ComplexNumber retNegate(){
        return new ComplexNumber(-real,-imaginary);
    }

    public void selfConiugate(){
        imaginary=-imaginary;
    }

    public ComplexNumber retConiugate() {
        return new ComplexNumber(real,-imaginary);
    }

    public ComplexNumber clone(){
        return new ComplexNumber(real,imaginary);
    }


}
