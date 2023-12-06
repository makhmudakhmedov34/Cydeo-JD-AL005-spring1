package com.cydeo.repository;


import com.cydeo.enums.Role;
import com.cydeo.model.AccountDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountDetail, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to list all accounts with a specific country or state
    List<AccountDetail> findByCountryOrState(String country, String state);

    //Write a derived query to list all accounts with age lower than or equal to a specific value
    List<AccountDetail> findByAgeLessThanEqual(int age);

    //Write a derived query to list all accounts with a specific role
    List<AccountDetail> findByRole(String role);
    //Write a derived query to list all accounts between a range of ages
    List<AccountDetail> findByAgeBetween(int age1,int age2);
    //Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<AccountDetail> findByAddressContains(String pattern);
    //Write a derived query to sort the list of accounts with age
    List<AccountDetail> findByAgeOrderByAgeAsc(int age);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts
    @Query("select a from AccountDetail a")
    List<AccountDetail> findAllAccounts();

    //Write a JPQL query to list all admin accounts
    @Query("select a from AccountDetail a where a.role=?1")
    List<AccountDetail> findAccountsByRole(Role role);

    //Write a JPQL query to sort all accounts with age
    @Query("select a from AccountDetail a group by a.age")
    List<AccountDetail> findAllAccountsByAgeSortedAsc();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value
    @Query(value = "select a from AccountDetail a where a.age> :age",nativeQuery = true)
    List<AccountDetail> findAccountsByAgeLowerThan(@Param("age") int age);

    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city

//    List<AccountDetail> 
    //Write a native query to read all accounts with an age lower than a specific value

}
