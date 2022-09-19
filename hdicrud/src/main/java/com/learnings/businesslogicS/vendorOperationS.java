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
						rs.getString("COMPANY"),
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
	
	@PreDestroy
	public void endConnection() throws SQLException {
		
	    rs.close();		
		stmt.close();
		conn.close();
	}
}
