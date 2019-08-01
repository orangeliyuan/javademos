package per.example.java8.lambda;

import java.io.File;
import java.io.FileFilter;

public class demo1 {

    public static void main(String[] args) {

        File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        for (int i = 0; i < hiddenFiles.length; i++) {
            System.out.println(hiddenFiles[i].getAbsolutePath());
        }

        File[] hiddenFiles1 = new File(".").listFiles(File::isHidden);

        for (int i = 0; i < hiddenFiles1.length; i++) {
            System.out.println(hiddenFiles1[i].getAbsolutePath());
        }

    }
}
