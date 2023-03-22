package group3DS.example.restservice;

public class ClientMain {
    public static void main(String[] args) {;
        Client client1 = new Client();
        Thread thread1 = new Thread(client1);

        Client client2 = new Client();
        Thread thread2 = new Thread(client2);

        Client client3 = new Client();
        Thread thread3 = new Thread(client3);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
