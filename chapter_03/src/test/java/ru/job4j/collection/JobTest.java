package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void whenDescComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        List<Job> input = Arrays.asList(
                new Job("asd", 0),
                new Job("asd", 3),
                new Job("asd", 1)
        );
        Collections.sort(input, cmpNamePriority);
        List<Job> output = Arrays.asList(
                new Job("asd", 3),
                new Job("asd", 1),
                new Job("asd", 0)

        );
        assertThat(input, is(output));
    }

    @Test
    public void whenIncComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobIncByName().thenComparing(new JobIncByPriority());
        List<Job> input = Arrays.asList(
                new Job("asd", 1),
                new Job("asd", 2),
                new Job("asd", 3)
        );
        Collections.sort(input, cmpNamePriority);
        List<Job> output = Arrays.asList(
                new Job("asd", 1),
                new Job("asd", 2),
                new Job("asd", 3)
        );
        assertThat(input, is(output));
    }

    @Test
    public void incComparatorByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Bmpl task", 1),
                new Job("Aix bug", 0)
        );
        List<Job> expected = Arrays.asList(
                new Job("Aix bug", 0),
                new Job("Bmpl task", 1)
        );
        jobs.sort(new JobIncByName());
        assertEquals(expected, jobs);
    }

    @Test
    public void incComparatorByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Bmpl task", 1),
                new Job("Aix bug", 10),
                new Job("Danon", 0)
        );
        List<Job> expected = Arrays.asList(
                new Job("Danon", 0),
                new Job("Bmpl task", 1),
                new Job("Aix bug", 10)

        );
        jobs.sort(new JobIncByPriority());
        assertEquals(expected, jobs);
    }

    @Test
    public void descComparatorByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Aix bug", 0),
                new Job("Bmpl task", 1)

        );
        List<Job> expected = Arrays.asList(
                new Job("Bmpl task", 1),
                new Job("Aix bug", 0)

        );
        jobs.sort(new JobDescByName());
        assertEquals(expected, jobs);
    }

    @Test
    public void descComparatorByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Bmpl task", 1),
                new Job("Aix bug", 10),
                new Job("Danon", 0)
        );
        List<Job> expected = Arrays.asList(
                new Job("Aix bug", 10),
                new Job("Bmpl task", 1),
                new Job("Danon", 0)

        );
        jobs.sort(new JobDescByPriority());
        assertEquals(expected, jobs);
    }


}
