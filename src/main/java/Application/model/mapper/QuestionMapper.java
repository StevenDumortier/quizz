package Application.model.mapper;

import Application.model.dto.QuestionDTO;
import Application.model.entity.Question;

public class QuestionMapper {

        public static QuestionDTO convertToDTO(Question question){
                QuestionDTO dto = new QuestionDTO();
                dto.setId(question.getId());
                dto.setAnswers(question.getAnswers());
                dto.setTitle(question.getTitle());
                return dto;
            }

        public static Question convertToQuestion(QuestionDTO questionDTO){

                Question question = new Question();

                question.setId(questionDTO.getId());
                question.setAnswers(questionDTO.getAnswers());
                question.setTitle(questionDTO.getTitle());
            return question;
            }


        }



