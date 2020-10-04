package pack;

/*
import all the packages jackson required for reading and convertion
 */
import com.fasterxml.jackson.databind.MappingIterator;      //Header files
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
/*
import packages for file operation
 */
import java.io.*;
import java.util.*;
import java.io.IOException;
abstract class Read_Write{
    /*
    Variables Inputfile and outputfile stores files for input and output
    Indexes are used to specify the from and to values to be printed and full values or selected values to be printed.
     */
    String Inputfile;
    String Outputfile;
    int index1;
    int index2;
    int index3;

    //This method reads all the values like inputfile ,outputfile indexes etc
    public void readfile() {
        FileReader reader = null;
        try {
            reader = new FileReader("/home/krishnaprasad/IdeaProjects/CsvtoJson_Converter/src/main/resources/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties p = new Properties();
        try {
            p.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Inputfile = p.getProperty("input");
        Outputfile = p.getProperty("output");
        index1 = Integer.parseInt(p.getProperty("index1"));
        index2 = Integer.parseInt(p.getProperty("index2"));
        index3 = Integer.parseInt(p.getProperty("index3"));
    }


    abstract  List convertion() throws IOException;

     abstract void Writefile(List list) throws IOException;





}
public class Csvconvertion extends Read_Write{
/*
class Csvconverter has two functions convertion and Filereader convertion is used in the process of convertion of csv to json.
Filereader is used to read from and to values to be printed ie( json format values to be printed).
 */



    @Override
    public List convertion () throws IOException {


        File input = new File(Inputfile); //File input is given as str

        CsvSchema csv = CsvSchema.emptySchema().withUseHeader(true);//Create an object of csvschema this tells the schema of the file withUserheader means take the first value of column as header

        CsvMapper csvMapper = new CsvMapper();    //create an object of csvmapper to read an input file.

        MappingIterator<Map<?, ?>> mappingIterator = csvMapper.reader(Map.class).with(csv).readValues(input);  //Mappingiterator is used to map key value pairs
        //with specifies the schema to which read

        List<Map<?, ?>> list = mappingIterator.readAll();  //mapping iterator returns list containing the list of json objects
        return list;



    }
    /*
    Writefile method is used to write the json data into a file.
     */
    @Override
    public void Writefile(List list) throws IOException {
            if (index3 == 1) {     //If input from config file is 1 print values from index1 to index2 as specified in the file
                FileWriter myWriter = new FileWriter(Outputfile);

                try {
                    for (int i = index1; i <= index2; i++)

                        //System.out.println(list.get(i));
                        myWriter.write(String.valueOf(list.get(i)));
                    myWriter.close();
                } catch (Exception e) {
                    System.out.println("Error occured while parsing the file check the indexes");

                }


            } else {          //Print full values
                //System.out.println(list);

                FileWriter myWriter = new FileWriter(Outputfile);
                myWriter.write(String.valueOf(list));
                myWriter.close();
            }

        }
    }



    

