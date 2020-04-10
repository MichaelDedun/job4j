package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            if (!users.get(user).contains(account)) {
                users.get(user).add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findAny()
                .orElse(null);
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account account = null;
        if (users.containsKey(user)) {
            account = users.get(user)
                    .stream()
                    .filter(Objects::nonNull)
                    .filter(acc -> acc.getRequisite().equals(requisite))
                    .findAny()
                    .orElse(null);
        }
        return account;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        if (users.containsKey(findByPassport(srcPassport)) && users.containsKey(findByPassport(destPassport))) {
            Account srcAcc = findByRequisite(srcPassport, srcRequisite);
            Account destAcc = findByRequisite(destPassport, destRequisite);
            if (srcAcc.getBalance() >= amount) {
                destAcc.setBalance(destAcc.getBalance() + amount);
                rsl = true;
            }
        }
        return rsl;
    }

}
