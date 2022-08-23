package Model;

import java.util.Arrays;

public class ComplexVector {

    ComplexNumber[] vector;

    public ComplexVector() {
    }

    public ComplexVector(ComplexNumber[] vector) {
        this.vector = vector;
    }

    //get Method

    public int getLenght() {
        return vector.length;
    }

    public ComplexNumber getElement(int pos) {return vector[pos];}

    public ComplexNumber getCopyOfElement(int pos) {return vector[pos].clone();}

    //set Method

    public void setElement(int pos, ComplexNumber element) {
        vector[pos].setBoth(element);
    }

    //generic Method

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComplexVector vector1)) return false;
        if (vector1.getLenght() != getLenght()) return false;
        for (int i = 0; i < getLenght(); i++) if (vector1.getElement(i).equals(getElement(i))) return false;
        return true;
    }
}