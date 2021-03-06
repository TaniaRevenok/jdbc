package dataLayer;

import model.dao.ProjectsDao;
import ua.config.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class ProjectsRepository implements Repository<ProjectsDao> {

    private final DatabaseManager connector;
    private static final String FIND_BY_ID = "SELECT FROM projects p WHERE p.id = ? ; ";
    private static final String INSERT = "INSERT INTO projects (id, project_name, project_start_date, cost) VALUES (?, ?, ?, ?)";
    private static final String DELETE_BY_ID = "DELETE FROM projects WHERE id = ?";
    private static final String UPDATE = "UPDATE projects SET project_name = ? , project_start_date = ? , cost = ? , WHERE id = ?";

    public ProjectsRepository(DatabaseManager connector) {this.connector = connector; }




    @Override
    public ProjectsDao findById(Integer id) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToProjectsDao(resultSet).orElseThrow(() -> new IllegalArgumentException((String.format("Project with id %d not found", id))));
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }
    @Override
    public void create(ProjectsDao projectsDao) {
      try {
          ProjectsDao exist = findById(projectsDao.getProjectId());
          System.out.println(String.format("Project with %d already exist", exist.getProjectId()));
      }catch (IllegalArgumentException e) {
          try(Connection connection = connector.getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
              preparedStatement.setInt(1, projectsDao.getProjectId());
              preparedStatement.setString(2, projectsDao.getProjectName());
              preparedStatement.setDate(3, projectsDao.getProjectStartDate());
              preparedStatement.setInt(4, projectsDao.getCost());
              preparedStatement.execute();

          }
          catch (SQLException eq)       {
              eq.printStackTrace();
          }
      }
    }

    @Override
    public void delete(ProjectsDao projectsDao) {
        findById(projectsDao.getProjectId());
        try(Connection connection = connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)){
            preparedStatement.setInt(1, projectsDao.getProjectId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int update(ProjectsDao projectsDao) {
        int rowsUpdated = 0;
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, projectsDao.getProjectName());
            preparedStatement.setDate(2, projectsDao.getProjectStartDate());
            preparedStatement.setInt(3, projectsDao.getCost());
            preparedStatement.setInt(4, projectsDao.getProjectId());
            rowsUpdated = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsUpdated;
    }

private Optional<ProjectsDao>  mapToProjectsDao(ResultSet resultSet) throws SQLException {
    ProjectsDao projectsDao = null;
    while (resultSet.next()) {
        projectsDao.setProjectId(resultSet.getInt("id"));
        projectsDao.setProjectName(resultSet.getString("project_id"));
        projectsDao.setProjectStartDate(resultSet.getDate("project_start_date"));
        projectsDao.setCost(resultSet.getInt("cost"));
    }
    return Optional.ofNullable(projectsDao);

    }
}
