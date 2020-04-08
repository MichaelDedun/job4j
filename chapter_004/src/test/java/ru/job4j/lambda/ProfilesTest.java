package ru.job4j.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ProfilesTest {

    @Test
    public void testProfileGetAddress() {
        Profiles profiles = new Profiles();
        List<Profile> profilesList = Arrays.asList(
                new Profile(new Address("Omsk", "ordzhonikidze", 83, 70)),
                new Profile(new Address("Moscow", "pobeda", 74, 28))
        );
        List<Address> result = profiles.collect(profilesList);
        List<Address> expected = Arrays.asList(
                new Address("Omsk", "ordzhonikidze", 83, 70),
                new Address("Moscow", "pobeda", 74, 28)
        );
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testProfileSortedAndHaveUniq() {
        Profiles profiles = new Profiles();
        List<Profile> profilesList = Arrays.asList(
                new Profile(new Address("Omsk", "ordzhonikidze", 83, 70)),
                new Profile(new Address("Omsk", "ordzhonikidze", 83, 70)),
                new Profile(new Address("Moscow", "pobeda", 74, 28))
        );
        List<Address> result = profiles.collect(profilesList);
        List<Address> expected = Arrays.asList(
                new Address("Moscow", "pobeda", 74, 28),
                new Address("Omsk", "ordzhonikidze", 83, 70)

        );
        Assert.assertEquals(result, expected);
    }

}
