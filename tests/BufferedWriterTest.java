import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class BufferedWriterTest {

    @Test
    public void write() {
        String expectedString = "Это тестовая строка для записи в файл";
        String pathToFile = "write_test1.log";
        File file = new File(pathToFile);
        FileWriter fr = null;
        BufferedWriter br = null;
        try{
            fr = new FileWriter(file);
            br = new BufferedWriter(fr);
            br.write(expectedString);
        } catch (IOException e) {
            fail(e.getMessage());
        }finally{
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                fail(e.getMessage());
            }
        }
        writeTest(expectedString, pathToFile);
    }

    private void writeTest(String expectedString, String pathToFile){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader( new FileReader(pathToFile));
            String line = null;
            StringBuilder stringBuilder = new StringBuilder();
            while( ( line = reader.readLine() ) != null ) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator() );
            }
            assertEquals(expectedString, stringBuilder.toString().trim());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void write1() {
        String expectedString = "Это тестовая строка для записи в файл";
        String pathToFile = "write_test2.log";
        File file = new File(pathToFile);
        FileWriter fr = null;
        BufferedWriter br = null;
        try{
            fr = new FileWriter(file);
            br = new BufferedWriter(fr);
            int off =0;
            int len = expectedString.length();
            br.write(expectedString.toCharArray(), off, len);
        } catch (IOException e) {
            fail(e.getMessage());
        }finally{
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                fail(e.getMessage());
            }
        }
        writeTest(expectedString, pathToFile);
    }

    @Test
    public void write2() {
        String expectedString = "Это тестовая строка для записи в файл";
        String pathToFile = "write_test3.log";
        File file = new File(pathToFile);
        FileWriter fr = null;
        BufferedWriter br = null;
        try{
            fr = new FileWriter(file);
            br = new BufferedWriter(fr);
            int off =0;
            int len = expectedString.length();
            br.write(expectedString, off, len);
        } catch (IOException e) {
            fail(e.getMessage());
        }finally{
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                fail(e.getMessage());
            }
        }
        writeTest(expectedString, pathToFile);
    }

    @Test
    public void newLine() {
        String string = "Это тестовая строка для записи в файл";
        String pathToFile = "newLine_test.log";
        File file = new File(pathToFile);
        FileWriter fr = null;
        BufferedWriter br = null;
        try{
            fr = new FileWriter(file);
            br = new BufferedWriter(fr);
            br.write(string);
            br.newLine();
            br.write(string);
        } catch (IOException e) {
            fail(e.getMessage());
        }finally{
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                fail(e.getMessage());
            }
        }
        String expectedString = string+System.lineSeparator()+string;
        writeTest(expectedString, pathToFile);
    }


}