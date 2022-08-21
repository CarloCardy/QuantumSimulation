package Model;

import Factory.ComplexMatrixFactory;

import java.util.Arrays;

public class ComplexMatrix {

    ComplexNumber[][] matrix;
    public ComplexMatrix(ComplexNumber[][] matrix){
        this.matrix=matrix;
    }

    public ComplexNumber[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(ComplexNumber[][] matrix) {
        this.matrix = matrix;
    }

    //la matrice per costruzione del Factory è perforza rettangolare quindi ogni riga e colonna hanno dimensioni uguali con le rispettive righe e colonne
    public int getRows(){
        return matrix.length;
    }

    public int getColumns(){
        if (getRows()>0) return matrix[0].length;
        return 0;
    }

    public void setElement(int row,int col ,ComplexNumber element){
        matrix[row][col]=element;
    }

    public ComplexNumber getElement (int row, int col){return matrix[row][col];}

    public void selfNegate (){
        for (int i = 0; i < getRows() ; i++) {
            for (int j = 0; j < getColumns(); j++) {
                matrix[i][j].selfNegate();
            }
        }
    }

    private ComplexNumber[][] innerClone(){
        ComplexNumber[][] cloneM = new ComplexNumber[getRows()][getColumns()];
        for (int i = 0; i < getRows() ; i++) {
            for (int j = 0; j < getColumns(); j++) {
                cloneM[i][j]= matrix[i][j].clone();
            }
        }
        return cloneM;
    }

    public ComplexMatrix clone (){
        return new ComplexMatrix(innerClone());
    }


    @Override
    public String toString() {

        int max=0;
        for (int row = 0; row < getRows(); row++) {
            for (int col = 0; col < getColumns(); col++) {
                if (max< matrix[row][col].toString().length()) max=matrix[row][col].toString().length();
            }
        }
        max++;

        if (max< 3) max=3;

         String out = "";
        for (int row = 0; row < getRows(); row++) {
            for (int col = 0; col < getColumns(); col++) {
                out+= String.format("%"+(max)+"s", matrix[row][col].toString());
            }
            out +="\n";
        }

        return out;
    }

}
