package com.example.rest.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.rest.model.Campaign;

@Repository
public class CampaignDao {
	
	private static final String CREATE_CLIENT_QUERY = "INSERT INTO test.campaign(name, status, type, description, startdate, enddate) VALUES(?, ?, ?, ?, ?, ?);";
	private static final String DELETE_CLIENT_QUERY = "DELETE FROM test.campaign WHERE id=?;";
	private static final String FIND_CLIENT_QUERY = "SELECT id, name, status, type, description, startdate, enddate FROM test.campaign WHERE id=?;";
	private static final String FIND_CLIENTS_QUERY = "SELECT id, name, status, type, description, startdate, enddate FROM test.campaign";
	
	/**
	 * 
	 * @return 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws DaoException 
	 */
	public List<Campaign> findAll() throws ClassNotFoundException, SQLException {
		List<Campaign> result = new ArrayList<>();
		Connection connection = com.example.rest.persistence.ConnectionManager.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(FIND_CLIENTS_QUERY);
			
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()){
			Campaign campaign = new Campaign();
			campaign.setId(resultSet.getInt("id"));
			campaign.setName(resultSet.getString("name"));
			campaign.setType(resultSet.getString("type"));
			campaign.setStatus(resultSet.getString("status"));
			campaign.setDescription(resultSet.getString("description"));
			campaign.setStartDate(resultSet.getDate("startdate"));
			campaign.setEndDate(resultSet.getDate("enddate"));
			result.add(campaign);
		}
		resultSet.close();
		preparedStatement.close();
		connection.close();
		return result;
	}

    	/**
	 * 
	 * @return 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws DaoException 
	 */
	public Campaign findById(int id) throws ClassNotFoundException, SQLException {
		Campaign result = null;
		Connection connection = com.example.rest.persistence.ConnectionManager.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(FIND_CLIENT_QUERY);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()){
			result = new Campaign();
			result.setId(resultSet.getInt("id"));
			result.setName(resultSet.getString("name"));
			result.setType(resultSet.getString("type"));
			result.setStatus(resultSet.getString("status"));
			result.setDescription(resultSet.getString("description"));
			result.setStartDate(resultSet.getDate("startdate"));
			result.setEndDate(resultSet.getDate("enddate"));
		}
		resultSet.close();
		preparedStatement.close();
		connection.close();
		return result;
	}

    public Campaign create(Campaign campaign) throws ClassNotFoundException, SQLException {
        Connection connection = com.example.rest.persistence.ConnectionManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(CREATE_CLIENT_QUERY);
        preparedStatement.setString(1, campaign.getName());
        preparedStatement.setString(2, campaign.getStatus());
        preparedStatement.setString(3, campaign.getType());
        preparedStatement.setString(4, campaign.getDescription());
        if (campaign.getStartDate() != null) {
            preparedStatement.setDate(5, new Date(campaign.getStartDate().getTime()));
        } else {
            preparedStatement.setDate(5, null);
        }
        if (campaign.getEndDate() != null) {
            preparedStatement.setDate(6, new Date(campaign.getEndDate().getTime()));
        } else {
            preparedStatement.setDate(6, null);
        }
        preparedStatement.executeUpdate();
        return campaign;
    }
 
    public Campaign deleteCampaignById(int id) throws ClassNotFoundException, SQLException {
        Connection connection = com.example.rest.persistence.ConnectionManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CLIENT_QUERY);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        return null;
    }

}
