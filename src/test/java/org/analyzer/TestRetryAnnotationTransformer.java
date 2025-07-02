package org.analyzer;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRetryAnnotationTransformer {
    @Test
    public void Test1(){

        System.out.println("Running Test1");
        Assert.assertEquals(true,false);
    }
    @Test
    public void Test2(){
        System.out.println("Running Test2");
        Assert.assertEquals(true,false);
    }
}
