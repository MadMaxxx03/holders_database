package project.service;

import project.classes.Holder;
import project.classes.QuestionShort;
import project.classes.Test;
import project.classes.TestShort;

import java.util.List;

public interface TestService extends GeneralService<Test> {

    List<TestShort> getPart();
}
