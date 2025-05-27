package com.database_replica.copy_of_database.mysql.repo;


import com.database_replica.copy_of_database.mysql.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MySqlRepo extends JpaRepository<Users,Long>{


}
