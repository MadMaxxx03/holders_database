package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.classes.Holder;
import project.repository.HolderRepository;

import java.util.List;

@Service
public class HolderServiceImpl implements HolderService {

    @Autowired
    private HolderRepository holderRepository;


    @Override
    public void save(Holder obj) {
        holderRepository.save(obj);
    }

    @Override
    public List<Holder> getAll() {
        return holderRepository.findAll();
    }

    @Override
    public void update(Holder obj) {
        holderRepository.save(obj);
    }

    @Override
    public void delete(Holder obj) {
        holderRepository.delete(obj);
    }

    @Override
    public boolean isObjPresent(Holder holder) {
        return holderRepository.findById(holder.gethId()).isPresent();
    }
}
