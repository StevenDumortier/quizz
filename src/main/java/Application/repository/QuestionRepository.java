package Application.repository;

import Application.model.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Query(value = "SELECT * FROM questions ORDER BY RAND() LIMIT 1", nativeQuery = true)
    public Question findRandom();

    @Query(value = "SELECT * FROM questions ORDER BY RAND() LIMIT 5", nativeQuery = true)
    public List<Question> findListRandom();

}
