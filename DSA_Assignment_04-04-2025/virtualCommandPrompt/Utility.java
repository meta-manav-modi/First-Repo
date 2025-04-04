package virtualCommandPrompt;

import java.util.Scanner;

/** class Utility, helps to call all operations of command prompt */
public class Utility {
    public void execute() {
        VirtualCommandPrompt commPromt = new VirtualCommandPrompt();
        Scanner scanner = new Scanner(System.in);
        System.out.println(":::: Welcome to Metacube Virtual Command Prompt :::: ") ;

        try{
            while (true) {
                System.out.println(commPromt.getPrompt());
                String input = scanner.nextLine().trim();
                String[] parts = input.split(" ");

                switch (parts[0]) {
                    case "mkdir":
                        if (parts.length > 1)
                            commPromt.mkdir(parts[1]);
                        else {
                            System.out.println("Required folder name");
                        }
                        break;
                    case "cd":
                        if (parts.length > 1)
                            commPromt.cd(parts[1]);
                        else {
                            System.out.println("Required folder name");
                        }
                        break;
                    case "ls":
                        commPromt.ls();
                        break;
                    case "bk":
                        commPromt.back();
                        break;
                    case "find":
                        if (parts.length > 1)
                            commPromt.find(parts[1]);
                        else {
                            System.out.println("Required folder name");
                        }
                        break;
                    case "tree":
                        commPromt.tree();
                        break;
                    case "exit":
                        System.out.println("Exiting system");
                        return;
                }

            }
        }catch(AssertionError e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println("Unwanted error" + e.getMessage());
        }finally{
            scanner.close();
        }
    }
}
