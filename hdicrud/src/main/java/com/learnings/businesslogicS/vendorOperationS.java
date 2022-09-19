package com.learnings.businesslogicS;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

import com.learnings.entities.vendor;
import com.sap.db.jdbcext.wrapper.Connection;
import com.sap.db.jdbcext.wrapper.PreparedStatement;
import com.sap.db.jdbcext.wrapper.ResultSet;
import com.sap.db.jdbcext.wrapper.Statement;

import argo.jdom.*;
import argo.saj.InvalidSyntaxException;

@Component
public class vendorOperationS {
	
	
	public java.sql.Connection conn; //db connection
	public java.sql.Statement stmt;
	public java.sql.ResultSet rs;
	String url;
	String user;
	String password;

	
	@PostConstruct
	public void startConnection() {

		
		//we obtain the json string of VCAP_SERVICES
		String vcap_service = System.getenv("VCAP_SERVICES");
	    System.out.println(vcap_service);
	    
	    if(vcap_service != null && vcap_service.length() > 0) {
	    	
	    	try {
				JsonNode root = new JdomParser().parse(vcap_service);
				JsonNode serviceRoot = root.getNode("hanatrial");
				JsonNode cred = serviceRoot.getNode(0).getNode("credentials");
				
				this.url = cred.getStringValue("url");
				this.user = cred.getStringValue("user");
				this.password = cred.getStringValue("password");
				
			} catch (InvalidSyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("There is a problem in VCAP_SERVICE environment variable");
			}
	    	
	    	
	    	
	    	try {
				conn = DriverManager.getConnection(this.url, this.user, this.password);
				stmt = conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("DB Connection failed!!");
			}
	    	
	    }
	}
	
	// Method to get all data
	public List<vendor> getAllVendors(){
		List<vendor> vendorList = new ArrayList<vendor>();
		
		try {
			rs = stmt.executeQuery("SELECT top 100 * from VENDOR");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			while(rs.next()) {
				vendorList.add(new vendor(
						rs.getString("ID"),
						rs.getString("FIRSTNAME"),
						rs.getString("LASTNAME"),
						rs.getString("COMPANYNAME"),
						rs.getString("WEBSITE"),
						rs.getString("EMAIL"),
						rs.getString("VSTATUS"),
						rs.getString("GSTNUMBER")
						
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vendorList;
	}
	
	//Method for reading single record
	public vendor getSingleVendor(String id) throws SQLException {
		
		vendor vendorObj = new vendor();
		rs = stmt.executeQuery("SELECT * from VENDOR where id = " + id);
		
		while(rs.next()) {
			vendorObj.setId(rs.getString("ID"));
			vendorObj.setEmail("EMAIL");
			vendorObj.setCompanyName("COMPANYNAME");
			vendorObj.setFirstName("FIRSTNAME");
			vendorObj.setLastName("LASTNAME");
			vendorObj.setGstNumber("GSTNUMBER");
			vendorObj.setWebsite("WEBSITE");
			vendorObj.setVstatus("VSTATUS");
		}
		
		return vendorObj;
	}
	
	//Method for creating a record
	public vendor createVendor(vendor payload) throws SQLException {
		String lv_query = "INSERT INTO VENDOR (id, firstname, lastname, companyname, email, website, vstatus, gstnumber) VALUES('" + payload.getId() + "','" + payload.getFirstName() + "','" + payload.getLastName() + "','" + payload.getCompanyName() + "','" + payload.getEmail() + "','" + payload.getWebsite() + "','" + payload.getVstatus() + "','" + payload.getGstNumber() + "')";
		int row = stmt.executeUpdate(lv_query);
//		String lv_query="INSERT INTO VENDOR VALUES(?,?,?,?,?,?,'A',?)";
//	  PreparedStatement prpstmt =	(PreparedStatement) conn.prepareStatement(lv_query);
//	  
//	  prpstmt.setString(1, payload.getId());
//	  prpstmt.setString(2, payload.getFirstName());
//	  prpstmt.setString(3, payload.getLastName());
//	  prpstmt.setString(4, payload.getCompanyName());
//	  prpstmt.setString(5, payload.getWebsite());
//	  prpstmt.setString(6, payload.getEmail());
//	  prpstmt.setString(7, payload.getGstNumber());
//	  
//	  int row = prpstmt.executeUpdate();
	  return payload;
	}
	
	
	
	@PreDestroy
	public void endConnection() throws SQLException {
		
	    rs.close();		
		stmt.close();
		conn.close();
	}
}
