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


//        System.out.println("Object object = null" + object);

            byte[] serialized = Base64.getDecoder().decode(stringObject);
            System.out.println("byte[] serialized" + serialized);
            ByteArrayInputStream in = new ByteArrayInputStream(serialized);
            System.out.println("ByteArrayInputStream in" + in);
            BukkitObjectInputStream bin = new BukkitObjectInputStream(in);
            System.out.println("BukkitObjectInputStream bin" + bin);

//            System.out.println("bin.readObject()" + bin.readObject());


//            System.out.println("object" + object.toString());


        return bin.readObject();


    }

}
