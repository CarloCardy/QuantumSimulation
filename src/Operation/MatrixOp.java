package Operation;

import Factory.ComplexMatrixFactory;
import Model.ComplexMatrix;
import Model.ComplexNumber;
import Model.ComplexVector;
import Model.Constant;

//Complex Matrix Operatio
public interface MatrixOp {
    //Self Operation
    static void selfNegate(ComplexMatrix complexMatrix) {
        for (int i = 0; i <complexMatrix.getRows() ; i++) {
            for (int j = 0; j < complexMatrix.getColumns(); j++) {
                NumberOp.selfNegate(complexMatrix.getElement(i,j));
            }
        }
    }

    static void selfConjugate(ComplexMatrix complexMatrix){
        for (int i = 0; i <complexMatrix.getRows() ; i++) {
            for (int j = 0; j < complexMatrix.getColumns(); j++) {
                NumberOp.selfConjugate(complexMatrix.getElement(i,j));
            }
        }
    }

    static void selfScalarProduct(ComplexMatrix complexMatrix , ComplexNumber scalar){
        for (int i = 0; i < complexMatrix.getRows(); i++) {
            for (int j = 0; j < complexMatrix.getColumns(); j++) {
                NumberOp.prodTF(complexMatrix.getElement(i,j),scalar);
            }
        }

    }
    /**
     * TF = To the First
     *
     * @param a first element (is the container of addition)
     * @param b second element
     */
    static boolean addTF(ComplexMatrix a , ComplexMatrix b){
        if (a.getColumns() != b.getColumns() || a.getRows() != b.getRows() ) return false;

        for (int i = 0; i < a.getRows(); i++) {
            for (int j = 0; j < b.getColumns() ; j++) {
                NumberOp.addTF(a.getElement(i,j),b.getElement(i,j));
            }
        }
        return true;
    }

    // U* U_adj = I  una matrice è unitaria se il prodotto di essa per la sua adjoint è la matrice identità
    //riscrivo il codice per motivi di efficienza
    static boolean isUnitary(ComplexMatrix complexMatrix){

        if (complexMatrix.getRows()!= complexMatrix.getColumns()) return false;

        ComplexNumber app;

        int dim = complexMatrix.getRows();
        for (int i = 0; i <dim; i++) {
            for (int j = 0; j < dim ; j++) {
                ComplexNumber acc= Constant.empty.clone();
                for (int k = 0; k < dim; k++) {
                    app = complexMatrix.getCopyOfElement(j,k);
                    NumberOp.selfConjugate(app);
                    NumberOp.prodTF(app,complexMatrix.getElement(i,k));
                    NumberOp.addTF(acc,app);
                }
                if (i==j) {
                    if (!acc.equals(Constant.unitary)) return false;
                } else
                {
                    if (!acc.equals(Constant.empty))return false;
                }
            }
        }
        return true;
    }

    static boolean isHermitian(ComplexMatrix complexMatrix){

        if (complexMatrix.getRows()!= complexMatrix.getColumns()) return false;

        for (int i = 0; i < complexMatrix.getRows(); i++) {
            for (int j = 0; j < complexMatrix.getColumns(); j++) {
                if (i!=j){
                    if (!complexMatrix.getElement(i,j).equals(NumberOp.conjugate(complexMatrix.getElement(j,i)))) return false;
                }
                else {
                    if(!NumberOp.isReal(complexMatrix.getElement(i,j))) return false;
                }
            }
        }
        return true;
    }

    //Output Operation
    
    static ComplexMatrix negate (ComplexMatrix complexMatrix) {
        ComplexMatrix output =complexMatrix.clone();
        selfNegate(output);
        return output;
    }

    static ComplexMatrix scalarProduct(ComplexMatrix complexMatrix, ComplexNumber scalar){
        ComplexMatrix output =complexMatrix.clone();
        selfScalarProduct(output,scalar);
        return output;
    }

    static ComplexMatrix add(ComplexMatrix a , ComplexMatrix b){
        ComplexMatrix output =a.clone();
        if (!addTF(output,b)) return null;
        return output;
    }

    static ComplexMatrix conjugate (ComplexMatrix complexMatrix){
        ComplexMatrix output =complexMatrix.clone();
        selfConjugate(output);
        return output;
    }

    /**
     *
     * @param complexMatrix if matrix is [m][n] the traspose is [n][m]
     */
    static ComplexMatrix transpose(ComplexMatrix complexMatrix){
        ComplexMatrix out = ComplexMatrixFactory.emptyMatrix(complexMatrix.getColumns(), complexMatrix.getRows());
        for (int i = 0; i <complexMatrix.getRows() ; i++) {
            for (int j = 0; j < complexMatrix.getColumns(); j++) {
                out.replaceElement(j,i,complexMatrix.getCopyOfElement(i,j));
            }
        }
        return out;
    }

    static ComplexMatrix adjoint(ComplexMatrix complexMatrix){
        ComplexMatrix out = transpose(complexMatrix);
        selfConjugate(out);
        return out;
    }

    static ComplexMatrix prod(ComplexMatrix a , ComplexMatrix b ){
        if (a.getColumns() !=b.getRows()) return null;

        ComplexMatrix out = ComplexMatrixFactory.emptyMatrix(a.getRows(),b.getColumns());

        for (int i = 0; i < out.getRows(); i++) {
            for (int j = 0; j < b.getColumns(); j++) {
                ComplexNumber acc= Constant.empty.clone();
                for (int k = 0; k < a.getColumns(); k++) {
                    NumberOp.addTF(acc,NumberOp.prod(a.getElement(i,k),b.getElement(k,j)));
                }
                out.replaceElement(i,j,acc);
            }
        }
        return out;
    }

    static ComplexMatrix tensorProd(ComplexMatrix a, ComplexMatrix b){
        ComplexMatrix out = ComplexMatrixFactory.emptyMatrix(a.getRows()*b.getRows(),a.getColumns()*b.getColumns());

        for (int i = 0; i <a.getRows() ; i++) {
            for (int j = 0; j < a.getColumns(); j++) {
                for (int k = 0; k <b.getRows() ; k++) {
                    for (int l = 0; l <b.getColumns(); l++) {
                        out.replaceElement(k+(i*b.getRows()),l+(j*b.getColumns()),NumberOp.prod(a.getElement(i,j),b.getElement(k,l)));
                    }
                }
            }
        }
    return out;
    }

    static ComplexMatrix vectorToMatrixRow(ComplexVector complexVector){
        ComplexMatrix out = ComplexMatrixFactory.emptyMatrix(1,complexVector.getLenght());
        for (int i = 0; i < complexVector.getLenght(); i++) {
            out.replaceElement(1,i,complexVector.getElement(i));
        }
        return out;
    }
    static ComplexMatrix vectorToMatrixCollum(ComplexVector complexVector){
        ComplexMatrix out = ComplexMatrixFactory.emptyMatrix(complexVector.getLenght(),1);
        for (int i = 0; i < complexVector.getLenght(); i++) {
            out.replaceElement(i,1,complexVector.getElement(i));
        }
        return out;
    }


}
