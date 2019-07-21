import java.io.*;
import java.nio.file.Paths;

public class SignUp {
    public static String UserSignUp(User user) {
        String result = null;
        File filePath = new File("UserDetails.txt");
        System.out.println("Checking to see if username exists...");
        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;
            int lineCount = 0;
            boolean usernameExists = false;
            while ((line = bufferedReader.readLine()) != null) {
                lineCount++;
                if (lineCount >9) {
                    return "Storage full! 10 users already exist!";
                }

                String[] tempUser=line.split(" ");
                if (tempUser[0].equals("Username:"+user.getUserName())) {
                    usernameExists = true;
                    break;

                }
                // System.out.println(line);
            }
            if (usernameExists) {
                result = "Username already exist";
            } else {
                File journal=new File(""+user.getUserName()+".txt");
                journal.createNewFile();
                bufferedWriter = new BufferedWriter(new FileWriter(filePath,true));
                bufferedWriter.append("Username:" + user.getUserName() + " Password:" + user.getPassword()+"\n");

                bufferedWriter.flush();
                bufferedWriter.close();
                result = "SignUp successfull";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


   /* public static void main(String[] args) {
        User user=new User("ss","xyz");
        System.out.println(UserSignUp(user));
    }
*/
}

