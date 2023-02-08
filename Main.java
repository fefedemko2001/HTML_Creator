import java.io.File;

public class Main {
    public static void main(String[] args)
    {
        if (args.length == 0){
            System.out.println("HIBA! Adjon meg egy eleresi utvonalat!");
            System.exit(1);
        }
        File f = new File(args[0]);
        if (args.length == 2 && args[0].equals("clear")){
            Cleaner.walk(args[1]);
            System.out.println("HTML fajlok torolve.");
        }
        else if(args.length == 1 && f.isDirectory()){
            FileWalker fw = new FileWalker(args[0]);
        fw.walk(args[0]);
        }
        else{
            System.out.println("HIBA! Adjon meg egy eleresi utvonalat!");
            System.exit(1);
        }
 
    }
}
