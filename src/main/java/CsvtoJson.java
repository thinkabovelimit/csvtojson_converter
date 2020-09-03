

import pack.*;  //package pack contains a method convertion to convert csv to json

import java.io.IOException;

public class CsvtoJson {

    public static void main(String args[]) throws IOException {
        Csvconvertion csvc = new Csvconvertion();    //create a method of convertion.

        int[] arr=csvc.Filereader();  //Function to read from the config file
        int index1=arr[0];
        int index2=arr[1];
        int index3=arr[2];
        csvc.convertion(index1,index2,index3);    //Function for file convertion.


    }
}
