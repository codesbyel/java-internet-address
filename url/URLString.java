package url;

import java.net.*;

public class URLString {
    public static void main(String[] args) {
        // Hypertext transfer protocol
        stringURL("http://www.adc.org");

        // File transfer protocol
        stringURL("ftp://metalab.unc.edu/pub/languages/java/javafaq/");

        // Simple Mail Transfer Protocol
        stringURL("mailto:elharo@metalab.unc.edu");
    }

    private static void stringURL(String url) {
        try {
            URL u = new URL(url);
            System.out.println(u);
        } catch (MalformedURLException e) {
            System.out.println("Error");
        }
    }
}
