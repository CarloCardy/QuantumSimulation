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
        return "{"+ real + ","+imaginary+"}";
    }

    @Override
    public boolean equals(Object o) {
        ComplexNumber that = (ComplexNumber) o;
        return Objects.equals(real, that.real) && Objects.equals(imaginary, that.imaginary);
    }
}
