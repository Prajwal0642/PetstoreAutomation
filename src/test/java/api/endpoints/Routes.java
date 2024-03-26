package api.endpoints;

/*Swagger url: https://petstore.swagger.io/
 
create user : https://petstore.swagger.io/v2/user
get user : https://petstore.swagger.io/v2/user/{username}
update : https://petstore.swagger.io/v2/user/{username}
delete: https://petstore.swagger.io/v2/user/{username}

*/


public class Routes {
	
	public static String base_url="https://petstore.swagger.io/v2";
	
	
	//User module
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String update_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";

	
	//store modules
	  //here ypu will create store module URL's
	
	//pET MODULE
	  //here ypu will create PET module URL's
	
	
	
	
}
