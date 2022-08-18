package Test;

import Model.ComplexNumber;
import Operation.CNOperation;
import org.junit.Assert;
import org.junit.Test;

public class CNOperationTest {


    ComplexNumber a = new ComplexNumber(2,2);
    ComplexNumber onlyReal = new ComplexNumber(2,0);
    ComplexNumber onlyIma = new ComplexNumber(0,2);
    Double res= 2.0;

    @Test
    public void modulo(){
        Assert.assertEquals(CNOperation.module(onlyReal),res);
        Assert.assertEquals(CNOperation.module(onlyIma),res);
    }
}
