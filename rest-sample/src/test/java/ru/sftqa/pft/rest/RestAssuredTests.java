package ru.sftqa.pft.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

/**
 * Created by User on 23.12.2016.
 */
public class RestAssuredTests {
    @BeforeClass
    public void init(){
        RestAssured.authentication = RestAssured.basic("LSGjeU4yP1X493ud1hNniA==","");
    }

    @Test
    public void testCreateIssue() throws IOException {
        Set<Issue> oldIssues = getIssues();
        Issue newIssue = new Issue().withSubject("test issue").withDescription("new Test Issue");
        int issueId = createIssue(newIssue);
        oldIssues.add(newIssue.withId(issueId));
        Set<Issue> newIssues = getIssues();
        assertEquals(newIssues,oldIssues);
    }

    private Set<Issue> getIssues() throws IOException {
        String json = RestAssured.get("http://demo.bugify.com/api/issues.json").asString();
        JsonElement parsed = new JsonParser().parse(json);
        JsonElement issues = parsed.getAsJsonObject().get("issues");

        return new Gson().fromJson(issues, new TypeToken<Set<Issue>>(){}.getType());
    }

    private int createIssue(Issue newIssue) throws IOException {

        String json = RestAssured.given().param("subject", newIssue.getSubject()).
                param("description", newIssue.getDescription()).
                post("http://demo.bugify.com/api/issues.json").asString();

        JsonElement parsed = new JsonParser().parse(json);
        return parsed.getAsJsonObject().get("issue_id").getAsInt();
    }


}
