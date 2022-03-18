package com.arcanetravel.util;

import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

public class Stream {

    public static ByteArrayOutputStream io;
    public static BukkitObjectOutputStream os;

    public static void serializeStream() {
        try {
            io = new ByteArrayOutputStream();
            os = new BukkitObjectOutputStream(io);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    //编译OBJ序列化
    public static String writeEncodedObject(Object object) {

        String encodeObject = null;

        try {
            os.writeObject(object);
            os.flush();

            byte[] serialized = io.toByteArray();
            encodeObject = Base64.getEncoder().encodeToString(serialized);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return encodeObject;
    }

    //编译OBJ反序列化
    public static Object writeDecodedObject(String stringObject) throws IOException, ClassNotFoundException {

        byte[] serialized = Base64.getDecoder().decode(stringObject);

        ByteArrayInputStream in = new ByteArrayInputStream(serialized);

        BukkitObjectInputStream bin = new BukkitObjectInputStream(in);
        Object o = bin.readObject();
        bin.close();
        in.close();
        return o;


    }

    //编译OBJ反序列化
    public static Object writeDecodedObject1(String stringObject) throws IOException, ClassNotFoundException {

        byte[] serialized = Base64.getDecoder().decode(stringObject);

        ByteArrayInputStream innnnn = new ByteArrayInputStream(serialized);

        BukkitObjectInputStream binnnnn = new BukkitObjectInputStream(innnnn);


        return binnnnn.readObject();


    }

}
