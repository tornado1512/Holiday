package models;

import java.sql.*;
public class RestFood{
	private Integer restFoodId;
	private RestCategory restCategoryId;
	private Food foodId;
	private Integer foodPrice;

	public RestFood(RestCategory restCategoryId, Food foodId, Integer foodPrice){
		this.restCategoryId=restCategoryId;
		this.foodId=foodId;
		this.foodPrice=foodPrice;
	}

	public boolean saveFood(){
		boolean flag=false;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/minor?user=root&password=1234");
			String query="insert into rest_foods (rest_category_id,food_id,food_price) value (?,?,?)";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1,restCategoryId.getRestCategoryId());
			pst.setInt(2,foodId.getFoodId());
			pst.setInt(3,foodPrice);
			int i=pst.executeUpdate();
			if(i==1){
				flag=true;
			}
		}
		catch (ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return flag;
	}
	/*public static ArrayList<RestFood> getFoods(){
	
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minor?user=root&password=1234");
			String query="select * from rest_foods where rest_category_id=?";
			PreparedStatement pst=con.prepareStatement(query);
			pst.executeQuery();

		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
	} */
	public void setRestFoodId( Integer restFoodId){
			this.restFoodId=restFoodId;
	}
	public Integer getRestFoodId(){
		return restFoodId;
	}

	public void setRestCategoryId( RestCategory restCategoryId){
			this.restCategoryId=restCategoryId;
	}
	public RestCategory getRestCategoryId(){
		return restCategoryId;
	}

	public void setFoodId( Food foodId){
			this.foodId=foodId;
	}
	public Food getFoodId(){
		return foodId;
	}

	public void setFoodPrice( Integer foodPrice){
			this.foodPrice=foodPrice;
	}
	public Integer getFoodPrice(){
		return foodPrice;
	}

}