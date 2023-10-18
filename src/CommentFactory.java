import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class CommentFactory {
    private Stack<Comment> comments;

    public CommentFactory(){
        comments = new Stack<>();
    }
    public void addComment(User user,Movie movie,String comment,String date){
        int ID = 0;
        if(comments.size()!=0){
            ID = comments.get(comments.size()-1).getID()+1;
        }

        String[] temp_date = date.split("-");
        Date ddate = new Date(Integer.valueOf(temp_date[2]),Integer.valueOf(temp_date[1]),Integer.valueOf(temp_date[0]));

        Comment newComment = new Comment(ID,user,movie,comment,ddate);
        if(!comments.contains(newComment)){
            comments.push(newComment);
        }
    }
    public void removeComment(int ID){
        Comment comment = getComment(ID);
        if(comment!=null) {
            comments.remove(comment);
        }
    }
    public void updateComment(int ID,String newComment){
        Comment comment = getComment(ID);
        if(comment!=null){
            comment.setComment(newComment);
        }
    }

    public Stack<Comment> getComments() {
        return comments;
    }

    public void setComments(Stack<Comment> comments) {
        this.comments = comments;
    }
    public Comment getComment(int ID){
        Stack tempStack = comments;
        Comment tempComment = (Comment) tempStack.pop();
        while(!tempStack.isEmpty()){

            if(tempComment.getID() == ID){
                return tempComment;
            }
            tempComment = (Comment) tempStack.pop();
        }
        return null;
    }
    public void backupDB() throws IOException {
        ArrayList<Rate> temp_comments = new ArrayList<>();
        Stack temp = comments;
        while(!temp.isEmpty()){
            temp_comments.add((Rate)temp.pop());
        }
        DB.saveToDB(temp_comments,"CommentDB.txt", Comment.tableColumns());
    }
    public void readDB() throws IOException {
        ArrayList<String> data = DB.readDB("MovieDB.txt");
        for (String line:data) {
            String[] temp_data = line.split(";");
            User user = MDBS.personFactory.getUser(temp_data[1]);
            Movie movie = MDBS.movieFactory.getMovie(Integer.valueOf(temp_data[2]));
            addComment(
                    user,
                    movie,
                    temp_data[3],
                    temp_data[4]
            );
        }
    }
}
