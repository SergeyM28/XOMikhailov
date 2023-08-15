package org.example;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FieldSaver {
    private String directory = "XO.txt";
    private final FileWriter fileWriter = new FileWriter(directory, false);
    private final FileReader fileReader = new FileReader(directory);

    public FieldSaver() throws IOException {
    }

    public void saveFieldState(String fieldState){
        try(fileWriter){
            fileWriter.write(fieldState);
            fileWriter.flush();
        }
        catch(IOException e){
            throw new RuntimeException(String.valueOf(e.getStackTrace()));
        }
    }

    public String readFieldState(){
        try(fileReader){
            StringBuilder stringBuilder = new StringBuilder();
            int c;
            while((c=fileReader.read())!=-1){
                stringBuilder.append((char)c);
            }
            return stringBuilder.toString();

        }
        catch(IOException e){
            throw new RuntimeException(String.valueOf(e.getStackTrace()));

        }
    }
}
