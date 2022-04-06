import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    private static ArrayList<ComplexNumber> results;
    private static ArrayList<ComplexNumber> firsts;
    private static ArrayList<ComplexNumber> seconds;

    public static void main(String[] args) throws Exception {

        String inputDriver = "E:\\универ\\3.2\\SCO____testS\\LAB4\\CODE\\src\\Initial_data.txt";
        String outDriver = "E:\\универ\\3.2\\SCO____testS\\LAB4\\CODE\\src\\Result.txt";
        try(FileReader reader = new FileReader(inputDriver))
        {
            // читаем посимвольно
            int c;
            StringBuilder getLine = new StringBuilder();
            while((c=reader.read())!=-1){
                getLine.append((char) c);
            }

            System.out.println("Read");
            String[] items = getLine.toString().split("\r\n");
            results = new ArrayList<ComplexNumber>();
            firsts = new ArrayList<ComplexNumber>();
            seconds = new ArrayList<ComplexNumber>();

            if (items.length % 4 != 0) {
                System.out.println("Неверное количество входных параметров \n необходимо колличество параметров кратное 4");
                return;
            }

            ArrayList<ComplexNumber> results = splitItems(items);

            for (int i = 0; i < results.size(); i++) {
                System.out.println((i+1) + ". " + results.get(i).printComplexNumber(firsts.get(i), seconds.get(i)));
            }

            try(FileWriter writer = new FileWriter(outDriver, false))
            {
                // запись всей строки
                StringBuilder text = new StringBuilder();
                for (int i = 0; i < results.size(); i++) {
                    if (!results.get(i).isError())
                        text.append( (i+1) + ". " + results.get(i).printComplexNumber(firsts.get(i), seconds.get(i))).append("\n");
                }

                writer.write(text.toString());
                writer.flush();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }

            Checker checker = new Checker();
            checker.check();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    private static ArrayList<ComplexNumber> splitItems(String[] items) throws Exception {

        double range = 10;
        int count = 0, inc = 0;
        ComplexNumber first = null;
        ComplexNumber second = null;
        double re = 0, im = 0;
        while (count != items.length){

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();

            try { re = Double.parseDouble(items[count]); }catch (Exception e){
                ErrMsg errMsg = new ErrMsg(); errMsg.check(formatter.format(date) + " | ERROR " + e.getMessage() + " | Error Enter Re " + (count + 1)  + " | Error String " + (inc + 1) + " | " );}
            count++;
            try { im = Double.parseDouble(items[count]); }catch (Exception e){
                ErrMsg errMsg = new ErrMsg(); errMsg.check(formatter.format(date) + " | ERROR " + e.getMessage() + " | Error Enter Im " + (count + 1)  + " | Error String " + (inc + 1) + " | " );}
            count++;


            System.out.println(" re = " + re + " im = " + im);
            first = new ComplexNumber(re, im);

            if (re > 10.0 || re < -10 || im > 10.0 || im < -10){
                first.setError(true);
                first.setErrMsg("The entered value is out of bounds (input element " + count + ")");
            }

            try { re = Double.parseDouble(items[count]); }catch (Exception e){
                ErrMsg errMsg = new ErrMsg(); errMsg.check(formatter.format(date) + " | ERROR " + e.getMessage() + " | Error Enter Re " + (count + 1)  + " | Error String " + (inc + 1) + " | " );}
            count++;
            try { im = Double.parseDouble(items[count]); }catch (Exception e){
                ErrMsg errMsg = new ErrMsg(); errMsg.check(formatter.format(date) + " | ERROR " + e.getMessage() + " | Error Enter Im " + (count + 1)  + " | Error String " + (inc + 1) + " | " );}
            count++;

            System.out.println(" re = " + re + " im = " + im + "\n");
            second = new ComplexNumber(re, im);

            if (re > 10.0 || re < -10 || im > 10.0 || im < -10){
                second.setError(true);
                second.setErrMsg("The entered value is out of bounds (input element " + count + ")");

            }

            firsts.add(first);
            seconds.add(second);

            if (first.isError() || second.isError()){
                results.add(first.mul(second));
                results.get(inc).setError(true);

                ErrMsg errMsg = new ErrMsg();
                if (first.isError())
                    errMsg.check(first, inc);
                else
                    errMsg.check(second, inc);
            }
            else{
                results.add(first.mul(second));
                results.get(inc).setError(false);
            }

            inc++;
        }
        return results;
    }

}
