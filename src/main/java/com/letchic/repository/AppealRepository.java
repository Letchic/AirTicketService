package com.letchic.repository;
import com.letchic.model.Appeal;
import com.letchic.views.AppealView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppealRepository  extends JpaRepository<Appeal, Integer> {
    List<Appeal> findAll();

    String queryFindAppeals = "SELECT * FROM appeal JOIN users ON userid = passenger_id;";
    @Query(value = queryFindAppeals, nativeQuery = true)
    List<AppealView> findAppeals();
}

