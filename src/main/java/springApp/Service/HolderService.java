package springApp.Service;

import springApp.Classes.Holder;
import springApp.Classes.PassedTest;

import java.util.List;
import java.util.Set;

public interface HolderService{

    Set<PassedTest> findPassedTestsByTId(int id);

    List<Holder> getAll();

}
