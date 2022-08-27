package Model;

import java.text.DecimalFormat;
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

        DecimalFormat df = new DecimalFormat("#.###");
        int app;
        String out="";

        if (real ==0 && imaginary== 0) return "0";
        if (this.equals(Constant.mod1rad2))return "√2/2+i√2/2";

        if (real!=0){
            app = (int)(double)real;
            if (real-app==0) out=""+app;
            else if (Math.abs(real) == (Math.sqrt(2)/2)){
                if (real<0)out+="-";
                out+="√2/2";
            }
            else out=""+df.format(real);
        }

        if(imaginary !=0) {
            if (imaginary>0) out +="+i";
            else out +="-i";
            app = (int) (double) imaginary;
            if (imaginary - app == 0) out +=Math.abs(app);
            else if (Math.abs(imaginary) == (Math.sqrt(2)/2)) out+="√2/2";
            else out+=df.format(Math.abs(imaginary));
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
