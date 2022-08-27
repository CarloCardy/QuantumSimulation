package Test;

import Model.ComplexNumber;
import Operation.NumberOp;
import org.junit.Assert;
import org.junit.Test;

public class CNOperationTest {


    ComplexNumber a = new ComplexNumber(2,2);
    ComplexNumber onlyReal = new ComplexNumber(2,0);
    ComplexNumber onlyIma = new ComplexNumber(0,2);
    ComplexNumber empty = new ComplexNumber(0,0);

    @Test
    public void moduleTest(){
        Double res= 2.0;
        Assert.assertEquals(NumberOp.module(onlyReal),res);
        Assert.assertEquals(NumberOp.module(onlyIma),res);
    }
    @Test
    public void sqModuleTest(){
        Double res= 4.0;
        Assert.assertEquals(NumberOp.sqModule(onlyReal),res);
        Assert.assertEquals(NumberOp.sqModule(onlyIma),res);
    }
    @Test
    public void angleTest(){
        Double res= Math.PI/4;
        Assert.assertEquals(NumberOp.angle(a),res);
    }
    @Test
    public void addTest(){
        Assert.assertEquals(NumberOp.add(onlyIma,onlyReal),a);
        Assert.assertEquals(NumberOp.add(onlyReal,onlyIma),a);
    }
    @Test
    public void subTest(){
        Assert.assertEquals(NumberOp.sub(a,onlyIma),onlyReal);
    }
    @Test
    public void negateTest(){
        ComplexNumber res = new ComplexNumber(-2,-2);
        Assert.assertEquals(NumberOp.negate(a),res);
    }
    @Test
    public void coniugateTest(){
        ComplexNumber res = new ComplexNumber(2,-2);
        Assert.assertEquals(NumberOp.conjugate(a),res);
    }
    @Test
    public void prodTest(){
        ComplexNumber res = new ComplexNumber(0,4);
        Assert.assertEquals(NumberOp.prod(onlyReal,onlyIma),res);
        res=new ComplexNumber(4,0);
        Assert.assertEquals(NumberOp.prod(onlyReal,onlyReal),res);

    }
    @Test
    public void divtest(){
        ComplexNumber res = new ComplexNumber(1,1);
        Assert.assertEquals(NumberOp.div(a,onlyReal),res);
        Assert.assertNull(NumberOp.div(a,empty));
    }
}
