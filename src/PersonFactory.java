import java.io.IOException;
import java.util.ArrayList;

public class PersonFactory{
    private ArrayList<Admin> admins;
    private ArrayList<User> users;
    private ArrayList<Actor> actors;
    private ArrayList<Director> directors;

    public PersonFactory() {
        this.admins = new ArrayList<>();
        this.users = new ArrayList<>();
        this.actors = new ArrayList<>();
        this.directors = new ArrayList<>();
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(ArrayList<Admin> admins) {
        this.admins = admins;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    public ArrayList<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(ArrayList<Director> directors) {
        this.directors = directors;
    }
    public Admin getAdmin(String username){
        for (Admin admin: admins) {
            if(admin.getUsername().equals(username)){
                return admin;
            }
        }
        return null;
    }
    public User getUser(String username){
        for (User user: users) {
            if(user.getUsername().equals(username)) return user;
        }
        return null;
    }
    public Actor getActor(int ID){
        for (Actor actor: actors) {
            if(actor.getID() == ID) return actor;
        }
        return null;
    }
    public Director getDirector(int ID){
        for (Director director: directors) {
            if(director.getID() == ID) return director;
        }
        return null;
    }
    public void removeAdmin(String username){
        for (Admin admin: admins) {
            if(admin.getUsername().equals(username)){
                admins.remove(admin);
                break;
            }
        }
    }
    public void removeUser(String username){
        for (User user: users) {
            if(user.getUsername().equals(username)) {
                users.remove(user);
                break;
            }
        }
    }
    public void removeActor(int ID){
        for (Actor actor: actors) {
            if(actor.getID() == ID)
            {
                actors.remove(actor);
                break;
            }
        }
    }
    public void removeDirector(int ID){
        for (Director director: directors) {

            if(director.getID() == ID){
                directors.remove(director);
                break;
            }
        }
    }
    public void addAdmin(String name, String surname,String phone, String birthDate, char gender,String username,String password){
        if(getAdmin(username)==null){
            int ID = 0;
            if(admins.size()!=0){
                ID = admins.get(admins.size()-1).getID()+1;
            }
            String[] temp_date = birthDate.split("-");
            Date date = new Date(Integer.valueOf(temp_date[2]),Integer.valueOf(temp_date[1]),Integer.valueOf(temp_date[0]));

            Admin admin = new Admin(username,password);
            admin.setID(ID);
            admin.setName(name);
            admin.setSurname(surname);
            admin.setBirthDate(date);
            admin.setGender(gender);
            admin.setPhone(phone);
            if(getUser(username) != null){
                removeUser(username);
            }
            admins.add(admin);
        }
    }

    public void updateAdmin(String username, String password, String name, String surname, Date birthDate, char gender, String phone){
        Admin admin = getAdmin(username);
        if(admin != null){
            admin.setPassword(password);
            admin.setName(name);
            admin.setSurname(surname);
            admin.setBirthDate(birthDate);
            admin.setGender(gender);
            admin.setPhone(phone);
        }
    }
    public User addUser(String name, String surname,String phone, String birthDate, char gender,String username,String password){
        if(getAdmin(username)==null && getUser(username)==null){
            int ID = 0;
            if(users.size()!=0){
                ID = users.get(users.size()-1).getID()+1;
            }
            String[] temp_date = birthDate.split("-");
            Date date = new Date(Integer.valueOf(temp_date[2]),Integer.valueOf(temp_date[1]),Integer.valueOf(temp_date[0]));

            User user = new User(username,password);
            user.setID(ID);
            user.setName(name);
            user.setSurname(surname);
            user.setBirthDate(date);
            user.setGender(gender);
            user.setPhone(phone);
            users.add(user);
            return user;
        }
        return null;
    }
    public void updateUser(String username,String password,String name,String surname,Date birthDate,char gender,String phone){
        User user = getUser(username);
        if(user != null){
            user.setPassword(password);
            user.setName(name);
            user.setSurname(surname);
            user.setBirthDate(birthDate);
            user.setGender(gender);
            user.setPhone(phone);
        }
    }

    public Actor addActor(String name, String surname,String phone, String birthDate, char gender){
        int ID = 0;
        if(actors.size()!=0){
            ID = actors.get(actors.size()-1).getID()+1;
        }
        String[] temp_date = birthDate.split("-");
        Date date = new Date(Integer.valueOf(temp_date[2]),Integer.valueOf(temp_date[1]),Integer.valueOf(temp_date[0]));

        Actor actor = new Actor();
        actor.setID(ID);
        actor.setName(name);
        actor.setSurname(surname);
        actor.setBirthDate(date);
        actor.setGender(gender);
        actor.setPhone(phone);
        actors.add(actor);
        return actor;
    }
    public void updateActor(int ID,String name,String surname,Date birthDate,char gender,String phone){
        Actor actor = getActor(ID);
        actor.setName(name);
        actor.setSurname(surname);
        actor.setBirthDate(birthDate);
        actor.setGender(gender);
        actor.setPhone(phone);
    }
    public Director addDirector(String name, String surname,String phone, String birthDate, char gender){
        int ID = 0;
        if(directors.size()!=0){
            ID = directors.get(directors.size()-1).getID()+1;
        }
        String[] temp_date = birthDate.split("-");
        Date date = new Date(Integer.valueOf(temp_date[2]),Integer.valueOf(temp_date[1]),Integer.valueOf(temp_date[0]));

        Director director = new Director();
        director.setID(ID);
        director.setName(name);
        director.setSurname(surname);
        director.setBirthDate(date);
        director.setGender(gender);
        director.setPhone(phone);
        directors.add(director);
        return director;
    }
    public void updateDirector(int ID,String name,String surname,Date birthDate,char gender,String phone){
        Director director =getDirector(ID);
        director.setName(name);
        director.setSurname(surname);
        director.setBirthDate(birthDate);
        director.setGender(gender);
        director.setPhone(phone);
    }
    public void backupDB() throws IOException {
        DB.saveToDB(admins,"AdminDB.txt", Admin.tableColumns());
        DB.saveToDB(users,"UserDB.txt", User.tableColumns());
        DB.saveToDB(actors,"ActorDB.txt", Actor.tableColumns());
        DB.saveToDB(directors,"DirectorDB.txt", Director.tableColumns());
    }
    public void readDB() throws IOException {
        ArrayList<String> data = DB.readDB("AdminDB.txt");
        for (String line:data) {
            String[] temp_data = line.split(";");
            addAdmin(
                    temp_data[1],
                    temp_data[2],
                    temp_data[3],
                    temp_data[4],
                    temp_data[5].charAt(0),
                    temp_data[6],
                    temp_data[7]
            );
        }
        data = DB.readDB("UserDB.txt");
        for (String line:data) {
            String[] temp_data = line.split(";");
            User user = addUser(
                    temp_data[1],
                    temp_data[2],
                    temp_data[3],
                    temp_data[4],
                    temp_data[5].charAt(0),
                    temp_data[6],
                    temp_data[7]
            );
            temp_data[8] = temp_data[8].replace("{","");
            temp_data[8] = temp_data[8].replace("}","");
            String[] id_list = temp_data[8].split(",");
            for (int i = 0; i < id_list.length-1; i++) {
                user.addToWatchList(MDBS.movieFactory.getMovie(Integer.valueOf(id_list[i])));
            }
            temp_data[9] = temp_data[9].replace("{","");
            temp_data[9] = temp_data[9].replace("}","");
            id_list = temp_data[9].split(",");
            for (int i = 0; i < id_list.length-1; i++) {
                user.addWatchedList(MDBS.movieFactory.getMovie(Integer.valueOf(id_list[i])));
            }
        }
        data = DB.readDB("ActorDB.txt");
        for (String line:data) {
            String[] temp_data = line.split(";");
            Actor actor = addActor(
                    temp_data[1],
                    temp_data[2],
                    temp_data[3],
                    temp_data[4],
                    temp_data[5].charAt(0)
            );
            temp_data[6] = temp_data[6].replace("{","");
            temp_data[6] = temp_data[6].replace("}","");
            String[] id_list = temp_data[6].split(",");
            for (int i = 0; i < id_list.length-1; i++) {
                actor.addMovie(MDBS.movieFactory.getMovie(Integer.valueOf(id_list[i])));
            }
        }
        data = DB.readDB("DirectorDB.txt");
        for (String line:data) {
            String[] temp_data = line.split(";");
            Director director = addDirector(
                    temp_data[1],
                    temp_data[2],
                    temp_data[3],
                    temp_data[4],
                    temp_data[5].charAt(0)
            );
            temp_data[6] = temp_data[6].replace("{","");
            temp_data[6] = temp_data[6].replace("}","");
            String[] id_list = temp_data[6].split(",");
            for (int i = 0; i < id_list.length-1; i++) {
                director.addMovie(MDBS.movieFactory.getMovie(Integer.valueOf(id_list[i])));
            }
        }
    }

}
