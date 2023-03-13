package fr.solutec.resaevent.dao;

import fr.solutec.resaevent.entites.Adresse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdresseDAO {
    Connection connection = null;
    ///CREATE
    public void create(Adresse adresse) {

        ///INSERT DANS LA BDD
        try {
            //PROTOCOL//[HOSTS][/DATABASE][?PROPERTIES]
            String CONNECTION_URL = "jdbc:mysql://localhost:3306/resaevents?user=root&password=";

            connection = DriverManager.getConnection(CONNECTION_URL);
            // REQUETE
            String QUERY = "INSERT INTO ADRESSE( NUMERO, RUE, CODE_POSTAL, VILLE, REGION) VALUES (?, ?, ?, ?, ?)";
            //PREPARATION DE LA REQUETE
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            //DEFINTION DE LA VARIABLE
            preparedStatement.setInt(1, adresse.getNumero());
            preparedStatement.setString(2, adresse.getRue());
            preparedStatement.setInt(3, adresse.getCodePostal());
            preparedStatement.setString(4, adresse.getVille());
            preparedStatement.setString(5, adresse.getRegion());

            //EXECUTION DE LA REQUETE
            preparedStatement.execute();

            // DO SOMETHING W/ THE CONNECTION

        } catch (SQLException ex) {
            //HANDLE ANY ERRORS
            System.out.println("SQLException" + ex.getMessage());
            System.out.println("SQLState" + ex.getSQLState());
            System.out.println("VendorError" + ex.getErrorCode());
        }
    }
    public List<Adresse> read() {
        List<Adresse> adresses = new ArrayList<>();
        ///INSERT DANS LA BDD
        try {
            //PROTOCOL//[HOSTS][/DATABASE][?PROPERTIES]
            String CONNECTION_URL = "jdbc:mysql://localhost:3306/resaevents?user=root&password=";
            connection = DriverManager.getConnection(CONNECTION_URL);
            // REQUETE
            String QUERY = "SELECT * FROM ADRESSE";
            //PREPARATION DE LA REQUETE
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            //DEFINTION DE LA VARIABLE

            //EXECUTION DE LA REQUETE
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Adresse adresse = new Adresse();
                adresse.setId(resultSet.getInt(1));
                adresse.setNumero(resultSet.getInt(2));
                adresse.setRue(resultSet.getString(3));
                adresse.setCodePostal(resultSet.getInt(4));
                adresse.setVille(resultSet.getString(5));
                adresse.setRegion(resultSet.getString(6));
                adresses.add(adresse);
            }
            // DO SOMETHING W/ THE CONNECTION

            connection.close();

        } catch (SQLException ex) {
            //HANDLE ANY ERRORS
            System.out.println("SQLException" + ex.getMessage());
            System.out.println("SQLState" + ex.getSQLState());
            System.out.println("VendorError" + ex.getErrorCode());
        }
        return adresses;
    }
    public List<Adresse> getOne(int id) {
        List<Adresse> adresses = new ArrayList<>();
        ///INSERT DANS LA BDD
        try {
            //PROTOCOL//[HOSTS][/DATABASE][?PROPERTIES]
            String CONNECTION_URL = "jdbc:mysql://localhost:3306/resaevents?user=root&password=";
            connection = DriverManager.getConnection(CONNECTION_URL);
            // REQUETE
            String QUERY = "SELECT * FROM ADRESSE WHERE ID =?";
            //PREPARATION DE LA REQUETE
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            //DEFINTION DE LA VARIABLE
            preparedStatement.setInt(1, id);
            //EXECUTION DE LA REQUETE
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Adresse adresse = new Adresse();
                adresse.setId(resultSet.getInt(1));
                adresse.setNumero(resultSet.getInt(2));
                adresse.setRue(resultSet.getString(3));
                adresse.setCodePostal(resultSet.getInt(4));
                adresse.setVille(resultSet.getString(5));
                adresse.setRegion(resultSet.getString(6));
                adresses.add(adresse);
            }
            // DO SOMETHING W/ THE CONNECTION

            connection.close();

        } catch (SQLException ex) {
            //HANDLE ANY ERRORS
            System.out.println("SQLException" + ex.getMessage());
            System.out.println("SQLState" + ex.getSQLState());
            System.out.println("VendorError" + ex.getErrorCode());
        }
        return adresses;
    }

}