package models;

import java.sql.*;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.jasypt.util.text.StrongTextEncryptor;

public class RegisterOwner{
	private Integer ownerId;
	private String ownerName;
	private String email;
	private String password;

	public RegisterOwner(){
	
	}	
	public RegisterOwner(String ownerName,String email,String password){
		this.ownerName=ownerName;
		this.email=email;
		this.password=password;
	}
	public RegisterOwner(String email){
		this.email=email;
	}
	public RegisterOwner(String email,String password){
		this.email=email;
		this.password=password;
	}
	public void setOwnerId(Integer ownerId){
			this.ownerId=ownerId;
	}
	public Integer getOwnerId(){
			try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/minor?user=root&password=1234");
					String query="select owner_id from owners where email=? ";
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1,email);
					ResultSet rs = pst.executeQuery();
					rs.next();
					ownerId = rs.getInt(1);
					con.close();
			}catch(ClassNotFoundException | SQLException e){
					e.printStackTrace();
			}
			return ownerId;

	}

	public void setOwnerName(String ownerName){
			this. ownerName= ownerName;
	}
	public String getOwnerName(){
		try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/minor?user=root&password=1234");
				String query="select owner_name from owners where email=? ";
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(1,email);
				ResultSet rs = pst.executeQuery();
				rs.next();
				ownerName = rs.getString(1);
				con.close();
			}catch(ClassNotFoundException | SQLException e){
					e.printStackTrace();
			}
			return  ownerName;
	}

	public void setEmail(String email){
			this.email=email;
	}
	public String getEmail(){
			return email;
	}

	public void setPassword(String password){
			this.password=password;
	}
	public String getPassword(){
		
		try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/minor?user=root&password=1234");
				String query="select password from owners where email=? ";
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(1,email);
				ResultSet rs = pst.executeQuery();
				if(rs.next()){
					password = rs.getString(1);
					StrongTextEncryptor ste=new StrongTextEncryptor();
					ste.setPassword(password);
					password=ste.decrypt(password);
					con.close();
					return password;
				}else{
					return "noemail";		
				}
				
			}catch(ClassNotFoundException | SQLException e){
					e.printStackTrace();
			}		
			return "noemail";
		
	}


	/// Register function
	public boolean saveRecord(){
		boolean flag=false;
		try{

			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/minor?user=root&password=1234");
			String query="insert into owners (owner_name,email,password) value(?,?,?)";
			PreparedStatement pst=con.prepareStatement(query);
			StrongPasswordEncryptor spe=new StrongPasswordEncryptor();
			String enpass=spe.encryptPassword(password);
			pst.setString(1,ownerName); 
			pst.setString(2,email); 
			pst.setString(3,enpass); 
			//System.out.println(ownerName+email+password);
			int i=pst.executeUpdate();
			//System.out.println(i+"=i");
			if(i==1){
				flag=true;
			}
			con.close();
		}
		catch (ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return flag;
	} 


	///Login function
	public boolean checkLogin(){
		boolean flag=false;
		try{

			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/minor?user=root&password=1234");
			String query="select password from owners where email=?";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1,email);
			ResultSet rst=pst.executeQuery();
			System.out.println(email);
			StrongPasswordEncryptor spe=new StrongPasswordEncryptor();
			if(rst.next()){
				flag=spe.checkPassword(password,rst.getString(1));
				System.out.println(flag);
			}
			con.close();
		}
		catch (ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return flag;
	}
}