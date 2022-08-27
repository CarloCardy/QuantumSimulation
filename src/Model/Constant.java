package Model;

public interface Constant {

   static ComplexNumber empty = new ComplexNumber(0,0);
   static ComplexNumber unitary = new ComplexNumber(1,0);
   static ComplexNumber mod1rad2 = new ComplexNumber(Math.sqrt(2)/2,Math.sqrt(2)/2);
   static double epsilon = 0.000001d;


}
