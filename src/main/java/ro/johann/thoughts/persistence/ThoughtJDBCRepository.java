package ro.johann.thoughts.persistence;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import ro.johann.thoughts.model.Thought;

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
                return Thought.builder()
                        .id(resultSet.getString(1))
                        .value(thought.getValue())
                        .language(thought.getLanguage())
                        .createdAt(thought.getCreatedAt())
                        .build();
            }
            return thought;
        } catch (SQLException exception) {
            log.error("sql exception on create thought.", exception);
            throw new RuntimeException(exception);
        }
    }

    @Override
    public Optional<Thought> get(String id) {
        log.info("get >> thought_id = {}", id);

        String query = "SELECT thought_id, thought_title FROM thought WHERE thought_id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setString(1, id.toString());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                log.info("resultSet >> {}", resultSet);
                Thought thought = Thought.builder()
                        .id(resultSet.getString(1))
                        .value(resultSet.getString(2))
                        .build();
                log.info("got thought {}", thought);
                return Optional.of(thought);
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
                thoughts.add(Thought.builder()
                        .id(resultSet.getString("thought_id"))
                        .value(resultSet.getString("value"))
                        .build());
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
