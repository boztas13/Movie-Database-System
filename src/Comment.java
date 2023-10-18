public class Comment {
    private int ID;
    private User user;
    private Movie movie;
    private String comment;
    private Date date;

    public Comment(int ID, User user, Movie movie, String comment,Date date) {
        this.ID = ID;
        this.user = user;
        this.movie = movie;
        this.comment = comment;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public String toString(){
        return ID+";"+user.getUsername()+";"+movie.getID()+";"+comment+";"+date.toString();
    }
    public static String tableColumns(){
        return "ID;username;movieID;comment;date";
    }
}
