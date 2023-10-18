public class Login {
    static String currentUser;
    static String currentUserType;
    public static boolean register(String name,String surname,String username,String phone,String birthdate,String password,char gender){
        User user = MDBS.personFactory.addUser(name,surname,phone,birthdate,gender,username,password);
        if(user != null){
            System.out.println("Successfully register!!!");
            return true;
        }
        else{
            System.out.println("User has been registered!!!");
            return false;
        }
    }
    public static boolean login(String username,String password){
        Admin admin = MDBS.personFactory.getAdmin(username);
        User user = MDBS.personFactory.getUser(username);
        if(admin != null && admin.getPassword().equals(password)){
            currentUser = username;
            currentUserType = "Admin";
            return true;
        }
        else if(user != null && user.getPassword().equals(password)){
            currentUser = username;
            currentUserType = "User";
            return true;
        }
        else if(admin == null && user == null){
            System.out.println("User not found please register!!!!");
            return false;
        }
        else{
            System.out.println("Password is not corret!!!!");
            return false;
        }
    }
    public static boolean logout(){
        currentUser="";
        currentUserType="";
        return true;
    }
}
