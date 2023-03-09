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

            String QUERY = "INSERT INTO LIEU(NOM, ) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, lieu.getNom());

            preparedStatement.execute();

        }
    }

    public List<Lieu> read() {
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
        }
        return lieux;
    }



    public void update(Lieu lieu, Adresse adresse) {
        String CONNECTION_URL = "jdbc:mysql://localhost/resaevents?user=root";
        connection = DriverManager.getConnection(CONNECTION_URL);

        String QUERY = "UPDATE";
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);

        preparedStatement.setInt();

        preparedStatement.execute();


    }

}
