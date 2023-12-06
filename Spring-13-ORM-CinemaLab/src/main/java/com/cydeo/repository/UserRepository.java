package com.cydeo.repository;


import com.cydeo.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserAccount, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a user with an email?
    UserAccount findByEmail(String email);

    //Write a derived query to read a user with an username?
    UserAccount findByUsername(String username);

    //Write a derived query to list all users that contain a specific name?
    List<UserAccount> findByUsernameContains(String username);

    //Write a derived query to list all users that contain a specific name in the ignore case mode?

    List<UserAccount> findByUsernameContainsIgnoreCase(String username);

    //Write a derived query to list all users with an age greater than a specified age?

    List<UserAccount> findByAccountDetail_AgeGreaterThan(int age);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns a user read by email?
    @Query("select u from UserAccount u where u.email=?1")
    UserAccount getByEmail(String email);

    //Write a JPQL query that returns a user read by username?
    @Query("select u from UserAccount u where u.username=?1")
    UserAccount getByUsername(String username);
    //Write a JPQL query that returns all users?
    @Query("select u from UserAccount u")
    List<UserAccount> getAllUsers();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns all users that contain a specific name?
    @Query(value = "select u from UserAccount u where u.username like '%?1%'",nativeQuery = true)
    List<UserAccount> getAllUsersContainsUserName(String pattern);

    //Write a native query that returns all users?

    @Query(value = "select u from UserAccount u",nativeQuery = true)
    List<UserAccount> readAllUsers();
    //Write a native query that returns all users in the range of ages?
    @Query(value = "select u from UserAccount u where u.accountDetail.age between :age1 and :age2",nativeQuery = true)
    List<UserAccount> readAllAgeBetween(@Param("age1") int age1,@Param("age2") int age2);
    //Write a native query to read a user by email?
    @Query(value = "select u from UserAccount u where u.email=:email",nativeQuery = true)
    List<UserAccount> readAllByEmail(@Param("email") String email);

}
