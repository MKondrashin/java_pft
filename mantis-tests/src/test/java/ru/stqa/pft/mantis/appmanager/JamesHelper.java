package ru.stqa.pft.mantis.appmanager;

import org.apache.commons.net.telnet.TelnetClient;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.SocketException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by User on 18.12.2016.
 */
public class JamesHelper {
    private ApplicationManager app;
    private TelnetClient telnet;
    private InputStream in;
    private PrintStream out;

    private Session mailSession;
    private Store store;
    private String mailServer;


    public JamesHelper(ApplicationManager applicationManager) {
        app = applicationManager;
        telnet = new TelnetClient();
        mailSession = Session.getDefaultInstance(System.getProperties());
    }

    public void createUser(String user, String email) {
        initTelnetSession();
        write("adduser " + user + " " + email);
        String result = readUntil("User " + user + " added");
    }



    public List<MailMessage> waitForMail(String user, String password, long i) throws MessagingException {
        long now = System.currentTimeMillis();
        while (System.currentTimeMillis() < now + i){
            List<MailMessage> allMail = getAllMail(user, password);
            if(allMail.size() > 0){
                return allMail;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        throw new Error("No mail");
    }

    private List<MailMessage> getAllMail(String user, String password) throws MessagingException {
        Folder inbox = openInbox(user,password);
        List<MailMessage> messages = Arrays.asList(inbox.getMessages()).stream().map(
                m-> MailHelper.toModelMail(m)
        ).collect(Collectors.toList());
        closeFolder(inbox);
        return messages;
    }

    private void closeFolder(Folder folder) throws MessagingException {
        folder.close(true);
        store.close();
    }

    private Folder openInbox(String user, String password) throws MessagingException {
        store = mailSession.getStore("pop3");
        store.connect(mailServer,user,password);
        Folder folder = store.getDefaultFolder().getFolder("INBOX");
        folder.open(Folder.READ_WRITE);
        return folder;
    }

    private void initTelnetSession()
    {
        mailServer = app.getProperty("mailserver.host");
        int port = Integer.parseInt(app.getProperty("mailserver.port"));
        String login = app.getProperty("mailserver.adminlogin");
        String password = app.getProperty("mailserver.adminpassword");

        try
        {
            telnet.connect(mailServer, port);
            in = telnet.getInputStream();
            out = new PrintStream(telnet.getOutputStream());
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        readUntil("Login id:");
        write("");
        readUntil("Password:");
        write("");
        readUntil("Login id:");
        write(login);
        readUntil("Password:");
        write(password);
        readUntil("Welcome " + login + ". HELP for a list of commands");
    }

    private String readUntil(String s) {
        try {
            char lastChar = s.charAt(s.length() - 1);
            StringBuffer sb = new StringBuffer();
            char ch = (char) in.read();
            while(true)
            {
                System.out.print(ch);
                sb.append(ch);
                if(ch == lastChar){
                    if(sb.toString().endsWith(s)){
                        return sb.toString();
                    }
                }
                ch = (char) in.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void write(String s) {
        try{
            out.println(s);
            out.flush();
            System.out.println(s);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void closeTelnetSession()
    {
        write("quit");
    }



}
