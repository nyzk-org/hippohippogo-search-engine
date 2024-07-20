package com.project.hippohippogo.repositories;
import com.project.hippohippogo.entities.PageRank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRankRepository extends JpaRepository<PageRank, String> {

}
