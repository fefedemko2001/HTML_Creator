import java.io.File;

public class Cleaner {

    private Cleaner(){
        //
    }

    public static void walk( String path ) {

        File root = new File( path );
        File[] list = root.listFiles();


        if (list == null) return ;

        for ( File f : list ) {
            if ( f.isDirectory() ) {
                walk( f.getAbsolutePath() );
            }
            else if (f.toString().endsWith(".html")){
                f.delete();
            }
        }
    }

    //public static void main(String[] args) {
    //    walk("e:\\DEIKMI\\3.felev\\java\\projektteszt");
    //}
}
