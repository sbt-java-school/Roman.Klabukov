package home5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * Created by rmk9 on 22.08.16.
 */


public class Application {

    public static void main(String[] args) throws IOException {

        while(true) {

            try {

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                readContent(bufferedReader.readLine());
                System.out.println(bufferedReader.readLine());
                bufferedReader.close();
                break;

            } catch (UnknownHostException e) {

                System.out.println(e.getMessage());
                continue;

            } catch (MalformedURLException e) {

                System.out.println(e.getMessage());
                continue;

            } catch (IOException e) {

                System.out.println(e.getMessage());
                continue;

            } catch (Exception e) {

                System.out.println(e.getMessage());
                continue;

            }

        }



    }

    public static void readContent(final String urlString) throws IOException {

        URL url = new URL(urlString);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        while (reader.ready()) {
            System.out.println(reader.readLine() + "\n");
        }

    }

}
