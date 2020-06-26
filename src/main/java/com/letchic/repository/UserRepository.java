package com.letchic.repository;

import com.letchic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmailAndPassword(String email, String password);

    User findByEmail(String email);


    String queryFindUsers = "SELECT DISTINCT passenger_id, email, firstname, lastname, \n" +
            "middlename, nationality, placeofbirth, gender, password, dateofbirth, phone, passport\n" +
            "FROM users JOIN chatmessage\n" +
            "ON passenger_id = useridfrom\n" +
            "WHERE useridfrom != '700000000'";
    @Query(value = queryFindUsers, nativeQuery = true)
    List<User> getUserWithMessage();

    User save(User user);
}
