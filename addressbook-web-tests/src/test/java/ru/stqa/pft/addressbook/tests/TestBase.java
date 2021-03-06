package ru.stqa.pft.addressbook.tests;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import javassist.bytecode.analysis.Executor;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.fluent.Request;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.SystemClock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by User on 30.10.2016.
 */
public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }

    @BeforeMethod
    public void logTestStart(Method m, Object[] p)
    {
        logger.info("Start test " + m.getName() + " with parameters " + Arrays.asList(p));
    }

    @AfterMethod(alwaysRun = true)
    public void logTestStop(Method m)
    {
        logger.info("Stop test " + m.getName());
    }

    public void verifyGroupListInUi() {
        if(Boolean.getBoolean("verifyUI"))
        {
            Groups dbGroups = app.db().groups();
            Groups uiGroups = app.group().all();
            assertThat(uiGroups,equalTo(dbGroups.stream().
                    map(g-> new GroupData().withId(g.getId()).withName(g.getName())).collect(Collectors.toSet())));
        }

    }

    boolean isIssueOpen(int issueId) throws IOException {

        try {
            String url = String.format("http://demo.bugify.com/api/issues/%d.json", issueId);
            String json = getExecutor().execute(Request.Get(url)).returnContent().asString();
            JsonElement parsed = new JsonParser().parse(json);
            int status = parsed.getAsJsonObject().getAsJsonArray("issues").get(0).getAsJsonObject().get("state").getAsInt();
            if(status!=0)
            {
                return true;
            }
        }
        catch (HttpResponseException ex){
            if(ex.getStatusCode()==404){
                return false;
            }
            else  {
                throw ex;
            }
        }

        return false;
    }

    private org.apache.http.client.fluent.Executor getExecutor() {
        return org.apache.http.client.fluent.Executor.newInstance().auth("LSGjeU4yP1X493ud1hNniA==","");
    }

    public void skipIfNotFixed(int issueId) throws SkipException, IOException {
        if (isIssueOpen(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }

    class SkipException extends Throwable {
        public SkipException(String s) {
            super(s);
        }
    }
}
