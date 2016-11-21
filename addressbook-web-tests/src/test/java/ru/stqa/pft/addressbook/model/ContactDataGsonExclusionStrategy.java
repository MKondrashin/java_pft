package ru.stqa.pft.addressbook.model;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Created by User on 21.11.2016.
 */
public class ContactDataGsonExclusionStrategy implements ExclusionStrategy {

    private Class classToExclude;

    public ContactDataGsonExclusionStrategy(Class classToExclude) {
        this.classToExclude = classToExclude;
    }

    // This method is called for all fields. if the method returns false the
    // field is excluded from serialization
    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        return f.getAnnotation(XStreamOmitField.class) != null;
    }

    // This method is called for all classes. If the method returns false the
    // class is excluded.
    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return clazz.getAnnotation(XStreamOmitField.class) !=null;
    }

}
