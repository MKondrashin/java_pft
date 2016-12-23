package ru.sftqa.pft.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by User on 23.12.2016.
 */
public class GithubTests {

    @Test
    public void testCommits() throws IOException {
        Github github = new RtGithub("694a6c6d876be9ca9e17f9cbdcf367efd67cffe1");
        RepoCommits commits = github.repos().get(new Coordinates.Simple("mkondrashin", "java_pft")).commits();
        for(RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String,String>().build())){
            System.out.println(new RepoCommit.Smart(commit).message());
        }
    }
}
