import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Пробуем сериализовать и десериализовать объект.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        SomeData data = new SomeData();

        //FileOutputStream fout;

        FileOutputStream fout = new FileOutputStream("resources/data.txt");
            fout = new FileOutputStream("resources/data.txt");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } /*finally {
            try {
                fout.close();
            } catch (IOException e) {}
        }*/

    }
}
