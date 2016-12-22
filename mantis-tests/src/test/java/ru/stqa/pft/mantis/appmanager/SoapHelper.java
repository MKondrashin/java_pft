package ru.stqa.pft.mantis.appmanager;

import biz.futureware.mantis.rpc.soap.client.*;
import org.apache.axis.AxisFault;
import ru.stqa.pft.mantis.model.Issue;
import ru.stqa.pft.mantis.model.IssueStatus;
import ru.stqa.pft.mantis.model.IssueStatuses;
import ru.stqa.pft.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by User on 22.12.2016.
 */
public class SoapHelper {
    private final ApplicationManager app;

    public SoapHelper(ApplicationManager app) {
        this.app = app;
    }

    public Set<Project> getProjects() throws MalformedURLException, ServiceException, RemoteException {
        MantisConnectPortType mc = getMantisConnect();
        ProjectData[] projects = mc.mc_projects_get_user_accessible("administrator", "root");
        return Arrays.asList(projects).stream().
                map(p-> new Project().withName(p.getName()).withId(p.getId().intValue())).collect(Collectors.toSet());
    }

    private MantisConnectPortType getMantisConnect() throws ServiceException, MalformedURLException {
        return new MantisConnectLocator().
                    getMantisConnectPort(new URL("http://localhost/mantisbt-1.3.4/api/soap/mantisconnect.php"));
    }

    public Issue addIssue(Issue issue) throws MalformedURLException, ServiceException, RemoteException {
        MantisConnectPortType mc = getMantisConnect();

        String[] categories = mc.mc_project_get_categories("administrator", "root", BigInteger.valueOf(issue.getProject().getId()));
        IssueData issueData = new IssueData();

        issueData.setDescription(issue.getDescription());
        issueData.setCategory(categories[0]);
        issueData.setProject(new ObjectRef(BigInteger.valueOf(issue.getProject().getId()), issue.getProject().getName()));
        BigInteger issueId = mc.mc_issue_add("administrator", "root", issueData);
        IssueData createdIssueData = mc.mc_issue_get("administrator", "root", issueId);
        return new Issue().withId(createdIssueData.getId().intValue()).
                withDescription(createdIssueData.getDescription()).
                withSummary(createdIssueData.getSummary()).
                withProject(new Project().withId(createdIssueData.getProject().getId().intValue()).withName(createdIssueData.getProject().getName()));
    }

    public List<IssueStatus> getAllIssueStatuses() throws MalformedURLException, ServiceException, RemoteException {
        MantisConnectPortType mc = getMantisConnect();
        return  Arrays.asList(mc.mc_enum_status("administrator", "root"))
                .stream().map(ms-> (IssueStatus) new IssueStatus().withId(ms.getId().intValue()).withName(ms.getName()))
                .collect(Collectors.toList());
    }

    public IssueStatus getIssueStatusById(int issueId) throws MalformedURLException, ServiceException, RemoteException {
        try{
            MantisConnectPortType mc = getMantisConnect();
            IssueData issueData = mc.mc_issue_get("administrator", "root", BigInteger.valueOf(issueId));
            return IssueStatuses.getById(issueData.getStatus().getId());
        }
        catch (AxisFault f){
            if(f.getFaultString().equals("Issue does not exist")){
                return  IssueStatuses.NOT_EXISTS();
            }
            else{
                throw f;
            }
        }

    }
}
