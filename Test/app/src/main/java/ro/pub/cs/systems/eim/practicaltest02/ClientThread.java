package ro.pub.cs.systems.eim.practicaltest02;

import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private int port;
    private String method;
    private TextView responseTextView;
    private String key;
    private String value;

    private Socket socket;
    public ClientThread(String key, int port, String value, String method, TextView resultView) {
        this.port = port;
        this.method = method;
        this.key = key;
        this.value = value;
        this.responseTextView = resultView;
    }

    @Override
    public void run() {
        try {
                socket = new Socket("worldtimeapi.org/api/ip", port);
            if (socket == null) {
                return;
            }
            BufferedReader bufferedReader = Utilities.getReader(socket);
            PrintWriter printWriter = Utilities.getWriter(socket);
            if (bufferedReader == null || printWriter == null) {

                return;
            }
            printWriter.println();
            printWriter.flush();
            printWriter.println();
            printWriter.flush();
            String valueInformation = bufferedReader.readLine();
            final String finalizedValueInformation = valueInformation;
            responseTextView.post(new Runnable() {
                @Override
                public void run() {
                    responseTextView.setText(finalizedValueInformation);
                }
            });

        } catch (IOException ioException) {

        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException ioException) {

                }
            }
        }
    }

}
