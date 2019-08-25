package se.ec.loffe;

import org.junit.Assert;
import org.junit.Test;

public class AppTest 
{

    @Test
    public void testAddition(){
        double num1 = 5.6;
        double num2 = 4.8;
        double num3 = 1;
        double expectedResult = 11.4;

        Assert.assertEquals(expectedResult, App.addition(num1, num2, num3),0.01);
    }

    @Test
    public void testSubtraction(){
        double num1 = 5.6;
        double num2 = 4.8;
        double num3 = 1;
        double expectedResult = -0.2;

        Assert.assertEquals(expectedResult, App.subtraction(num1, num2, num3),0.01);
    }
    @Test
    public void testMultiplication(){
        double num1 = 5.6;
        double num2 = 4.8;
        double expectedResult = 26.88;

        Assert.assertEquals(expectedResult, App.multiplication(num1, num2),0.01);
    }
    @Test
    public void testDivision(){
        double num1 = 5.6;
        double num2 = 4.8;
        double expectedResult = 1.17;

        Assert.assertEquals(expectedResult, App.division(num1, num2),0.01);
    }
    @Test
    public void testModulus(){
        double num1 = 5.6;
        double num2 = 4.8;
        double expectedResult = 0.8;

        Assert.assertEquals(expectedResult, App.modulus(num1, num2),0.01);
    }
    @Test
    public void testAddFromArray(){
        double[] numbers = {2, 3, 4, 5};
        double expectedResult = 14.0;

        Assert.assertEquals(expectedResult, App.addFromArray(numbers),0.01);
    }
}
