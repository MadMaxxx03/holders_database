package springApp.Service;

import springApp.Classes.Holder;
import springApp.Classes.PassedTest;
import springApp.Repository.HolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class HolderServiceImpl implements HolderService {

    @Autowired
    private HolderRepository holderRepository;

    @Override
    public Set<PassedTest> findPassedTestsByTId(int id) {
        return holderRepository.findPassedTestsByTId(id);
    }

    @Override
    public List<Holder> getAll() {
        return holderRepository.findAll();
    }
}
