package ro.pub.cs.systems.eim.practicaltest02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;

public class PracticalTest02MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test02_main);
        try {
            ServerSocket serverSocket = new ServerSocket(2020);
            HashMap data = new HashMap<String, String>();
        } catch (IOException ioException) {

        }
    }
}
