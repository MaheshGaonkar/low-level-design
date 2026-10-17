package org.mahesh;

import org.mahesh.repo.impl.InMemoryExpenseRepository;
import org.mahesh.repo.impl.InMemoryGroupRepository;
import org.mahesh.repo.impl.InMemoryUserRepository;
import org.mahesh.services.ExpenseService;
import org.mahesh.services.GroupService;
import org.mahesh.services.UserService;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService(new InMemoryUserRepository());
        ExpenseService expenseService = new ExpenseService(new InMemoryExpenseRepository());
        GroupService groupService = new GroupService(new InMemoryGroupRepository());

        String personA = userService.createUser("Mahesh");
        String personB = userService.createUser("Roy");
        String personC = userService.createUser("Rohit");

        String groupA = groupService.create("Bangalore", userService.getUser(personA));
        groupService.addMember(groupA, userService.getUser(personB));
        groupService.addMember(groupA, userService.getUser(personC));

        //expenseService.create("", new BigDecimal(900), List.of(P))
    }
}