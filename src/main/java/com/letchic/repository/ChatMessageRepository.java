package com.letchic.repository;

import com.letchic.model.ChatMessage;
import com.letchic.views.ChatMessageView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Integer> {

    String queryFindAllChatMessage = "SELECT messageid, useridfrom, useridto, message, date, \n" +
            "(f.lastname || ' ' || f.firstname || ' ' || f.middlename) AS userfiofrom, \n" +
            "(t.lastname || ' ' || t.firstname || ' ' || t.middlename) AS userfioto \n" +
            "FROM chatmessage \n" +
            "JOIN users f ON useridfrom = f.passenger_id \n" +
            "JOIN users t ON useridto = t.passenger_id;";
    @Query(value = queryFindAllChatMessage, nativeQuery = true)
    List<ChatMessageView> findAllMessage();

    String queryFindChatMessage = "SELECT messageid, useridfrom, useridto, message, date, \n" +
            "(f.lastname || ' ' || f.firstname || ' ' || f.middlename) AS userfiofrom, \n" +
            "(t.lastname || ' ' || t.firstname || ' ' || t.middlename) AS userfioto \n" +
            "FROM chatmessage \n" +
            "JOIN users f ON useridfrom = f.passenger_id \n" +
            "JOIN users t ON useridto = t.passenger_id \n"+
            "WHERE useridfrom = :userid OR useridto = :userid \n"+
            "ORDER BY messageid";
    @Query(value = queryFindChatMessage, nativeQuery = true)
    List<ChatMessageView> findMessages(@Param("userid") long userid);

    ChatMessage save(ChatMessage chatMessage);
}
