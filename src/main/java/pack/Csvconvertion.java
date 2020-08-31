package pack;

/*
import all the packages jackson required for reading and convertion
 */
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
/*
import packages for file operation
 */
import java.io.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.io.FileReader;
public class Csvconvertion {



    public void convertion (int index1,int index2,int index3) throws IOException {
            BufferedReader br1=new BufferedReader(new FileReader("../CsvtoJson_Converter/filename.txt"));    //Create an object of BufferedReader to read from file

            String str=br1.readLine();         //read first line(filename from filename.txt) and store it as a string

            File input = new File(str); //File input is given as str

                CsvSchema csv = CsvSchema.emptySchema().withHeader();//Create an object of csvschema
                CsvMapper csvMapper = new CsvMapper();    //create an object of csvmapper to read an input file.
                MappingIterator<Map<?, ?>> mappingIterator = csvMapper.reader().forType(Map.class).with(csv).readValues(input);  //Mappingiterator is used to map key value pairs

                List<Map<?, ?>> list = mappingIterator.readAll();  //create a list containing all values
                String list1=csvMapper.writeValueAsString(list);
                if (index3 == 1){     //If input from config file is 1 print values from index1 to index2 as specified in the file
                    try {
                        for (int i = index1; i <= index2; i++)

                            System.out.println(list.get(i));
                    } catch (Exception e) {
                        System.out.println("Error occured while parsing the file check the indexes");
                    }


                }
                else {          //Print full values
                    System.out.println(list);
                }





        }

        public int[] Filereader() throws FileNotFoundException {
            int[] arr=new int[100];   //read values from the config cile and store it in the array arr

            try (BufferedReader br = new BufferedReader(new FileReader("../CsvtoJson_Converter/config.txt"))) {
                for (int j=0;j<3;j++)
                    arr[j]= Integer.parseInt(br.readLine());
            } catch (IOException e) {
                System.out.println("Error in the configuration file");
            }
            return arr;  //return the arry value.
        }

    }
    

