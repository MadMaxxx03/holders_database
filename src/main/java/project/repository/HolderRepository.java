package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.classes.Holder;

@Repository
public interface HolderRepository extends JpaRepository<Holder, Integer> {

}