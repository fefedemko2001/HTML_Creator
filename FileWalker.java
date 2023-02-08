import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileWalker {
    private String start;

    public FileWalker(String start) {
        setStart(start);
    }

    private void setStart(String start) {
        this.start = start;
    }

    public String getStart() {
        return this.start;
    }

    public void walk(String path) {
        String s = getStart();
        File root = new File(path);
        File[] list = root.listFiles();
        List<String> mappak = new ArrayList<String>();
        List<String> kepek = new ArrayList<String>();

        if (list == null)
            return;

        for (File f : list) {
            if (f.isDirectory()) {
                String almappa = f.toString().substring(f.toString().lastIndexOf("\\") + 1);
                if (!mappak.contains(almappa)) {
                    mappak.add(almappa);
                }
                walk(f.getAbsolutePath());
            } else if (f.toString().toLowerCase().endsWith(".jpg") || f.toString().toLowerCase().endsWith(".jpeg")
                    || f.toString().toLowerCase().endsWith(".png")) {
                String kep = f.toString().substring(f.toString().lastIndexOf("\\") + 1);
                if (!kepek.contains(kep)) {
                    kepek.add(kep);
                }
            }
        }
        //System.out.println(kepek);
        //System.out.println(mappak);
        HTML.HTMLing(path, getStart(), kepek, mappak);
        if (path.equals(getStart())) {
            System.out.println("Kezdomappa kesz");
        } else {
            System.out.println(getRelative(s, path) + " mappa kesz");
        }
    }

    public static String getRelative(String eredeti, String jelenlegi) {
        if (eredeti.equals(jelenlegi)) {
            return "";
        }

        return jelenlegi.replace(eredeti + "\\", "");
    }

}
