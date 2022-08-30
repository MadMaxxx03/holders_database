package project.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.classes.Holder;
import project.classes.HolderShort;

import java.util.List;

@Repository
public interface HolderRepository extends JpaRepository<Holder, Integer> {

    //@Query("SELECT hId, name, password, role from Holder")
    //List<HolderShort> getPart();

    @Query(value = "select new project.classes.HolderShort(hId, name, password, role) from Holder")
    List<HolderShort> getPart();
}


