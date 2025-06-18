package org.testClollection;

import org.testng.annotations.Test;
import org.utilityPractice.JsonDataConnection;

public class JSONDataConnectionTest {
    @Test(dataProvider = "getJsonData", dataProviderClass = JsonDataConnection.class)
    public void getJson(String fname, String lname) {
        System.out.println(fname);
        System.out.println(lname);
    }
}
