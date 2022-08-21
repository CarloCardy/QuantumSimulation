package Model;

import java.util.Arrays;

public class ComplexVector {

    ComplexNumber[] vector;

    public ComplexVector() {
    }

    public ComplexVector(ComplexNumber[] vector) {
        this.vector = vector;
    }

    public int getLenght() {
        return vector.length;
    }

    public ComplexNumber getElement(int pos) {
        return vector[pos].clone();
    }

    public void setElement(int pos, ComplexNumber element) {
        vector[pos] = element;
    }

    public ComplexNumber[] innerClone() {
        ComplexNumber[] out = new ComplexNumber[getLenght()];
        for (int i = 0; i < getLenght(); i++) {
            out[i] = vector[i].clone();
        }
        return out;
    }

    public ComplexVector clone() {
        return new ComplexVector(innerClone());
    }

    public void selfNegate() {
        for (int i = 0; i < getLenght(); i++) {
            vector[i].selfNegate();
        }
    }

    @Override
    public String toString() {
        int max = 1;
        for (int i = 0; i < getLenght(); i++) {
            if (max < vector[i].toString().length()) max = vector[i].toString().length();
        }
        max++;

        String out = "";
        for (int i = 0; i < getLenght(); i++) {
            out += String.format("%" + (max) + "s", vector[i].toString());
        }

        return out;
    }
}