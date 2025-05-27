package com.database_replica.copy_of_database.postgres.repo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresqlRepo extends JpaRepository<com.database_replica.copy_of_database.postgres.entity.Users,Long> {
}
