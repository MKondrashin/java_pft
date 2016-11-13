package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 30.10.2016.
 */
public class GroupHelper extends HelperBase{

    public GroupHelper(WebDriver wd)
    {
        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.xpath("//div[@id='content']/form"));
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void selectGroup(int index) {

        wd.findElements(By.name("selected[]")).get(index).click();

    }

    public void deleteSelectedGroups() {
        click(By.xpath("//div[@id='content']/form/input[5]"));
    }

    public void initGroupModification() {
        click(By.xpath("//div[@id='content']/form/input[6]"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void create(GroupData groupData) {
        initGroupCreation();
        fillGroupForm(groupData);
        submitGroupCreation();
        returnToGroupPage();

    }

    public boolean isThereAGroup() {
        return isElementPresented(By.name("selected[]"));
    }

    public void delete(int indexOf) {
        selectGroup(indexOf);
        deleteSelectedGroups();
        returnToGroupPage();
    }

    public void modify(GroupData group, int indexOf) {
        selectGroup(indexOf);
        initGroupModification();
        fillGroupForm( group);
        submitGroupModification();
        returnToGroupPage();
    }

    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size();

    }

    public List<GroupData> list() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements)
        {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groups.add(new GroupData().withId(id).withName(name));
        }

        return groups;

    }
}
