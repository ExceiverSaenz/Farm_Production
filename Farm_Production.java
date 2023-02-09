import java.io.*;
import java.util.*;

public class Farm_Production{
    public static void main(String [] args){
        
        int[][] data =readFile("data_base.txt",0);// This calls for a method to read a file and save information 2D Array named data
        System.out.println("\n+-----------------------------------------+");
        farm_avg(data);// This calls for a method to give average per farm
        System.out.print("+-----------------------------------------+\n");
        month_avg(data);// This calls for a method to give average per month of the year
        System.out.print("+-----------------------------------------+-------------------------+");
        top_farms(data);// This calls for a method to give top 3 production farm
        System.out.print("+-------------------------------------------------------------------+\n");
        farm_months(data);// This calls for a method to give top 3 production per month of the year
        System.out.print("+-------------------------------------------------------------------+\n");
        
    }
    
    public static int[][] readFile(String fileName, int row){// We have 2 parameters, the location & name of the file and a number start with 0 to use with a counter
        int[][] information = new int[5][12];// This int 2DArray is to save all information and return
        try{
            File database = new File(fileName);// This scan File and save in database File variable
            Scanner reader = new Scanner(database);// This scanner read file
            
            while(reader.hasNextLine()){// This while loop check if file have one more line to jump
                String numbers = reader.nextLine();// Save all line in string variable
                Scanner scan = new Scanner(numbers);// This scanner Take string to scan
                scan.useDelimiter(",");// This scanner method read all string and search delimiter to divide in different variables
                
                for(int col = 0; col<information[row].length; col++){// This for loop save information in index
                    String potatoe = scan.next();// save scanning in string
                    Scanner pota = new Scanner(potatoe);// use other scanner
                    information[row][col] = pota.nextInt();//scan again the string to convert in integer number
                }
                row++;
            }
        }catch(FileNotFoundException e){ System.out.println("We dont found input.txt");}// This is exception if File Not Found
        
        return information;//return all information
    }
    
    public static void farm_avg(int[][] data){

        
        for(int row = 0;row<data.length;row++){//this for loop read all array
            int numpy = 0;//declare & initialize variable numpy
            for(int col = 0; col<data[row].length;col++){
                numpy+=data[row][col];//sum all values and save in numpy var.
            }
            System.out.print("|   Average production for farm " + row + " is " + (numpy/data[row].length) + "   |\n");
        }
        
        
    }
    
    public static void month_avg(int[][] data){
        
        for(int col = 0; col<data[0].length;col++){//this for loop read all array
            int numpy = 0;//declare & initialize variable numpy
            for(int row = 0; row<data.length;row++){
                numpy+=data[row][col];//sum all values and save in numpy var.
            }
            if(col<10){
                System.out.print("|  Average production for month " + col + " is: " + (numpy/data.length)+"  |\n");
            }else{ System.out.print("|  Average production for month " + col + " is: " + (numpy/data.length)+" |\n");}
        }
    }
    
    public static void top_farms(int[][] data){
        int [] List_Farms = new int[5]; int [] Index = new int[3];// create 2 int arrays List_Farms & Index
        int first = 0; int second = 0; int third = 0;// create 3 integers variables
        
        for(int row = 0;row<data.length;row++){//this for loop read array vertical & horizontal
            for(int col = 0; col<data[row].length;col++){
                List_Farms[row] += data[row][col];//save information in array List_Farms
            }
        }
        
        for(int x = 0; x<List_Farms.length;x++){// Order highest to smaller number
            if(List_Farms[x]>first){ first = List_Farms[x]; Index[0]=x; }
        }
        System.out.println();
        for(int y = 0;y<List_Farms.length;y++){// Order highest to smaller number
            if(List_Farms[y]>second && List_Farms[y]<first){ second = List_Farms[y]; Index[1]=y; }
        }
        for(int z = 0; z<List_Farms.length; z++){// Order highest to smaller number
            if(List_Farms[z]>third && List_Farms[z]< second){ third = List_Farms[z]; Index[2]=z; }
        }
        System.out.println("|  Farm with the highest production: " + Index[0] + " with production: " + first + "         |");
        System.out.println("|  Farm with the second highest production: " + Index[1] + " with production: " + second + "  |");
        System.out.println("|  Farm with the third highest production: " + Index[2] + " with production: " + third + "   |");
    }
    
    public static void farm_months(int[][] data){
        int [] List_Months = new int [12]; int [] Index = new int [3];// create 2 int arrays List_Farms & Index
        int first = 0; int second = 0; int third = 0;// create 3 integers variables
        
        for(int col = 0; col<data[0].length;col++){//this for loop read array vertical & horizontal
            for(int row = 0; row<data.length;row++){
                List_Months[col] += data[row][col];//save information in array List_Months
            }
        }
        
        for(int x = 0; x<List_Months.length; x++){// Order highest to smaller number
            if(List_Months[x] > first){ first = List_Months[x]; Index[0]=x; }
        }

        for(int y = 0; y<List_Months.length; y++){// Order highest to smaller number
            if(List_Months[y] > second && List_Months[y] < first){ second = List_Months[y]; Index[1]=y; }
        }
        
        for(int z = 0; z<List_Months.length; z++){// Order highest to smaller number
            if(List_Months[z] > third && List_Months[z] < second){ third = List_Months[z]; Index[2]=z; }
        }
        System.out.println("|  Month with the highest production: " + Index[0] + " with production: " + first + "        |");
        System.out.println("|  Month with the second highest production: " + Index[1] + " with production: " + second + " |");
        System.out.println("|  Month with the third highest production: " + Index[2] + " with production: " + third + "  |");
    }
    
}