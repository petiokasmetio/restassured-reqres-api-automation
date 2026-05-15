package SerializationDeserialization;
import Base.TestBase;

import java.io.*;

class Test implements Serializable
{
    int i = 10, j = 20;
}


public class SerializationAndDeserialization extends TestBase {

    //Serialization convert java object to file format
    //Using FileOutputStream and ObjectOutputStream classes

    //De-Serialization is convert file format convert to java object
    //Using FileInputStream and ObjectInputStream classes

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //Creating object of class Test
        Test t1 = new Test();

        //Serialization
        FileOutputStream fos = new FileOutputStream("test.txt");  //write the file in the memory
        ObjectOutputStream oos = new ObjectOutputStream(fos);    //convert our object in to file

        oos.writeObject(t1);   // convert object in to file format

        //Deserialization
        FileInputStream fis = new FileInputStream("test.txt");  //read file from memory
        ObjectInputStream ois = new ObjectInputStream(fis);   //convert serialized file in to java object

        Test t2 = (Test) ois.readObject();
        System.out.println(t2.i + "     " + t2.j);
    }
}
