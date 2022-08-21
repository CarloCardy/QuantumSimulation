package Test;

import Model.ComplexNumber;
import Operation.CNOperation;
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
        Assert.assertEquals(onlyReal.module(),res);
        Assert.assertEquals(onlyIma.module(),res);
    }
    @Test
    public void sqModuleTest(){
        Double res= 4.0;
        Assert.assertEquals(onlyReal.sqModule(),res);
        Assert.assertEquals(onlyIma.sqModule(),res);
    }
    @Test
    public void angleTest(){
        Double res= Math.PI/4;
        Assert.assertEquals(CNOperation.angle(a),res);
    }
    @Test
    public void addTest(){
        Assert.assertEquals(CNOperation.add(onlyIma,onlyReal),a);
        Assert.assertEquals(CNOperation.add(onlyReal,onlyIma),a);
    }
    @Test
    public void subTest(){
        Assert.assertEquals(CNOperation.sub(a,onlyIma),onlyReal);
    }
    @Test
    public void negateTest(){
        ComplexNumber res = new ComplexNumber(-2,-2);
        Assert.assertEquals(CNOperation.negate(a),res);
    }
    @Test
    public void coniugateTest(){
        ComplexNumber res = new ComplexNumber(2,-2);
        Assert.assertEquals(CNOperation.coniugate(a),res);
    }
    @Test
    public void prodTest(){
        ComplexNumber res = new ComplexNumber(0,4);
        Assert.assertEquals(CNOperation.prod(onlyReal,onlyIma),res);
        res=new ComplexNumber(4,0);
        Assert.assertEquals(CNOperation.prod(onlyReal,onlyReal),res);

    }
    @Test
    public void divtest(){
        ComplexNumber res = new ComplexNumber(1,1);
        Assert.assertEquals(CNOperation.div(a,onlyReal),res);
        Assert.assertNull(CNOperation.div(a,empty));
    }
}
