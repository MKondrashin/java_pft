package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by User on 13.11.2016.
 */
public class Contacts extends ForwardingSet<ContactData> {

    private Set<ContactData> delegate;

    public Contacts()
    {
        this.delegate = new HashSet<ContactData>();
    }

    public Contacts(Contacts c)
    {
        this.delegate = new HashSet<ContactData>(c.delegate());
    }

    public Contacts(Collection<ContactData> contacts) {
        this.delegate = new HashSet<ContactData>(contacts);
    }

    @Override
    protected Set<ContactData> delegate() {
        return delegate;
    }

    public Contacts withAdded(ContactData contact)
    {
        Contacts c = new Contacts(this);
        c.add(contact);
        return c;
    }

    public Contacts without(ContactData contact)
    {
        Contacts c = new Contacts(this);
        c.remove(contact);
        return c;
    }

}
