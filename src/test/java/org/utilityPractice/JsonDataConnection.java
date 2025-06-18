package org.utilityPractice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.json.Json;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonDataConnection {
    @DataProvider
    public static Object[][] getJsonData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> jsonData= objectMapper.readValue(new File("D:\\CSE\\Practice\\SeleniumPractice\\src\\test\\SampleJson.json"),
                Map.class);
        int totalPage = (int) jsonData.get("total_pages");
        System.out.println(totalPage);
        List<Map<String, Object>> listData = (List<Map<String, Object>>) jsonData.get("data");
        ObjectMapper[][] data = new ObjectMapper[listData.size()][2];
        for(int i=0; i< listData.size(); i++){
            data[i][0] = (ObjectMapper) listData.get(i).get("first_name");
            data[i][1] = (ObjectMapper) listData.get(i).get("last_name");
        }
        return data;
    }
}
