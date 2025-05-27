package com.database_replica.copy_of_database.mysql.controller;


import com.database_replica.copy_of_database.mysql.entity.Users;
import com.database_replica.copy_of_database.mysql.service.MyDataService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mysql/users")

public class MySqlController {

    @Autowired
    private MyDataService myDataService;

    @PostMapping("/save")
    public Users saveUsers(@Valid @RequestBody Users users)
    {
        return myDataService.replicateUsers(users);
    }
}
