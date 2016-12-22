package ru.stqa.pft.mantis.tests;

import biz.futureware.mantis.rpc.soap.client.MantisConnectLocator;
import biz.futureware.mantis.rpc.soap.client.MantisConnectPortType;
import biz.futureware.mantis.rpc.soap.client.ProjectData;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.model.Issue;
import ru.stqa.pft.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Set;

import static org.testng.Assert.*;

/**
 * Created by User on 22.12.2016.
 */
public class SoapTests extends TestBase{
    @Test
    public void testGetProjects() throws MalformedURLException, ServiceException, RemoteException {
        Set<Project> projects = app.soap().getProjects();
        System.out.println(projects.size());
        for (Project project : projects)
            System.out.println(project.getName());
        }

    @Test
    public void testCreateIssue() throws RemoteException, ServiceException, MalformedURLException {
        Project project = app.soap().getProjects().iterator().next();
        Issue issue = new Issue().
                withSummary("TEST ISSUE SUMMARY").
                withDescription("TEST ISSUE DESCRIPTION").
                withProject(project);
        Issue created = app.soap().addIssue(issue);
        assertEquals(created.getSummary(), issue.getSummary());

    }
}



