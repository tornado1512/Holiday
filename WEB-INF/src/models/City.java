
package models;
import java.sql.*;
import java.util.*;
public class City{
	private Integer cityId;
	private String cityName;
	
	public City(){

	}
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

	/*public static String getDetails(int cityId){
		String details = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minor?user=root&password=1234");
			
			String query = "select details from cities where city_id=?";

			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1,cityId);

			ResultSet rst = pst.executeQuery();

			if(rst.next()){
				details = rst.getString(1);
			}

			con.close();
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}

		return details;
	}*/

	public static ArrayList<City> collectCities(String ct){
					ArrayList<City> cities = new ArrayList<City>();
					try{
							Class.forName("com.mysql.jdbc.Driver");

							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minor?user=root&password=1234");

							String query = "select city_id,city_name from cities where city like '"+ct+"%'";

							PreparedStatement pst = con.prepareStatement(query);

							ResultSet rs = pst.executeQuery();

							while(rs.next()){
									City city = new City();
									city.cityId = rs.getInt(1);
									city.cityName = rs.getString(2);

									cities.add(city);
							}
							con.close();
					}catch(ClassNotFoundException | SQLException e){
								e.printStackTrace();
					}
					return cities;
			}



}