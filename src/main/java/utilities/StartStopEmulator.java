package utilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class StartStopEmulator {

    public static void launchEmulator(String nameOfAVD) throws IOException, InterruptedException {
        System.out.println("Starting emulator for '" + nameOfAVD + "' ...");
        ProcessBuilder pb = new ProcessBuilder(System.getProperty("user.dir") + "/src/main/resources/startEmulator.sh",nameOfAVD);
        Process process = pb.start();
        process.waitFor(10, TimeUnit.SECONDS);
        System.out.println("Emulator launched successfully!");

    }

    public static void closeEmulator() throws InterruptedException, IOException {
        System.out.println("Killing emulator...");
        ProcessBuilder pb = new ProcessBuilder(System.getProperty("user.dir") + "/src/main/resources/stopEmulator.sh");
        Process process = pb.start();
        process.waitFor(3, TimeUnit.SECONDS);
        System.out.println("Emulator closed successfully!");
    }
}