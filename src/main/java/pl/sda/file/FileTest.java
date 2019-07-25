package pl.sda.file;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileTest {

    public static void main(String[] args) {
        File dir = new File("data");
        File file = new File("data/myfile.txt");
        try {
            dir.mkdir();
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path path = Paths.get("data/myfile2.txt");
        try {
            Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter fileWriter = new FileWriter("data/myfile2.txt");) {
            fileWriter.write("Hello World w Pliku");
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (FileReader fileReader = new FileReader("data/myfile2.txt");) {
            int character;
            while ((character = fileReader.read()) != -1) {
                System.out.println((char) character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (BufferedReader fileReader = new BufferedReader(
                new FileReader("data/myfile2.txt")
        )) {
            System.out.println(fileReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
