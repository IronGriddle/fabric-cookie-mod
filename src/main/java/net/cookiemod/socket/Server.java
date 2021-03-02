package net.cookiemod.socket;

import net.minecraft.client.MinecraftClient;
import net.minecraft.network.MessageType;
import net.minecraft.text.Text;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;

import static net.cookiemod.CookieMod.PACKET_BUFFER;

public class Server extends WebSocketServer {

    MinecraftClient mc = MinecraftClient.getInstance();
    WebSocket connection;


    public Server(InetSocketAddress address) {
        super(address);
    }

    private void sendMessageToChat(String message){
        //MC must be initialized
        if (mc == null){
            return;
        }

        mc.inGameHud.addChatMessage(MessageType.SYSTEM, Text.of("[SERVER] " + message), mc.player.getUuid());
    }

    public void sendPacketBuffer(){
        if (connection == null) {
            sendMessageToChat("No connection");
            return;
        }
        //Send the data;
        connection.send(PACKET_BUFFER.getJson());
        //Reset the buffer;
        PACKET_BUFFER.reset();
    }

    public void sendMessage(String string){
        if (connection == null) {
            sendMessageToChat("No connection");
            return;
        }

        this.broadcast(string);
        //connection.send(string);
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        connection = conn;
       sendMessageToChat("Connection from client made at:" + this.getPort());
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        sendMessageToChat("Closed at: "+ this.getPort());
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        sendMessageToChat(message);
    }

    @Override
    public void onMessage( WebSocket conn, ByteBuffer message ) {
        System.out.println("received ByteBuffer from "	+ conn.getRemoteSocketAddress());
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        sendMessageToChat(ex.toString());
    }

    @Override
    public void onStart() {
        System.out.println("[SERVER] Initialized");
    }

    public static void main(String[] args) {
        String host = "localhost";
        int port = 8321;

        WebSocketServer server = new Server(new InetSocketAddress(host, port));
        server.start();

    }


}
