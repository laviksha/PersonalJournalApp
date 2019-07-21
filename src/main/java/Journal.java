import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Journal {
    File filePathRead;
    BufferedReader bufferedReader;
    public String ReadJournal(User user){
        StringBuilder res=new StringBuilder();
        try {
            filePathRead = new File(user.getUserName()+".txt");

            bufferedReader = new BufferedReader(new FileReader(filePathRead));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if(line.equals("**--**")){ res.append("\n"); continue;}
                res.append(line+"\n");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res.toString();
    }

    public  boolean WriteJournal(User user, String entry){
        try  {
            // RandomAccessFile f = new RandomAccessFile(new File("D:\\data\\lavi\\Personal Journal App\\Personal-Journal-App\\src\\"+user.getUserName()+".txt"), "rw")
            filePathRead = new File(user.getUserName()+".txt");
            bufferedReader = new BufferedReader(new FileReader(filePathRead));

            StringBuilder temp=new StringBuilder();

            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm a");
            String formattedDate = myDateObj.format(myFormatObj);

            temp.append(formattedDate+"\n "+entry+"\n"+"**--**");
            String line;
            int count=0;
            while ((line = bufferedReader.readLine()) != null) {
                if(line.equals("**--**")) count++;
                if(count==49){
                    continue;
                }
                temp.append("\n"+line);
            }

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePathRead,false));
            bufferedWriter.write(temp.toString());
            bufferedWriter.flush();
            bufferedWriter.close();
            return true;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

   /* public static void main(String[] args) {
        User user=new User("laviksha","xyz");
        Journal journal=new Journal();

        System.out.println(journal.WriteJournal(user,"hello 20"));
        System.out.println(journal.ReadJournal(user));
    }*/
}



