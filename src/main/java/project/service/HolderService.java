package project.service;

import project.classes.Holder;
import project.classes.HolderShort;

import java.util.List;

public interface HolderService extends GeneralService<Holder> {

    List<HolderShort> getPart();
}
