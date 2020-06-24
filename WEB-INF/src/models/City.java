
package models;
import java.sql.*;
public class City{
	private Integer cityId;
	private String cityName;

	public City(String cityName){
		this.cityName=cityName;
	}
	public City(Integer cityId){
		this.cityId=cityId;
	}
	public void setCityId(Integer cityId){
		this.cityId=cityId;
	}
	
	public Integer getCityId(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/minor?user=root&password=1234");
			String query = "select city_id from cities where city_name=?";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1,cityName);
			ResultSet rst=pst.executeQuery();
			while(rst.next()){
				cityId=rst.getInt(1);
			}
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return cityId;
	}

	public void setCityName(String cityname){
		this.cityName=cityName;
	}
	public String getCityName(){
			return cityName;
	}
	public Integer getRecord(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/minor?user=root&password=1234");
			String query = "select city_id from cities where city_name=?";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1,cityName);
			ResultSet rst=pst.executeQuery();
			while(rst.next()){
				cityId=rst.getInt(1);
			}
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return cityId;
	}


}