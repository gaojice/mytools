package serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class UIDTester {
	public static void main(String... strings) throws Exception {
        File file = new File("out.ser");
//        FileOutputStream fos = new FileOutputStream(file);
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//
//        SerializeMe serializeMe = new SerializeMe(1);
//        oos.writeObject(serializeMe);
//        oos.close();

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        SerializeMe dto = (SerializeMe) ois.readObject();
        System.out.println("data : " + dto.getData());
        ois.close();
    }
}
