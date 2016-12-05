package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import org.apache.commons.lang3.RandomStringUtils;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.ContactDataGsonExclusionStrategy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by User on 21.11.2016.
 */
public class ContactDataGenerator {
    @Parameter(names="-c", description = "count of contacts to generate", required = true)
    public static int count;

    @Parameter(names="-f", description = "path to target file" , required = true)
    public static String pathTofile;

    @Parameter(names="-d", description = "Data format", required = true)
    public static String format;

    public static void main(String[] args) throws IOException {
        ContactDataGenerator g = new ContactDataGenerator();
        JCommander commander = new JCommander(g);
        try
        {
            commander.parse(args);
        }
        catch(ParameterException e)
        {
            System.out.println("Incorrect usage:");
            commander.usage();
            return;
        }
        g.run();
    }

    private static String getRndStringWithTS()
    {
        return RandomStringUtils.randomAlphabetic(5) + Long.toString(System.currentTimeMillis());
    }

    private static String getRndAlphaString()
    {
        Random rnd = new Random();
        return String.format("%010d",Math.abs(rnd.nextInt()) );
    }

    //TODO: actually randmoize contact creation
    public static ContactData getRandomValidContactData()
    {


        ContactData c = new ContactData()
                .withId(Integer.MAX_VALUE)
                .withAddress(getRndStringWithTS())
                .withAddress2(getRndStringWithTS())
                .withBirthday(new Date())
                .withCompany(getRndStringWithTS())
                .withEmail(getRndAlphaString() + "NET@RENCREDIT.INVALID")
                .withEmail2(getRndAlphaString() + "NET@RENCREDIT.INVALID")
                .withEmail3(getRndAlphaString() + "NET@RENCREDIT.INVALID")
                .withFax(getRndStringWithTS())
                .withFirstName(getRndStringWithTS())
                .withMiddleName(getRndStringWithTS())
                .withLastName(getRndStringWithTS())
                .withNickName(getRndStringWithTS())
                .withPhoneHome(getRndStringWithTS())
                .withPhoneMobile("+7" + getRndAlphaString())
                .withHomePage("vk.com")
                .withTitle("Sir")
                .withPhoneWork(getRndAlphaString())
                .withPhoneHome2(getRndStringWithTS())
                //.withGroup("test22")
                .withNotes(getRndStringWithTS())
                .withPhoto("src/test/resources/1464007636144622393.jpg");

        return c;
    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContacts(count);
        if(format.equals("csv"))
        {
            saveAsCsv(contacts, new File(getFileName()));
        }
        else if (format.equals("xml"))
        {
            saveAsXml(contacts, new File(getFileName()));
        }
        else if (format.equals("json"))
        {
            saveAsJson(contacts, new File(getFileName()));
        }
        else
        {
            System.out.println("Unrecognized format " + format);
        }
    }

    private String getFileName() {
        String fileName = "";
        fileName = appendPathIfNeeded();
        int i = 0;

        String fname = fileName + "contacts%d."+format;
        File file;
        if(! (file = new File(fileName + "contacts." + format)).exists() )
        {
            return fileName + "contacts." + format;
        }
        else
        {
            while((file = new File(String.format(fname,i))).exists())
            {
                 i++;
            }
            fileName = String.format(fname,i);
            System.out.println("file in target format already exists in target location.\nCreated file with name " + fileName);
            return fileName;
        }
    }

    private String appendPathIfNeeded() {
        String fileName;
        if(!(pathTofile.endsWith("\\") || pathTofile.endsWith("/")))
        {
            if(pathTofile.contains("\\"))
            {
                fileName = pathTofile + "\\";
            }
            else if(pathTofile.contains("/"))
            {
                fileName = pathTofile + "/";
            }
            else
            {
                fileName = pathTofile + "/";
            }

        }
        else
        {
            fileName=pathTofile;
        }
        return fileName;
    }

    private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().setExclusionStrategies(new ContactDataGsonExclusionStrategy(ContactData.class)).create();
        String json = gson.toJson(contacts);

        try(Writer writer = new FileWriter(file))        {
            writer.write(json);
        }

    }

    private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(ContactData.class);
        String xml = xstream.toXML(contacts);
        try(Writer writer = new FileWriter(file)) {
            writer.write(xml);
        }
    }


    private static void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
        try(Writer writer = new FileWriter(file)) {
            for (ContactData contact : contacts) {
                String s = getRandomValidContactData().toString()
                        .replaceAll(",", ";")
                        .replaceAll("\\w+=", "")
                        .replaceAll("ContactData\\{|'|\\}", "");
                writer.write(s + "\n");
            }
        }
    }

    private static List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        for(int i = 0;i < count; i++)
        {
            contacts.add(getRandomValidContactData());
        }
        return contacts;

    }

}
