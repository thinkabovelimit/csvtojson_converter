

import pack.*;  //package pack contains a method convertion to convert csv to json

import java.io.IOException;

public class CsvtoJson {

    public static void main(String args[]) throws IOException {
        Csvconvertion csvc = new Csvconvertion();    //create a method of convertion.

//        int[] arr=csvc.Filereader();  //Function to read from the config file
        csvc.readfile();
        csvc.convertion();    //Function for file convertion.


    }
}
