import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

public class testEncode {

    public static void main(String[] args) {

        String encodedObject;

        try {

            ItemStack itemStack = new ItemStack(Material.ACACIA_LOG);
            //Serialize the item(turn it into byte stream)
            ByteArrayOutputStream io = new ByteArrayOutputStream();
            BukkitObjectOutputStream os = new BukkitObjectOutputStream(io);
            os.writeObject(itemStack);
            os.flush();

            byte[] serializedObject = io.toByteArray();

            //Encode the serialized object into to the base64 format
            encodedObject = new String(Base64.getEncoder().encode(serializedObject));

            System.out.println("Encoded Item: " + encodedObject);


            //Now we are going to do the reverse: decode the string back into raw bytes
            //and then deserialize the byte array into an object

            //decode string into raw bytes
            serializedObject = Base64.getDecoder().decode(encodedObject);

            //Input stream to read the byte array
            ByteArrayInputStream in = new ByteArrayInputStream(serializedObject);
            //object input stream to serialize bytes into objects
            BukkitObjectInputStream is = new BukkitObjectInputStream(in);

            //Use the object input stream to deserialize an object from the raw bytes
            ItemStack newItem = (ItemStack) is.readObject();

            System.out.println(newItem.getType());

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex);
        }


    }

}
