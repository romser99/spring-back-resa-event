package fr.solutec.resaevents.dao;

import fr.solutec.resaevents.entites.Adresse;
import fr.solutec.resaevents.entites.Evenement;
import fr.solutec.resaevents.entites.Lieu;
import fr.solutec.resaevents.entites.Type;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EvenementDAO {

    Connection connection = null;

    public List<Evenement> readevt(int idevt) {
        List<Evenement> evenements = new ArrayList<>();
        try {
            String CONNECTION_URL = "jdbc:mysql://localhost/resaevents?user=root";
            connection = DriverManager.getConnection(CONNECTION_URL);

            String QUERY = "SELECT * FROM EVENEMENT";

            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Evenement evenement = new Evenement();

                evenement.setId(resultSet.getInt(1));
                evenement.setNom(resultSet.getString(2));
                evenement.setDescription(resultSet.getString(3));

                evenements.add(evenement);
            }
            connection.close();


        } catch (SQLException ex) {
            System.out.println("SQL Exception :" + ex.getMessage());
            System.out.println("SQL State :" + ex.getSQLState());
            System.out.println("VendorError :" + ex.getErrorCode());

            }
        return evenements;
        }



    public void create(Evenement evenement) {
        try {
            String CONNECTION_URL = "jdbc:mysql://localhost/resaevents?user=root";
            connection = DriverManager.getConnection(CONNECTION_URL);

            String QUERY = "INSERT INTO EVENEMENT(NOM, DECSRIPTION) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, evenement.getNom());
            preparedStatement.setString(2, evenement.getDescription());

            preparedStatement.execute();

            connection.close();

        } catch (SQLException ex) {
            System.out.println("SQL Exception :" + ex.getMessage());
            System.out.println("SQL State :" + ex.getSQLState());
            System.out.println("VendorError :" + ex.getErrorCode());

        }
    }


        public void update(int evenementid, int typeid) {
            try {
                String CONNECTION_URL = "jdbc:mysql://localhost/resaevents?user=root";
                connection = DriverManager.getConnection(CONNECTION_URL);

                String QUERY = "UPDATE EVENEMENT SET TYPE_ID = ? WHERE ID = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(QUERY);

                preparedStatement.setInt(1, typeid);
                preparedStatement.setInt(2, evenementid);

                preparedStatement.execute();


            } catch (SQLException ex) {
                System.out.println("SQL Exception :" + ex.getMessage());
                System.out.println("SQL State :" + ex.getSQLState());
                System.out.println("VendorError :" + ex.getErrorCode());

            }

        }

    public List<Evenement> read(int evenementid) {
        List<Evenement> evenements = new ArrayList<>();
        try {
            String CONNECTION_URL = "jdbc:mysql://localhost/resaevents?user=root";
            connection = DriverManager.getConnection(CONNECTION_URL);

            String QUERY = "SELECT * FROM EVENEMENT e JOIN TYPE t ON e.type_id = t.id WHERE e.id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);

            preparedStatement.setInt(1, evenementid);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Evenement evenement = new Evenement();
                Type type = new Type();

                type.setId(resultSet.getInt(4));
                type.setNom(resultSet.getString(5));

                evenement.setId(resultSet.getInt(1));
                evenement.setNom(resultSet.getString(2));
                evenement.setDescription(resultSet.getString(3));
                evenement.setType(type);

                evenements.add(evenement);
            }
            connection.close();

        } catch (SQLException ex) {
            System.out.println("SQL Exception :" + ex.getMessage());
            System.out.println("SQL State :" + ex.getSQLState());
            System.out.println("VendorError :" + ex.getErrorCode());

        }
        return evenements;
    }

    }


