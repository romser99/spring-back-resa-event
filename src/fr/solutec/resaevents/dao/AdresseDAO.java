package fr.solutec.resaevents.dao;

import fr.solutec.resaevents.entites.Adresse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdresseDAO {

    Connection connection = null;

    // create
    public void create(Adresse adresse) throws SQLException {

        try {
            // insert bdd
            String CONNECTION_URL = "jdbc:mysql://localhost/resaevents?user=root";
            connection = DriverManager.getConnection(CONNECTION_URL);

            String QUERY = "INSERT INTO ADRESSE(NUMERO, RUE, CODE_POSTAL, VILLE, REGION, PAYS) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setInt(1, adresse.getNumero());
            preparedStatement.setString(2, adresse.getRue());
            preparedStatement.setInt(3, adresse.getCodePostal());
            preparedStatement.setString(4, adresse.getVille());
            preparedStatement.setString(5, adresse.getRegion());
            preparedStatement.setString(6, adresse.getPays());

            preparedStatement.execute();

        } catch (SQLException ex) {
            System.out.println("SQL Exception :" + ex.getMessage());
            System.out.println("SQL State :" + ex.getSQLState());
            System.out.println("VendorError :" + ex.getErrorCode());
        }
    }


// lecture
    public List<Adresse> read() {
        List<Adresse> adresses = new ArrayList<>();
        try {
            String CONNECTION_URL = "jdbc:mysql://localhost/resaevents?user=root";
            connection = DriverManager.getConnection(CONNECTION_URL);

            String QUERY = "SELECT * FROM ADRESSE";

            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Adresse adresse = new Adresse();
                adresse.setId(resultSet.getInt(1));
                adresse.setNumero(resultSet.getInt(2));
                adresse.setRue(resultSet.getString(3));
                adresse.setCodePostal(resultSet.getInt(4));
                adresse.setVille(resultSet.getString(5));
                adresse.setRegion(resultSet.getString(6));
                adresse.setPays(resultSet.getString(7));

                adresses.add(adresse);
            }
            connection.close();

        } catch (SQLException ex) {
            System.out.println("SQL Exception :" + ex.getMessage());
            System.out.println("SQL State :" + ex.getSQLState());
            System.out.println("VendorError :" + ex.getErrorCode());

        }
        return adresses;
    }


        // update

        // delete

}
