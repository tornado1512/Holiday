package models;
import java.sql.*;
import org.jasypt.util.password.StrongPasswordEncryptor;
public class User{
	private Integer userId;
	private String userName;
	private String email;
	private String password;
	
	
	public User(){
	
	}	
	public User(String userName,String email,String password){
		this.userName=userName;
		this.email=email;
		this.password=password;
	}
	public User(Integer userId,String userName,String email,String password){
		this.userName=userName;
		this.email=email;
		this.password=password;
		this.userId=userId;
	}
	public User(String email,String password){
		this.email=email;
		this.password=password;
	}
	public boolean checkLogin(){
		boolean flag=false;
		try{

			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/minor?user=root&password=1234");
			String query="select password from users where email=?";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1,email);
			ResultSet rst=pst.executeQuery();
			StrongPasswordEncryptor spe=new StrongPasswordEncryptor();
			if(rst.next()){
				flag=spe.checkPassword(password,rst.getString(1));
				
			}
			con.close();
		}
		catch (ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return flag;
	} 
	public boolean saveRecord(){
		boolean flag=false;
		try{

			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/minor?user=root&password=1234");
			String query="insert into users (user_name,email,password) value(?,?,?)";
			PreparedStatement pst=con.prepareStatement(query);
			StrongPasswordEncryptor spe=new StrongPasswordEncryptor();
			String spass=spe.encryptPassword(password);
			pst.setString(1,userName); 
			pst.setString(2,email); 
			pst.setString(3,spass); 
			int i=pst.executeUpdate();
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
		public void setUserId(Integer userId){
		this.userId=userId;
	} 
	public Integer getUserId(){
		return userId;
	}
	
	public void setUserName(String userName){
		this.userName=userName;
	} 
	public String getUserName(){
		return userName;
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
		return password;
	}
}