import java.io.*;

public class Login {
    File filePathRead = new File("UserDetails.txt");
    BufferedReader bufferedReader;
    public boolean LoginUser(User user) {

        try {

            String str = "Username:" + user.getUserName() + " Password:" + user.getPassword().trim();
            bufferedReader = new BufferedReader(new FileReader(filePathRead));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                line.trim();
                if (line.equals(str)) {
                    return true;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
  /*  public static void main(String[] args) {

    User user=new User("laviksha","xyz");
    Login login=new Login();
        System.out.println(login.LoginUser(user));

    }
*/}

