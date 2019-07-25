package pl.sda;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FilePrinterOutput implements PrinterOutput{

    private Writer writer;

    public FilePrinterOutput(String path) {
        try {
            writer = new FileWriter(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void print(String string) {
        try {
            writer.write(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void println(String string) {
        try {
            writer.write(string);
            writer.write("\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
