import java.util.*;

public class Actor extends Person{
    private Stack<Movie> movies;

    public Actor() {

        this.movies = new Stack<>();
        super.personType = "Actor";
    }

    public Stack<Movie> getMovies() {
        return movies;
    }
    public void setMovies(Stack<Movie> movies) {
        this.movies = movies;
    }

    public void addMovie(Movie newMovie){
        if(!movies.contains(newMovie))
            movies.push(newMovie);
    }
    public String toString(){
        String str = super.toString();
        str += ";{";
        Stack<Movie> temp = new Stack();
        while(!movies.isEmpty()){
            Movie movie =  (Movie) movies.peek();
            str += movie.getID()+",";
            temp.push(movies.pop());
        }
        while (!temp.isEmpty()){
            movies.push(temp.pop());
        }
        str += "#}";
        return str;
    }
    public static String tableColumns(){
        return "ID;name;surname;phone;birthdate;gender;movies";
    }

}
