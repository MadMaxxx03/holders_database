package project.service;

import project.classes.HolderShort;
import project.classes.PassedTest;
import project.classes.PassedTestShort;

import java.util.List;

public interface PassedTestService extends GeneralService<PassedTest> {

    List<PassedTestShort> getPart();
}
