package com.flydean.string;

import java.io.*;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author wayne
 * @version StringUsage,  2020/7/24
 */
public class StringUsage {

    public String readByteWrong(InputStream inputStream) throws IOException {
        byte[] data = new byte[1024];
        int offset = 0;
        int bytesRead = 0;
        String str="";

        while ((bytesRead = inputStream.read(data, offset, data.length - offset)) != -1) {
            str += new String(data, offset, bytesRead, "UTF-8");
            offset += bytesRead;
            if (offset >= data.length) {
                throw new IOException("Too much input");
            }
        }
        return str;
    }

    public String readByteCorrect(InputStream inputStream) throws IOException {
        Reader r = new InputStreamReader(inputStream, "UTF-8");
        char[] data = new char[1024];
        int offset = 0;
        int charRead = 0;
        String str="";

        while ((charRead = r.read(data, offset, data.length - offset)) != -1) {
            str += new String(data, offset, charRead);
            offset += charRead;
            if (offset >= data.length) {
                throw new IOException("Too much input");
            }
        }
        return str;
    }

    public static String subStringWrong(String string) {
        char ch;
        int i;
        for (i = 0; i < string.length(); i += 1) {
            ch = string.charAt(i);
            if (!Character.isLetter(ch)) {
                break;
            }
        }
        return string.substring(i);
    }

    public static String subStringCorrect(String string) {
        int ch;
        int i;
        for (i = 0; i < string.length(); i += Character.charCount(ch)) {
            ch = string.codePointAt(i);
            if (!Character.isLetter(ch)) {
                break;
            }
        }
        return string.substring(i);
    }

    public void toUpperCaseWrong(String input){
        if(input.toUpperCase().equals("JOKER")){
            System.out.println("match!");
        }
    }

    public void toUpperCaseRight(String input){
        if(input.toUpperCase(Locale.ENGLISH).equals("JOKER")){
            System.out.println("match!");
        }
    }

    public void getDateInstanceWrong(Date date){
        String myString = DateFormat.getDateInstance().format(date);
    }

    public void getDateInstanceRight(Date date){
        String myString = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.US).format(date);
    }

    public void fileOperationWrong(String inputFile,String outputFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        PrintWriter writer = new PrintWriter(new FileWriter(outputFile));
        int line = 0;
        while (reader.ready()) {
            line++;
            writer.println(line + ": " + reader.readLine());
        }
        reader.close();
        writer.close();
    }

    public void fileOperationRight(String inputFile,String outputFile) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), Charset.forName("UTF8")));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outputFile), Charset.forName("UTF8")));
        int line = 0;
        while (reader.ready()) {
            line++;
            writer.println(line + ": " + reader.readLine());
        }
        reader.close();
        writer.close();
    }




}
