package springApp.Repository;

import springApp.Classes.Holder;
import springApp.Classes.PassedTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface HolderRepository extends JpaRepository<Holder, Integer>{

    @Query("select Holder.passedTests from Holder where Holder.hId =: id")
    Set<PassedTest> findPassedTestsByTId(int id);
}
