package project.service;

import project.classes.HolderShort;
import project.classes.Question;
import project.classes.QuestionShort;

import java.util.List;

public interface QuestionService extends GeneralService<Question> {

    List<QuestionShort> getPart();
}
