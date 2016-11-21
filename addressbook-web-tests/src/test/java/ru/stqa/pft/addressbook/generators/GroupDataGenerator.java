package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
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



        File file = new File(pathTofile);
        List<GroupData> groups = generateGroups(count);
        save(groups,file);
    }

    private static void save(List<GroupData> groups, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for(GroupData group : groups)
        {
            writer.write(String.format("%s;%s;%s\n",group.getName(),group.getHeader(),group.getFooter()));
        }
        writer.close();
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
