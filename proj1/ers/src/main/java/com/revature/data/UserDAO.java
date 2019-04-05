package com.revature.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.ReimbReq;
import com.revature.model.UserRoles;
import com.revature.model.Users;
import com.revature.util.ConnectionFactory;

public class UserDAO {
	
	public List<Users> getUsers(){
		List<Users> users = new ArrayList<Users>();
		try(Connection conn =  ConnectionFactory.getInstance().getConnection()){
			
			 String query = "SELECT ers_users.ers_users_id,ers_users.ers_username, ers_users.ers_password, ers_users.ers_fname,ers_users.ers_lname, ers_users.ers_email, ers_users.user_role_id, ers_user_roles.user_role" + 
			 		" FROM ers_users" + 
			 		" INNER JOIN ers_user_roles" + 
			 		" ON ers_users.user_role_id = ers_user_roles.ers_user_role_id";
		
			 //STATEMENT interface 
			 Statement statement = conn.createStatement();
			 
			 //RESULTSET interface - represents the set of results of a DB query
			 ResultSet rs = statement.executeQuery(query);
			 
			 while(rs.next()) {
				 Users _user = new Users(
						 rs.getInt("ERS_USERS_ID"),
						 rs.getString("ERS_USERNAME"),
						 rs.getString("ERS_PASSWORD"),
						 rs.getString("ERS_FNAME"),
						 rs.getString("ERS_LNAME"), 
						 rs.getString("ERS_EMAIL"),
						 new UserRoles(
					     rs.getInt("USER_ROLE_ID"),
						 rs.getString("USER_ROLE"))
						 );
				 				 
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	
	
	public Users getByUsername(String username) {
		Users u = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select ers_users.ers_users_id,ers_users.ers_username,ers_users.ers_password,ers_users.ers_fname,ers_users.ers_lname,ers_users.ers_email,r.ers_user_role_id \r\n" + 
					"from ers_users\r\n" + 
					"JOIN ers_user_roles r \r\n" + 
					"ON ers_users.user_role_id = r.ers_user_role_id  \r\n" + 
					"where LOWER(ers_users.ers_username) = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username.toLowerCase());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				u =  new Users(
						 rs.getInt("ERS_USERS_ID"),
						 rs.getString("ERS_USERNAME"),
						 rs.getString("ERS_PASSWORD"),
						 rs.getString("ERS_FNAME"),
						 rs.getString("ERS_LNAME"), 
						 rs.getString("ERS_EMAIL"),new UserRoles(rs.getInt("ers_user_role_id"),""));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	public List<ReimbReq> GetRequestsByUser(int UserID)
	{
		List<ReimbReq> _requests = new ArrayList<ReimbReq>();
		
		
		try(Connection conn =  ConnectionFactory.getInstance().getConnection()){
			
			 String query = "select reimb_id,reimb_amount,reimb_submitted,reimb_resolved,reimb_description,reimb_receipt,mg.ers_fname,st.reimb_status,ty.reimb_type\r\n" + 
			 		" FROM ERS_REIMBURSEMENT" + 
			 		" JOIN ers_users emp ON ers_reimbursement.reimb_author = emp.ers_users_id" + 
			 		" JOIN ers_users mg ON ers_reimbursement.reimb_resolver = mg.ers_users_id" + 
			 		" JOIN ers_reimbursement_status st ON ers_reimbursement.reimb_status_id = st.reimb_status_id" + 
			 		" JOIN ers_reimbursement_type ty ON ers_reimbursement.reimb_type_id = ty.reimb_type_id" + 
			 		" WHERE emp.ers_users_id = ? ";
		
			    PreparedStatement ps = conn.prepareStatement(query);
				ps.setInt(1, UserID);
				ResultSet rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 ReimbReq _req = new ReimbReq(
						 rs.getInt("REIMB_ID"),
						 rs.getDouble("REIMB_AMOUNT"),
						 rs.getString("REIMB_SUBMITTED"),
						 rs.getString("REIMB_RESOLVED"),
						 rs.getString("REIMB_DESCRIPTION"),null,
						 null,rs.getString("ERS_FNAME"),
						 rs.getString("REIMB_STATUS"),
						 rs.getString("REIMB_TYPE"),0,0,0,0
						 );
				 _requests.add(_req);
				 				 
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return _requests;	
	}
	
	
	public List<ReimbReq> GetRequestsByManager(int UserID)
	{
		List<ReimbReq> _requests = new ArrayList<ReimbReq>();
		
		
		try(Connection conn =  ConnectionFactory.getInstance().getConnection()){
			
			 String query = "select reimb_id,reimb_amount,reimb_submitted,reimb_resolved,reimb_description,reimb_receipt,emp.ers_fname,st.reimb_status,ty.reimb_type\r\n" + 
			 		" FROM ERS_REIMBURSEMENT" + 
			 		" JOIN ers_users emp ON ers_reimbursement.reimb_author = emp.ers_users_id" + 
			 		" JOIN ers_users mg ON ers_reimbursement.reimb_resolver = mg.ers_users_id" + 
			 		" JOIN ers_reimbursement_status st ON ers_reimbursement.reimb_status_id = st.reimb_status_id" + 
			 		" JOIN ers_reimbursement_type ty ON ers_reimbursement.reimb_type_id = ty.reimb_type_id" + 
			 		" WHERE mg.ers_users_id = ? ";
		
			    PreparedStatement ps = conn.prepareStatement(query);
				ps.setInt(1, UserID);
				ResultSet rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 ReimbReq _req = new ReimbReq(
						 rs.getInt("REIMB_ID"),
						 rs.getDouble("REIMB_AMOUNT"),
						 rs.getString("REIMB_SUBMITTED"),
						 rs.getString("REIMB_RESOLVED"),
						 rs.getString("REIMB_DESCRIPTION"),null,
						 rs.getString("ERS_FNAME"),null,
						 rs.getString("REIMB_STATUS"),
						 rs.getString("REIMB_TYPE"),0,0,0,0
						 );
				 _requests.add(_req);
				 				 
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return _requests;
	}
	
	
	//new code 4/1
	public void UpdateRequestByManager(int ReqID,int StatusID) 
	//public List<ReimbReq> UpdateRequestByManager1(String Status)
	{
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "UPDATE ers_reimbursement SET reimb_status_id = ?" + 
						"WHERE reimb_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,StatusID);
			ps.setInt(2, ReqID);
			ps.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int AddRequest(ReimbReq req)
	{
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "insert into ERS_REIMBURSEMENT(REIMB_SUBMITTED, REIMB_RESOLVED,REIMB_AMOUNT, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID) \r\n" + 
					"values(CURRENT_DATE, CURRENT_DATE,?, ?, ?,?,4,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1,req.getAmount());
			ps.setString(2,req.getDescription());
			ps.setInt(3, req.getAuthorID());
			ps.setInt(4, req.getResolverID());
			ps.setInt(5, req.getTypeID());
			ps.executeUpdate();
			return 0;
		
		} catch (SQLException e) {
			
			e.printStackTrace();
			return -1;
		}
		
		
	}
}

	 
	
	/*
	 * Prepared statement to execute UPDATE
	 */
	/*public Users addUser(Users u) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			//conn.setAutoCommit(); is set to true
			String sql = "insert into demo_user(username, password, bio) values(?, ?, ?)";
			String[] keyNames = {"U_ID"}; //allows us to specify col names of autogenerated fields to get back after update
			PreparedStatement ps = conn.prepareStatement(sql, keyNames);
			//ps.setString(1,  u.getUsername());
			//ps.setString(2, u.getPassword());
			
			int numRowsAffected = ps.executeUpdate();
			//could also just call ps.executeUpdate() without setting it equal to anything
			//but we want to see num rows affected
			System.out.println("ADDED " + numRowsAffected +  " USER(S) TO DB");
			
			if(numRowsAffected == 1) {
				ResultSet pk = ps.getGeneratedKeys();
				pk.next();
				//u.setId(pk.getInt(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	*/

