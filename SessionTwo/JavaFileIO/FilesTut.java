package secondPackage;

import java.io.*;

public class FilesTut {

    public static void main (String[] args){



        File f1 = new File("f1.log");

        try {
            if (f1.createNewFile()){
                System.out.println("File Created");
//                f1.renameTo(new File("f1BackUp.log"));
//                f1.delete();
            } else {
                System.out.println("File Not Created");

            }




        } catch (IOException e){
            e.printStackTrace();
        }

//  ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++




        File d1 = new File( "/home/helloworld/IdeaProjects/AtmProject/src/secondPackage/");

        if (d1.isDirectory()){

            File[] files = d1.listFiles();

            for (File x : files)  System.out.println(x.getName()+"  file name");
        }

//  ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


        File f2 = new File("f2.txt");

        try {


//  printWriter to write text to a file ======> format date that your going to be writing
//  buffered writer ====> save data until it is time to write ======> write one insted of write constantly
//  fileWriter ======> write the characters
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(f2)));
            printWriter.println("this is sample text");
            printWriter.close();

        } catch (IOException e){
            e.printStackTrace();
        }
//  ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


//        read information from a file
        f2 = new File("f2.txt");
        try {

//            read the data one line at a time
            BufferedReader br = new BufferedReader(new FileReader(f2));
            String text = br.readLine();

            while (text != null){

                System.out.println(text);
                text = br.readLine();

            }

            br.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

//  ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

//        binary data
        File f3 = new File("f3.dat");

//        connect to file to write our raw bytes of information

        FileOutputStream fos;

        try{
            fos = new FileOutputStream(f3);
//            buffered output stream =====> alow us to write in bulk instead of trying to write individual parts individually
            BufferedOutputStream bos = new BufferedOutputStream(fos);

//            write primitives to stream
            DataOutputStream dos = new DataOutputStream(bos);

            String name = "mohammad";
            int age = 44;
            double mDouble = 123.56;


            dos.writeUTF(name);
            dos.writeInt(age);
            dos.writeDouble(mDouble);
            dos.close();



        } catch (IOException e){
            e.printStackTrace();
        }

//  ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

//        read binary data
        f3 = new File("f3.dat");

        FileInputStream fis;

        try {
            fis = new FileInputStream(f3);


            BufferedInputStream bis = new BufferedInputStream(fis);


            DataInputStream dis = new DataInputStream(bis);


            System.out.println(dis.readUTF());
            System.out.println(dis.readInt());
            System.out.println(dis.readDouble());

            fis.close();



        } catch (IOException e){
            e.printStackTrace();
        }















    }


}
