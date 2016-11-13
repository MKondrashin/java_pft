package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by User on 13.11.2016.
 */
public class Collections {
    public static void main(String[] args)
    {
        String[] langs = {"Java",        "C#",        "Python",        "PHP"};

        List<String> languages = Arrays.asList("Java",        "C#",        "Python",        "PHP");


        for(String l : languages)
        {
            System.out.println("i want to learn " + l);
        }

    }



}
