package week3.homework.gateway;


import week3.homework.gateway.inbound.HttpInboundService;

import java.util.Arrays;

public class App {
    
    public static void main(String[] args) {

        String proxyPort = System.getProperty("proxyPort","8868");
        String proxyServers = System.getProperty("proxyServers"
                ,"http://localhost:8801,http://localhost:8802");
        int port = Integer.parseInt(proxyPort);
        HttpInboundService server = new HttpInboundService();
        try {
            server.runService(port,Arrays.asList(proxyServers.split(",")));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
