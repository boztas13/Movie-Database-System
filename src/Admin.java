public class Admin extends Person{
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
        super.personType = "Admin";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String toString(){
        return super.toString()+";"+username+";"+password;
    }
    public static String tableColumns(){
        return "ID;name;surname;phone;birthdate;gender;username;password";
    }
}
