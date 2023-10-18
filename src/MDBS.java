import java.io.IOException;

public class MDBS {
    public static MovieFactory movieFactory = new MovieFactory();
    public static PersonFactory personFactory = new PersonFactory();
    public static CommentFactory commentFactory = new CommentFactory();
    public static RateFactory rateFactory = new RateFactory();
    public MDBS() throws IOException {
        movieFactory.readDB();
        personFactory.readDB();
        Login.register("osman","mutlu","osman2205","05319075065","2000-05-22","wapzp120t",'M');
        personFactory.addAdmin("berk","oztas","50797333511","2001-01-15",'M',"berk123","123456");
        System.out.println(Login.login("osman2205","wapzp120t"));
        for (Admin admin: personFactory.getAdmins()) {
            System.out.println(admin.getUsername());
        }
        backUp();

    }
    public static void backUp() throws IOException {
        personFactory.backupDB();
        movieFactory.backupDB();
        rateFactory.backupDB();
        commentFactory.backupDB();
    }


}
