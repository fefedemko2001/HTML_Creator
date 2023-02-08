import java.util.ArrayList;
import java.util.List;

public class MyFile {
    public MyFile(int n, List<String> pics, List<String> dirs) {
        setMelyseg(n);
        setPics(pics);
        setDirs(dirs);
    }

    private int melyseg;
    private List<String> pics;
    private List<String> dirs;

    public void setMelyseg(int n) {
        this.melyseg = n;
    }

    public void setPics(List<String> input) {
        if (input.isEmpty()) {
            this.pics = null;
        }
        this.pics = new ArrayList<String>(input);
    }

    public void setDirs(List<String> input) {
        if (input.isEmpty()) {
            this.dirs = null;
        }
        this.dirs = new ArrayList<String>(input);
    }

    public String HTMLHeading(String name) {
        String s = String.format(
                "<html>\n<head>\n<title>%s</title>\n<style>\nimg{\n\tmax-width: 75%%;\n\tmax-height: 75%%;\n}\n</style>\n</head>\n<body>\n\n",
                name);
        return s;
    }

    public String HTMLStartPage() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.melyseg; i++) {
            sb.append("..\\");
        }
        String s = String.format("<h1><a href = \"%sindex.html\">Start page</a></h1>\n<hr>\n\n", sb.toString());
        return s;
    }

    public String HTMLDirArrows() {
        String s = String.format("<h3><a href = \"index.html\">^^</a></h3>\n\n");
        return s;
    }

    public String HTMLPicNavigator(String previous, String name, String next) {
        String s = String.format(
                "<p>\n<span>\n<a href = \"%s\">&lt;&lt;</a>\n</span>\n%s\n<span><a href = \"%s\">&gt;&gt;</a>\n</span>\n</p>\n\n",
                previous, name, next);
        return s;
    }

    public String HTMLPic(String next, String name) {
        String s = String.format("<a href = \"%s\"><img src = \"%s\" class=\"img\"/></a>\n</body>\n</html>", next,
                name);

        return s;
    }

    public String HTMLDirList() {
        StringBuilder sb = new StringBuilder();

        if (this.melyseg == 0) {
            sb.append("<h1>Directories</h1>\n<ul>\n");
        } else {
            sb.append("<h1>Directories</h1>\n<ul>\n<li><a href = \"..\\index.html\">&lt;&lt;</a></li>\n\n");
        }
        String[] arr = dirs.toArray(new String[0]);
        for (String str : arr) {
            sb.append(String.format("\t<li><a href = \"%s\">%s</li>\n", str + "\\index.html", str));
        }
        sb.append("</ul>\n");
        return sb.toString();
    }

    public String HTMLPicsList() {
        if (pics.isEmpty()) {
            return "</body>\n</html>";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<hr>\n<ul>\n");
        String[] arr = pics.toArray(new String[0]);
        for (String str : arr) {
            sb.append(
                    String.format("\t<li><a href = \"%s\">%s</li>\n", str.substring(0, str.indexOf(".")) + ".html",
                            str));
        }
        sb.append("</body>\n</html>");
        return sb.toString();
    }

}
