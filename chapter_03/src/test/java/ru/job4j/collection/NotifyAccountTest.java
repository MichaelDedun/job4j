package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NotifyAccountTest {

    @Test
    public void sent() {
        List<Account> accounts = new ArrayList<>(
                List.of(
                        new Account("123", "Petr Arsentev", "eDer3432f"),
                        new Account("142", "Petr Arsentev", "000001"),
                        new Account("123", "Petr Arsentev", "eDer3432f")
                )
        );

        HashSet<Account> expect = new HashSet<>(
                Set.of(
                        new Account("123", "Petr Arsentev", "eDer3432f"),
                        new Account("142", "Petr Arsentev", "000001")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }

    @Test
    public void withThreeDuplicate() {
        List<Account> accounts = new ArrayList<>(
                List.of(
                        new Account("142", "Petr Arsentev", "000001"),
                        new Account("142", "Petr Arsentev", "000001"),
                        new Account("142", "Petr Arsentev", "000001")
                )
        );

        HashSet<Account> expect = new HashSet<>(
                Set.of(
                        new Account("142", "Petr Arsentev", "000001"))
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }

}
