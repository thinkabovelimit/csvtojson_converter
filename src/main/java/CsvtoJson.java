

import pack.*;  //package pack contains a method convertion to convert csv to json

import java.io.IOException;
import java.util.*;

public class CsvtoJson{

    public static void main(String args[]) throws IOException {


        Csvconvertion csvc = new Csvconvertion();    //create an object of class convertion.

        csvc.readfile();
        List list=csvc.convertion();    //Function for file convertion.
        csvc.Writefile(list);


    }
}
