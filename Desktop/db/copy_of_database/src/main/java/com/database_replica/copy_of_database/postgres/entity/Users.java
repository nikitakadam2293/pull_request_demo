package com.database_replica.copy_of_database.postgres.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @NotBlank(message = "firstName not be blank")
    @Length(min = 4, max = 50, message = "name between 4 to 50")
    private String firstName;

    @NotBlank(message = "lastName not be blank")
    @Length(min = 4, max = 50, message = "name between 4 to 50")
    private String lastName;

    @Email
    private String email;

    @NotBlank(message = "about not be blank")
    @Length(min = 4, max = 100, message = "name between 4 to 100")
    private  String about;




/*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;

    private String lastName;

    private String email;

    private  String about;*/

}
