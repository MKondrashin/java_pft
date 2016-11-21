package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 19.11.2016.
 */
public class GroupDataGenerator {

    @Parameter(names="-c", description = "count of groups to generate")
    public static int count;

    @Parameter(names="-f", description = "path to target file")
    public static String pathTofile;

    @Parameter(names="-d", description = "Data format")
    public static String format;

    public static void main(String[] args) throws IOException {
        GroupDataGenerator g = new GroupDataGenerator();
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

    private void run() throws IOException {
        List<GroupData> groups = generateGroups(count);
        if(format.equals("csv"))
        {
            saveAsCsv(groups, new File(pathTofile));
        }
        else if (format.equals("xml"))
        {
            saveAsXml(groups, new File(pathTofile));
        }
        else if (format.equals("json"))
        {
            saveAsJson(groups, new File(pathTofile));
        }
        else
        {
            System.out.println("Unrecognized format " + format);
        }
    }

    private void saveAsJson(List<GroupData> groups, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(groups);
        try(Writer writer = new FileWriter(file)) {
            writer.write(json);
        }

    }

    private void saveAsXml(List<GroupData> groups, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(GroupData.class);
        String xml = xstream.toXML(groups);
        try(Writer writer = new FileWriter(file)) {
            writer.write(xml);
        }
    }


    private static void saveAsCsv(List<GroupData> groups, File file) throws IOException {
        try(Writer writer = new FileWriter(file)){
            for(GroupData group : groups)
            {
                writer.write(String.format("%s;%s;%s\n",group.getName(),group.getHeader(),group.getFooter()));
            }
        }
    }

    private static List<GroupData> generateGroups(int count) {
        List<GroupData> groups = new ArrayList<GroupData>();
        for(int i = 0;i < count; i++)
        {
            groups.add(new GroupData().withName(String.format("test %s", i))
            .withHeader(String.format("header %s",i))
            .withFooter(String.format("footer %s",i)));
        }
        return groups;

    }

}
