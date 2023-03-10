package fr.solutec.resaevents.dao;

import fr.solutec.resaevents.entites.Evenement;
import fr.solutec.resaevents.entites.Type;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TypeDAO {
    Connection connection = null;
    public List<Type> read(int idtype) {
        List<Type> types = new ArrayList<>();
        try {
            String CONNECTION_URL = "jdbc:mysql://localhost/resaevents?user=root";
            connection = DriverManager.getConnection(CONNECTION_URL);

            String QUERY = "SELECT * FROM TYPE";

            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Type type = new Type();

                type.setId(resultSet.getInt(1));
                type.setNom(resultSet.getString(2));

                types.add(type);
            }
            connection.close();


        } catch (SQLException ex) {
            System.out.println("SQL Exception :" + ex.getMessage());
            System.out.println("SQL State :" + ex.getSQLState());
            System.out.println("VendorError :" + ex.getErrorCode());

        }
        return types;
    }

    public void create(Type type) {
        try {
            String CONNECTION_URL = "jdbc:mysql://localhost/resaevents?user=root";
            connection = DriverManager.getConnection(CONNECTION_URL);

            String QUERY = "INSERT INTO TYPE(NOM) VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, type.getNom());

            preparedStatement.execute();

            connection.close();

        } catch (SQLException ex) {
            System.out.println("SQL Exception :" + ex.getMessage());
            System.out.println("SQL State :" + ex.getSQLState());
            System.out.println("VendorError :" + ex.getErrorCode());

        }
    }
}
