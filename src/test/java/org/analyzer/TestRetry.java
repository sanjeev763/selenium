package org.analyzer;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRetry {
    //We can use it for 1-2 Testcases if failing frequently for examining purpose
    // but if we need to apply it on all the Tests then it is not a good approach.
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void Test1(){
        Assert.assertEquals(true,false);
    }
    @Test
    public void Test2(){

        System.out.println("Running Test2");
        Assert.assertEquals(true,false);
    }
}
