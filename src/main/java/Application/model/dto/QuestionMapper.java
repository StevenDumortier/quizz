package Application.model.dto;

import Application.model.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    List<Question> mapToQuestions(List<QuestionDto> questionDtos);

    Question mapToQuestion(QuestionDto questionDto);

    List<QuestionDto> mapToQuestionDtos(List<Question> question);

    Question mapToQuestionDto(Question question);

//        public static QuestionDto convertToDTO(Question question){
//                QuestionDto dto = new QuestionDto();
//                dto.setId(question.getId());
//                dto.setAnswers(question.getAnswers());
//                dto.setTitle(question.getTitle());
//                return dto;
//            }
//
//        public static Question convertToQuestion(QuestionDto questionDTO){
//
//                Question question = new Question();
//
//                question.setId(questionDTO.getId());
//                question.setAnswers(questionDTO.getAnswers());
//                question.setTitle(questionDTO.getTitle());
//            return question;
//            }


}



