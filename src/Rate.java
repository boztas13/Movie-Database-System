public class Rate {
    private int ID;
    private User user;
    private Movie movie;
    private int Rate;
    private Date date;

    public Rate(int ID, User user, Movie movie, int rate,Date date) {
        this.ID = ID;
        this.user = user;
        this.movie = movie;
        this.Rate = rate;
        this.date = date;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getRate() {
        return Rate;
    }

    public void setRate(int rate) {
        Rate = rate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public String toString(){
        return ID+";"+user.getUsername()+";"+movie.getID()+";"+Rate+";"+date.toString();
    }
    public static String tableColumns(){
        return "ID;username;movieID;rate;date";
    }
}
