package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Faculty;
import utils.MySqlConexion;

public class FacultyDaoImpl implements FacultyDao {

    @Override
    public List<Faculty> populateFacultySelect() {
        List<Faculty> facultyList = new ArrayList<>();
        
        String sql = """
            SELECT FacultyID, FacultyName
            FROM Faculties
        """;
        
        try (Connection cn = MySqlConexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
             
            while (rs.next()) {
                Faculty faculty = new Faculty();
                faculty.setFacultyId(rs.getString("FacultyID"));
                faculty.setFacultyName(rs.getString("FacultyName"));
                facultyList.add(faculty);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return facultyList;
    }
}
