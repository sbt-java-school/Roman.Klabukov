package ru.sbt.home5;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

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
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        while (bufferedReader.ready()) {
            System.out.println(bufferedReader.readLine() + "\n");
        }

    }

}