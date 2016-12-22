package ru.stqa.pft.mantis.model;

import org.openqa.selenium.InvalidArgumentException;

import java.math.BigInteger;

/**
 * Created by User on 22.12.2016.
 */
public class IssueStatuses {
    public static IssueStatus NEW(){
        return (IssueStatus) new IssueStatus().
                withName("new").
                withId(10);
    }

    public static IssueStatus FEEDBACK(){
        return (IssueStatus) new IssueStatus().
                withName("feedback").
                withId(20);
    }

    public static IssueStatus ACKNOWLEDGED(){
        return (IssueStatus) new IssueStatus().
                withName("acknowledged").
                withId(30);
    }

    public static IssueStatus CONFIRMED(){
        return (IssueStatus) new IssueStatus().
                withName("confirmed").
                withId(40);
    }

    public static IssueStatus ASSIGNED(){
        return (IssueStatus) new IssueStatus().
                withName("assigned").
                withId(50);
    }

    public static IssueStatus RESOLVED(){
        return (IssueStatus) new IssueStatus().
                withName("assigned").
                withId(80);
    }

    public static IssueStatus CLOSED(){
        return (IssueStatus) new IssueStatus().
                withName("closed").
                withId(90);
    }

    public static IssueStatus NOT_EXISTS(){
        return (IssueStatus) new IssueStatus().
                withName("not_exists").
                withId(-1);
    }


    public static IssueStatus getById(BigInteger bid) throws InvalidArgumentException {
        int id = bid.intValue();
        switch (id){
            case 10: return NEW();
            case 20: return FEEDBACK();
            case 30: return ACKNOWLEDGED();
            case 40: return CONFIRMED();
            case 50: return ASSIGNED();
            case 80: return RESOLVED();
            case 90: return CLOSED();
            case -1: return NOT_EXISTS();
            default: throw new InvalidArgumentException(String.format("Invalid Issue Status: %d", bid));
        }
    }
}
