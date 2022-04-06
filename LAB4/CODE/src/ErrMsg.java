import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ErrMsg {

    private String errMsg = "";

    public ErrMsg() {
    }

    public ErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public void check(ComplexNumber z, int position){

        System.out.println();
        String outDriver = "E:\\универ\\3.2\\SCO____testS\\LAB4\\CODE\\src\\ERRORS-log.txt";

        try(FileWriter writer = new FileWriter(outDriver, true))
        {
            if (z.isError())
                this.errMsg += z.getErrMsg();

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();

            // запись всей строки
            StringBuilder text = new StringBuilder();
            text.append(formatter.format(date) +  " | ERROR in " + (position + 1) + " line " + errMsg).append("\n");

            writer.write(text.toString());
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void check(String val){

        System.out.println();
        String outDriver = "E:\\универ\\3.2\\SCO____testS\\LAB4\\CODE\\src\\ERRORS-log.txt";

        try(FileWriter writer = new FileWriter(outDriver, true))
        {
            // запись всей строки
            StringBuilder text = new StringBuilder();
            text.append(val).append("\n");

            writer.write(text.toString());
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

    }

}
