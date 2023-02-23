package Application.model.mapper;

import Application.model.entity.Answer;
import Application.model.dto.AnswerDto;
import org.mapstruct.factory.Mappers;
import java.util.ArrayList;
import java.util.List;
public interface AnswerMapper {

//    AnswerMapper INSTANCE = Mappers.getMapper( AnswerMapper.class );
//    AnswerDto ToDto(Answer answer);
//    Answer ToEntity(AnswerDto answerDto);
//    List<AnswerDto> ToDtos(List<Answer> answers);
//    List<Answer> ToEntities(List<AnswerDto> answerDtos);
//}
    public static List<AnswerDto> convertToDTO(List<Answer> answers){

        List<AnswerDto> dtos = new ArrayList<>();
         for(Answer answer : answers){
             AnswerDto dto = new AnswerDto();
             dto.setCorrectAnswer(answer.isCorrectAnswer());
             dto.setQuestion(answer.getQuestion());
             dto.setId(answer.getId());
             dto.setTitle(answer.getTitle());
             dtos.add(dto);
         }
        return dtos;
    }
    public static List<Answer> convertToAnswer(List<AnswerDto> dtos){

        List<Answer> answers = new ArrayList<>();
        for(AnswerDto dto : dtos) {
            Answer answer = new Answer();
            answer.setQuestion(dto.getQuestion());
            answer.setCorrectAnswer(dto.isCorrectAnswer());
            answer.setTitle(dto.getTitle());
            answer.setId(dto.getId());
            answers.add(answer);
        }
        return answers;
    }
}
