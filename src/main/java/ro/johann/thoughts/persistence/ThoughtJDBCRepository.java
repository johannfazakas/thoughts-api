package ro.johann.thoughts.persistence;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ro.johann.thoughts.model.Thought;

import javax.annotation.PostConstruct;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class ThoughtJDBCRepository implements ThoughtRepository {

//    @PostConstruct
    public void init() throws SQLException {
        log.info("init >>");
        String query = "DROP TABLE IF EXISTS thought; " +
                "CREATE TABLE thought (thought_id INT NOT NULL AUTO_INCREMENT, thought_title VARCHAR(255), PRIMARY KEY (thought_id))";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.execute();
        }
    }

    @Override
    public Thought create(Thought thought) {
        log.info("create >> thought = {}", thought);

        String query = "INSERT INTO THOUGHT (thought_title) VALUES (?)";
        try (PreparedStatement statement = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, thought.getValue());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                return new Thought(resultSet.getLong(1), thought.getValue());
            }
            return thought;
        } catch (SQLException exception) {
            log.error("sql exception on create thought.", exception);
            throw new RuntimeException(exception);
        }
    }

    @Override
    public Optional<Thought> get(Long id) {
        log.info("get >> thought_id = {}", id);

        String query = "SELECT thought_id, thought_title FROM thought WHERE thought_id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                log.info("resultSet >> {}", resultSet);
                Thought value = new Thought(
                        resultSet.getLong(1),
                        resultSet.getString(2)
                );
                log.info("got thought {}", value);
                return Optional.of(value);
            }
            return Optional.empty();
        } catch (SQLException exception) {
            log.info("sql exception on get thought.", exception);
            throw new RuntimeException(exception);
        }
    }

    public List<Thought> list() {
        log.info("list >>");

        String query = "SELECT thought_id, thought_title FROM thought";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            List<Thought> thoughts = new ArrayList<>();
            while (resultSet.next()) {
                thoughts.add(new Thought(
                    resultSet.getLong("thought_id"),
                    resultSet.getString("thought_title")
                ));
            }
            return thoughts;
        } catch (SQLException exception) {
            log.info("sql exception on list thoughts.", exception);
            throw new RuntimeException(exception);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:~/thoughtsDB");
    }

}
