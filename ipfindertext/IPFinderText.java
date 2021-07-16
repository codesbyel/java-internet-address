package ipfindertext;

import java.net.*;
import java.io.*;

public class IPFinderText {
    public static void main(String[] args) throws IOException {
        try {
            InetAddress address = InetAddress.getByName("www.utm.my"); // you can change any kind of domain
            System.out.println("IP: " + address.getHostAddress());
            System.out.println("Name: " + address.getHostName());
        } catch (UnknownHostException e) {
            System.out.println("Couldn't find IP address of the given host");
        }
    }
}