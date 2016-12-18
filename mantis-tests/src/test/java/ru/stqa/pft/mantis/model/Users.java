package ru.stqa.pft.mantis.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by UserData on 13.11.2016.
 */
public class Users extends ForwardingSet<UserData> {

    private Set<UserData> delegate;

    public Users()
    {
        this.delegate = new HashSet<UserData>();
    }

    public Users(Users c)
    {
        this.delegate = new HashSet<UserData>(c.delegate());
    }

    public Users(Collection<UserData> contacts) {
        this.delegate = new HashSet<UserData>(contacts);
    }

    @Override
    protected Set<UserData> delegate() {
        return delegate;
    }

    public Users withAdded(UserData contact)
    {
        Users c = new Users(this);
        c.add(contact);
        return c;
    }

    public Users without(UserData contact)
    {
        Users c = new Users(this);
        c.remove(contact);
        return c;
    }

}
