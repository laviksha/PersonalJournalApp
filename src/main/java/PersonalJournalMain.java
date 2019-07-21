import java.util.Scanner;

public class PersonalJournalMain {

    public static void main(String[] args) {


        Journal journal=new Journal();
        Login login=new Login();
        Scanner sc=new Scanner(System.in);
        while(true) {
            System.out.println("\nPress....");
            System.out.println("1.SignUp \n2.Login \n3.Exit\n");
            try{
                String strOpt = sc.next();
                int opt=Integer.parseInt(strOpt);
                if (opt == 1) {
                    User user = new User();
                    System.out.println("\nWelcome User! Create an acount...Please enter:");
                    System.out.println("UserName:");
                    user.setUserName(sc.next());
                    System.out.println("Password");
                    user.setPassword(sc.next());
                    String signUp = SignUp.UserSignUp(user);
                    System.out.println(signUp);

                } else if (opt == 2) {
                    User user = new User();
                    System.out.println("\nWelcome User! Please enter your UserName and password to Login");
                    //System.out.println("Welcome User! Login:");
                    System.out.println("UserName:");
                    user.setUserName(sc.next());
                    System.out.println("Password");
                    user.setPassword(sc.next());
                    if (login.LoginUser(user)) {
                        while (true) {
                            System.out.println("\nPress....");
                            System.out.println("1.Create New Entry \n2.Read your Journal \n3.Exit\n");
                            try {
                                String strJournalOpt=sc.next();
                                int journalOpt = Integer.parseInt(strJournalOpt);
                                if (journalOpt == 1) {
                                    StringBuilder journalEntry = new StringBuilder();
                                    System.out.println("\nStart writing your entry...Please enter \'exit\' when you want to save and exit");
                                    String str = "test";
                                    while (true) {
                                        str = sc.nextLine();
                                        if (str.toLowerCase().equals("exit")) break;
                                        journalEntry.append(str + "\n");
                                    }
                                    boolean status = journal.WriteJournal(user, journalEntry.toString());
                                    if (status) System.out.println("Journal Entry successfully added\n");
                                    else System.out.println("Failed to add journal entry\n");

                                } else if (journalOpt == 2) {
                                    System.out.println(journal.ReadJournal(user));
                                } else if (journalOpt == 3) {
                                    break;
                                } else {
                                    System.out.println("You did not select correct option! Try Again!\n");

                                }
                            } catch (Exception e) {
                                System.out.println("Please enter integer entries\n");
                            }
                        }
                    } else{
                        System.out.println("Username or Password incorrect! Try again\n");

                    }

                }

                else if(opt==3){ break;}
                else {
                    System.out.println("You did not select correct option! Try Again!\n");

                }

            }
            catch(Exception e){
                System.out.println("Please enter integer entries\n");
            }
        }
    }
/*	public static void main(String[] args) {
		SpringApplication.run(PersonalJournalAppApplication.class, args);




	}
*/
}

