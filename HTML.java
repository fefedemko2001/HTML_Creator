import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HTML {
    private HTML(){
        //empty
    }
    public static void HTMLing(String path, String start, List<String> kepek, List<String> mappak){
        String relative = FileWalker.getRelative(start, path);
        
        MyFile m = new MyFile(depth(relative), kepek, mappak);

        for (int i = 0; i<kepek.size(); i++){
            String s = kepek.get(i);
            String namehtml = HTMLMaker(s);

            String absolute = path + "\\" + namehtml;
            
            try{
                FileWriter w = new FileWriter(absolute);
                StringBuilder sb = new StringBuilder();
                sb.append(m.HTMLHeading(s));
                sb.append(m.HTMLStartPage());
                sb.append(m.HTMLDirArrows());
                if (kepek.size() == 1){
                    sb.append(m.HTMLPicNavigator(namehtml, s, namehtml));
                    sb.append(m.HTMLPic(namehtml, s));
                }
                else if(i == 0){
                    sb.append(m.HTMLPicNavigator(namehtml, s, HTMLMaker(kepek.get(i+1))));
                    sb.append(m.HTMLPic(HTMLMaker(kepek.get(i+1)), s));
                }
                else if (i == kepek.size()-1){
                    sb.append(m.HTMLPicNavigator(HTMLMaker(kepek.get(i-1)), s, namehtml));
                    sb.append(m.HTMLPic(namehtml, s));
                }
                else{
                    sb.append(m.HTMLPicNavigator(HTMLMaker(kepek.get(i-1)), s, HTMLMaker(kepek.get(i+1))));
                    sb.append(m.HTMLPic(HTMLMaker(kepek.get(i+1)), s));
                }
                w.write(sb.toString());
                w.close();
            }
            catch (IOException e){
                System.out.println("HIBA!");
                e.printStackTrace();
            }

        }
        MyFile m2 = new MyFile(depth(relative), kepek, mappak);
        StringBuilder sb = new StringBuilder();
        
        String dirHTML = path + "\\index.html";
        if (depth(path)== 0){
            dirHTML = "index.html";
        }

        try{
            FileWriter w = new FileWriter(dirHTML);
            sb.append(m2.HTMLHeading(path));
            sb.append(m2.HTMLStartPage());
            sb.append(m2.HTMLDirList());
            sb.append(m2.HTMLPicsList());
            w.write(sb.toString());
            w.close();
        }
        catch (IOException e){
            System.out.println("HIBA!");
            e.printStackTrace();
        }

    }

    private static int depth(String s){
        if (s.equals("")){
            return 0;
        }
        String[] arr = s.split("\\\\");
        return arr.length;
    }

    private static String HTMLMaker(String s){
        return s.substring(0,s.indexOf(".")) + ".html";
    }
}
