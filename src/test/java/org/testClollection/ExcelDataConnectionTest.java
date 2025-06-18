package org.testClollection;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.utilityPractice.ExcelDataConnection;

import java.io.IOException;

public class ExcelDataConnectionTest {
    @Test(dataProvider = "connectWithExcel", dataProviderClass = ExcelDataConnection.class)
    public void getExcelData(String LEGALENTITYEXTERNALID , String nature_and_intended_purpose) {
        //exec [mizuho].[Sp_UpdateNatureAndIntended] 'MHBK_B005009', 'Deposit taking'
//        System.out.println("LEGALENTITYEXTERNALID - "+LEGALENTITYEXTERNALID );
//        System.out.println("nature_and_intended_purpose - "+nature_and_intended_purpose);
        System.out.println("exec [mizuho].[Sp_UpdateNatureAndIntended] '"+LEGALENTITYEXTERNALID+"', '"+nature_and_intended_purpose+"'");
    }
}
