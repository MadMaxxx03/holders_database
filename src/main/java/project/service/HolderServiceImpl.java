package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.classes.Holder;
import project.classes.HolderShort;
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
    public List<HolderShort> getPart() {
        return holderRepository.getPart();
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
    public Holder getById(int id) {
        if (holderRepository.findById(id).isPresent()){
            return holderRepository.findById(id).get();
        }
        else{
            return null;
        }
    }

    @Override
    public boolean isObjPresent(Holder obj) {
        return holderRepository.findById(obj.gethId()).isPresent();
    }

    @Override
    public boolean isObjSame(Holder obj) {
        if (holderRepository.findById(obj.gethId()).isPresent()){
            Holder holder = holderRepository.findById(obj.gethId()).get();
            return (holder.getName().equals(obj.getName())
                    && holder.getPassword().equals(obj.getPassword()));
        }
        else{
            return false;
        }
    }
}
