import java.util.ArrayList;

public class User extends Person{
    private String username;
    private String password;
    private ArrayList<Movie> towatchlist;
    private ArrayList<Movie> watchedlist;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.towatchlist = new ArrayList<>();
        this.watchedlist = new ArrayList<>();
        super.personType = "User";
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

    public ArrayList<Movie> getTowatchlist() {
        return towatchlist;
    }

    public void setTowatchlist(ArrayList<Movie> towatchlist) {
        this.towatchlist = towatchlist;
    }


    public ArrayList<Movie> getWatchedlist() {
        return watchedlist;
    }

    public void setWatchedlist(ArrayList<Movie> watchedlist) {
        this.watchedlist = watchedlist;
    }
    public void addToWatchList(Movie newMovie){
        towatchlist.add(newMovie);
    }
    public void addWatchedList(Movie watchedMovie){
        watchedlist.add(watchedMovie);
    }
    public String toString(){
        String str = super.toString()+";"+username+";"+password;
        str += ";{";
        for (Movie movie:
             towatchlist) {
            str += movie.getID()+",";
        }
        str += "#};";
        str += "{";
        for (Movie movie:
             watchedlist) {
            str += movie.getID()+",";
        }
        str += "#}";
        return str;
    }
    public static String tableColumns(){
        return "ID;name;surname;phone;birthdate;gender;username;password;towatchlist;watchedlist";
    }
}
