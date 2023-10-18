import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
public class Register {
    private String name;
    private String surname;
    private String username;
    private char gender;
    private String phone;
    private String password;
    private boolean isAdmin;
    PersonFactory pf = new PersonFactory();

    public Register(String name, String surname, String username, char gender, String phone, String password, boolean isAdmin) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.gender = gender;
        this.phone = phone;
        this.password = password;
        this.isAdmin = isAdmin;
        PersonFactory pf = MDBS.personFactory;

        Scanner scan = new Scanner("users.txt");
        String[] attributes;
        while(scan.hasNext()){
            String line = scan.nextLine();
            attributes=line.split(",");
            //pf.addUser(Integer.parseInt(attributes[0]),attributes[1],attributes[2],attributes[3],attributes[4].charAt(0),attributes[5]);
        }

        String userData[][]= new String[1000][7];



        try {
            BufferedWriter writer =new BufferedWriter((new FileWriter("users.txt")));
            writer.write("aS");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }




}
