package cz.speedygonzales.crypting;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: vondracek
 * Date: 28.5.13
 * Time: 15:42
 * To change this template use File | Settings | File Templates.
 */
public class Testing {

    private static final String password = "ediaryXT6";


    public static void main(String[] args) {

//        crypting.Testing.printInfo();

        Testing.encode();

        Testing.decode();


    }

    private static void encode() {

        try {
            byte[] passwordInBytes = CryptUtils.INSTANCE.generateKey(password);

            File inputFile = new File("input_decoded.txt");


            byte[] bajty = new byte[(int) inputFile.length()];
            FileInputStream fis = new FileInputStream(inputFile);
            fis.read(bajty);
            fis.close();

            byte[] inputFileInBytes = CryptUtils.INSTANCE.encodeFile(passwordInBytes, bajty);


            File outputDecodedFile = new File("output_encoded.txt");
            if (!outputDecodedFile.exists()) {
                outputDecodedFile.createNewFile();
            }

            FileOutputStream fos = new FileOutputStream(outputDecodedFile);
            fos.write(inputFileInBytes);
            fos.flush();
            fos.close();


        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }


    private static void decode() {

        try {
            byte[] passwordInBytes = CryptUtils.INSTANCE.generateKey(password);

            File inputFile = new File("output_encoded.txt");
            if (!inputFile.exists()) {
                inputFile.createNewFile();
            }

            byte[] bajty = new byte[(int) inputFile.length()];
            FileInputStream fis = new FileInputStream(inputFile);
            fis.read(bajty);


            byte[] inputFileInBytes = CryptUtils.INSTANCE.decodeFile(passwordInBytes, bajty);

            System.out.println(new String(inputFileInBytes));

            File outputDecodedFile = new File("output_decoded.txt");
            if (!outputDecodedFile.exists()) {
                outputDecodedFile.createNewFile();
            }

            FileOutputStream fos = new FileOutputStream(outputDecodedFile);
            fos.write(inputFileInBytes);
            fos.flush();
            fos.close();


        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }


    private static void printInfo() {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("input_decoded.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();

            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        System.out.println(sb.toString());
    }

}
