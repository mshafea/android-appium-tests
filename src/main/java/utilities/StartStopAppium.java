package utilities;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.IOException;
import java.net.ServerSocket;

public class StartStopAppium {

    private static AppiumDriverLocalService service;
    private static String hubHost;
    private static int port;


    public static AppiumDriverLocalService startAppiumServer() {
        hubHost = System.getProperty("hub_host");
        port = Integer.parseInt(System.getProperty("port"));
        boolean flag = checkIfServerIsRunning(port);
        if (!flag) {
            System.out.println("Starting Appium Server ...");
            service = new AppiumServiceBuilder()
                    .withIPAddress(hubHost)
                    .usingPort(port)
                    .build();
            service.start();
            System.out.println("Appium server started successfully");
        }
        return service;
    }

    public static void stopAppiumServer() {

        System.out.println("Closing Appium server ... ");
        service.stop();
        System.out.println("Appium server closed successfully");
    }

    public static boolean checkIfServerIsRunning(int port) {
        boolean isServerRunning = false;
        ServerSocket serviceSocket;
        try {
            serviceSocket = new ServerSocket(port);
            serviceSocket.close();
        } catch (IOException e) {
            //If control comes here; then it means that the port is in use
            isServerRunning = true;
        }
        return isServerRunning;
    }

}