package com.scaler.taskservices.repositories;

import com.scaler.taskservices.models.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Override
    Optional<Task> findById(Long id);
//    List<Task> findByName(String word);
    @Override
    Page<Task> findAll(Pageable pageable);

    //select * from task where price > ?


    List<Task> findByTitleLikeIgnoreCase(String word); // case insensitive.

    List<Task> findTop5ByTitleContains(String word);
    //select * from task where title like '' LIMIT 5

//    List<Task> findTopByTitleContains(int top, String word);



    List<Task> findTasksByTitleContainsOrderById(String word);


}


