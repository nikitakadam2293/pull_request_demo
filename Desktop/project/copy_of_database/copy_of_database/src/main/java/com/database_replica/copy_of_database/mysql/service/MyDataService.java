package com.database_replica.copy_of_database.mysql.service;

import com.database_replica.copy_of_database.mysql.entity.Users;
import com.database_replica.copy_of_database.mysql.repo.MySqlRepo;
import com.database_replica.copy_of_database.postgres.repo.PostgresqlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyDataService {

    @Autowired
    private MySqlRepo mySqlRepo;

    @Autowired
    private PostgresqlRepo postgresqlRepo;


    public Users replicateUsers(Users users)
    {
        Users saveUser = mySqlRepo.save(users);

        com.database_replica.copy_of_database.postgres.entity.Users newPgUsers = new com.database_replica.copy_of_database.postgres.entity.Users();
     //   newPgUsers.setId(saveUser.getId());
        newPgUsers.setFirstName(saveUser.getFirstName());
        newPgUsers.setLastName(saveUser.getLastName());
        newPgUsers.setEmail(saveUser.getEmail());
        newPgUsers.setAbout(saveUser.getAbout());

        postgresqlRepo.save(newPgUsers);

        return saveUser;


    }

}
