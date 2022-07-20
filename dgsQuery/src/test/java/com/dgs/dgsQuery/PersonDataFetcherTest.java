package com.dgs.dgsQuery;

import com.dgs.dgsQuery.datafetchers.PersonDataFetcher;
import com.netflix.graphql.dgs.DgsQueryExecutor;
import com.netflix.graphql.dgs.autoconfig.DgsAutoConfiguration;
import graphql.ExecutionResult;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {DgsAutoConfiguration.class, PersonDataFetcher.class})
public class PersonDataFetcherTest {

    @Autowired
    DgsQueryExecutor dgsQueryExecutor;

    @Test
    void searchPerson(){
        ExecutionResult executionResult = dgsQueryExecutor.execute("{\n" +
                "  searchPerson(searchPersonId: 3){\n" +
                "    personId\n" +
                "    personName\n" +
                "    personAddress{\n" +
                "      streetName\n" +
                "      houseNumber\n" +
                "      city\n" +
                "      country\n" +
                "    }\n" +
                "  }\n" +
                "}");

        JSONObject jsonObject;
        try {
            jsonObject = (new JSONObject(executionResult.getData().toString())).getJSONObject("searchPerson");
            assertEquals(jsonObject.get("personId"), 3);
            assertEquals(jsonObject.get("personName"), "personName3");
        } catch (JSONException e) {
             e.printStackTrace();
        }
    }
}
