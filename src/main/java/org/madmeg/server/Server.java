package org.madmeg.server;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Madmegsox1
 * @since 09/02/2022
 */

public final class Server {


    public static DatabaseReference reference;

    public static void main(String[] args) throws IOException {

        FileInputStream serviceAccount =
                new FileInputStream("mb-rps-firebase-adminsdk-qfmf8-3b3cb650e3.json");

        FirebaseOptions options = FirebaseOptions.builder().setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://mb-rps.firebaseio.com/")
                .build();

        FirebaseApp app = FirebaseApp.initializeApp(options);
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        reference = database.getReference();


        PacketProcessor packetProcessor = new PacketProcessor();
        packetProcessor.openPort(PacketProcessor.port);
        packetProcessor.run();
    }
}
