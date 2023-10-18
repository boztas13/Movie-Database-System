import java.io.IOException;
import java.util.ArrayList;

public class MovieFactory {
    private ArrayList<Movie> movies;

    public MovieFactory() {
        this.movies = new ArrayList<>();
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }
    public Movie getMovie(int ID){
        for (Movie movie: movies) {
            if(movie.getID() == ID) return movie;
        }
        return null;
    }
    public ArrayList<Movie> searchMovies(String searchText){
        ArrayList<Movie> foundedMovies = new ArrayList<>();
        for (Movie movie:movies) {
            if(movie.getName().contains(searchText)
                    ||movie.getCategory().contains(searchText)
                    ||movie.getDescription().contains(searchText)){
                foundedMovies.add(movie);
            }
        }
        return foundedMovies;
    }
    public void addMovie(String name,int duration,String category,String releaseDate,String description){
        int ID = 0;
        if(movies.size()!=0){
            ID = movies.get(movies.size()-1).getID()+1;
        }
        Movie movie = new Movie(ID,name,duration,category,releaseDate,description);
        movies.add(movie);
    }

    public void deleteMovie(int ID){
        Movie movie = getMovie(ID);
        if(movie!=null){
            movies.remove(movie);
        }
    }
    public void updateMovie(int ID,String name,int duration,String category,Date releaseDate,String description) {
        Movie movie = getMovie(ID);
        if (movie != null) {
            movie.setName(name);
            movie.setDuration(duration);
            movie.setCategory(category);
            movie.setReleaseDate(releaseDate);
            movie.setDescription(description);
        }
    }
    public void backupDB() throws IOException {
        DB.saveToDB(movies,"MovieDB.txt", Movie.tableColumns());
    }
    public void readDB() throws IOException {
        ArrayList<String> data = DB.readDB("MovieDB.txt");
        for (String line:data) {

            String[] temp_data = line.split(";");
            addMovie(
                    temp_data[1],
                    Integer.valueOf(temp_data[3]),
                    temp_data[4],
                    temp_data[5],
                    temp_data[6]
            );
        }
    }

}
