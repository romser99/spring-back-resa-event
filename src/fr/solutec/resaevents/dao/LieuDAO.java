package fr.solutec.resaevents.dao;

import fr.solutec.resaevents.entites.Adresse;
import fr.solutec.resaevents.entites.Lieu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LieuDAO {

    Connection connection = null;

    public void create(Lieu lieu) {
        try {
            String CONNECTION_URL = "jdbc:mysql://localhost/resaevents?user=root";
            connection = DriverManager.getConnection(CONNECTION_URL);

            String QUERY = "INSERT INTO LIEU(NOM) VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, lieu.getNom());

            preparedStatement.execute();

            connection.close();

        } catch (SQLException ex) {
            System.out.println("SQL Exception :" + ex.getMessage());
            System.out.println("SQL State :" + ex.getSQLState());
            System.out.println("VendorError :" + ex.getErrorCode());

        }
    }

    public List<Lieu> readlieu() {
        List<Lieu> lieux = new ArrayList<>();
        try {
            String CONNECTION_URL = "jdbc:mysql://localhost/resaevents?user=root";
            connection = DriverManager.getConnection(CONNECTION_URL);

            String QUERY = "SELECT * FROM LIEU";

            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Lieu lieu = new Lieu();

                lieu.setId(resultSet.getInt(1));
                lieu.setNom(resultSet.getString(2));

                lieux.add(lieu);
            }
            connection.close();
        } catch (SQLException ex) {
            System.out.println("SQL Exception :" + ex.getMessage());
            System.out.println("SQL State :" + ex.getSQLState());
            System.out.println("VendorError :" + ex.getErrorCode());

        }
        return lieux;
    }
    public List<Lieu> read(int lieuid) {
        List<Lieu> lieux = new ArrayList<>();
        try {
            String CONNECTION_URL = "jdbc:mysql://localhost/resaevents?user=root";
            connection = DriverManager.getConnection(CONNECTION_URL);

            String QUERY = "SELECT * FROM LIEU l JOIN ADRESSE a ON l.adresse_id = a.id WHERE l.id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);

            preparedStatement.setInt(1, lieuid);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Lieu lieu = new Lieu();
                Adresse adresse = new Adresse();

                adresse.setId(resultSet.getInt(4));
                adresse.setNumero(resultSet.getInt(5));
                adresse.setRue(resultSet.getString(6));
                adresse.setCodePostal(resultSet.getInt(7));
                adresse.setVille(resultSet.getString(8));
                adresse.setRegion(resultSet.getString(9));
                adresse.setPays(resultSet.getString(10));

                lieu.setId(resultSet.getInt(1));
                lieu.setNom(resultSet.getString(2));
                lieu.setAdresse(adresse);

                lieux.add(lieu);
            }
            connection.close();
        } catch (SQLException ex) {
            System.out.println("SQL Exception :" + ex.getMessage());
            System.out.println("SQL State :" + ex.getSQLState());
            System.out.println("VendorError :" + ex.getErrorCode());

        }
        return lieux;
    }


    public void update(int lieuid, int adresseid) {
        try {
            String CONNECTION_URL = "jdbc:mysql://localhost/resaevents?user=root";
            connection = DriverManager.getConnection(CONNECTION_URL);

            String QUERY = "UPDATE LIEU SET ADRESSE_ID = ? WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);

            preparedStatement.setInt(1, adresseid);
            preparedStatement.setInt(2, lieuid);

            preparedStatement.execute();


        } catch (SQLException ex) {
            System.out.println("SQL Exception :" + ex.getMessage());
            System.out.println("SQL State :" + ex.getSQLState());
            System.out.println("VendorError :" + ex.getErrorCode());

        }

    }
}
