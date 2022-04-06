import java.io.*;

public class Checker {
    StringBuilder getLinef1;
    StringBuilder getLinef2;
    public void check() throws IOException {
        String path1 = "E:\\универ\\3.2\\SCO____testS\\LAB4\\CODE\\src\\Expected_Result.txt";
        String path2 = "E:\\универ\\3.2\\SCO____testS\\LAB4\\CODE\\src\\Result.txt";
        try(FileReader reader = new FileReader(path1))
        {
            // читаем посимвольно
            int c;
            getLinef1 = new StringBuilder();
            while((c=reader.read())!=-1) {
                getLinef1.append((char) c);
            }
        }
        try(FileReader reader = new FileReader(path2))
        {
            // читаем посимвольно
            int c;
            getLinef2 = new StringBuilder();
            while((c=reader.read())!=-1) {
                getLinef2.append((char) c);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        String file1 = getLinef1.toString().replace("\r", "");
        String file2 = getLinef2.toString().replace("\r", "");

        System.out.println("\nExpected result\n" + file1);
        System.out.println("Result of test\n" + file2);


        if (file1.equals(file2))
            System.out.println("All work good");
        else
            System.out.println("result is different");
    }
}
