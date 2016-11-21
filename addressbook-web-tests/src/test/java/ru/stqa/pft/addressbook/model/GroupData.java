package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.util.IntSummaryStatistics;

@XStreamAlias("group")
public class GroupData {


    public int getId() {
        return id;
    }


    public GroupData withId(int id) {
        this.id = id;
        return this;
    }
    public GroupData withName(String name) {
        this.name = name;
        return this;
    }

    public GroupData withHeader(String header) {
        this.header = header;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        if (id != groupData.id) return false;
        return name != null ? name.equals(groupData.name) : groupData.name == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public GroupData withFooter(String footer) {
        this.footer = footer;
        return this;

    }

    @XStreamOmitField
    private int id = Integer.MAX_VALUE;

    @Expose
    private String name;

    @Expose
    private String header;

    @Expose
    private String footer;

//    public GroupData(int id, String name, String header, String footer) {
//        this.id = id;
//        this.name = name;
//        this.header = header;
//        this.footer = footer;
//    }
//
//    public GroupData( String name, String header, String footer) {
//        this.id = Integer.MAX_VALUE;
//        this.name = name;
//        this.header = header;
//        this.footer = footer;
//    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }


    @Override
    public String toString() {
        return "GroupData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


}
