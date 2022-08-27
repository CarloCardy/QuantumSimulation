package Model;

import Factory.ComplexMatrixFactory;

import java.util.Arrays;


public class ComplexMatrix {

    ComplexNumber[][] matrix;

    public ComplexMatrix(ComplexNumber[][] matrix){
        this.matrix=matrix;
    }

    //matrici Rettangolari

    //get Method
    public int getRows(){
        return matrix.length;
    }

    public int getColumns(){
        if (getRows()>0) return matrix[0].length;
        return 0;
    }

    public ComplexNumber getElement (int row, int col){return matrix[row][col];}

    public ComplexNumber getCopyOfElement (int row, int col){return matrix[row][col].clone();}

    //set Method
    public void setElement(int row,int col ,ComplexNumber element){ matrix[row][col].setBoth(element);}

    public void replaceElement(int row,int col ,ComplexNumber element){matrix[row][col]=element;}

    //generic method

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

        int max=3;
        for (int row = 0; row < getRows(); row++) {
            for (int col = 0; col < getColumns(); col++) {
                if (max< matrix[row][col].toString().length()) max=matrix[row][col].toString().length();
            }
        }
        max++;
         String out = "";
        for (int row = 0; row < getRows(); row++) {
            for (int col = 0; col < getColumns(); col++) {
                out+= String.format("%"+(max)+"s", matrix[row][col].toString());
            }
            out +="\n";
        }

        return out;
    }

    @Override
    public boolean equals(Object o) {

        if (!(o instanceof ComplexMatrix cM)) return false;

        if (getRows() != cM.getRows() || getColumns() != cM.getColumns()) return false;

        for (int i = 0; i <getRows() ; i++) {
            for (int j = 0; j < getColumns(); j++) {
                if (!getElement(i,j).equals(cM.getElement(i,j))) return false;
            }
        }
        
        return true;
    }
}
