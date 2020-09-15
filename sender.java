import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.io.FileWriter;
import java.util.StringTokenizer;
import java.io.FileReader; 
import java.util.Arrays; 
import java.io.File; 
import java.util.Arrays;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader; 



class sender {

    public static final String DELIMITER = ",";
  
 static boolean flag= false;
    public static void read(String fileName, String columnFilter) { 
		File inputFile = null; 
		FileReader inputFileReader = null;
		BufferedReader br = null;
		
		try {
			inputFile = new File(fileName);
			inputFileReader = new FileReader(inputFile);
			br = new BufferedReader(inputFileReader);
            String line = br.readLine(); 
           
			int INDEX = 0;
			if(columnFilter != null) {
				System.out.println("Prcoessing file: '"+fileName.trim()+"' with Column filter: "+columnFilter);
			}
			else {
				System.out.println("Prcoessing file: '"+fileName+"'");
			}
			if(line != null){
                String[] coloumns = line.split(",");
                // for(String c: coloumns){
                //     System.out.println(c);
                // }
				INDEX = printColumnsAndGetIndex(coloumns, columnFilter);
			}
			if(INDEX == -1){
				System.err.println("Column: '"+columnFilter+"' does not exist in file");
				return;
			}
			InputStreamReader ip = new InputStreamReader(System.in);
			BufferedReader reader = new BufferedReader(ip);
			while ((line = br.readLine()) != null  ) { 
               
				String[] row = line.split(",");
			   
				if(INDEX>=0 && row.length!=1) { 
                    if(row.length > INDEX)
                     System.out.println(row[INDEX]); 
				}
				else if(row.length !=0  && flag==true){
				
						printRowData(row);
					
		
				}
			}	
		}  
		catch (FileNotFoundException e) {
			System.out.println("File: "+fileName+" does not exists");
		} 
		catch (IOException | ArrayIndexOutOfBoundsException e) {
			System.out.println("Following error occured while processing file: "+fileName);
			e.printStackTrace();
		}  
		finally {
			// close resources	 
		}
    } 
	
	private static void printRowData(String[] data){
		for(String col:data){
			System.out.print(col+"  ");
		}
		System.out.println();
	}
	
	private static int printColumnsAndGetIndex(String[] columns, String filter){
		int index = -1;
		if(filter != null) {
			for(int i=0;i<=columns.length-1;i++) {
				if(columns[i].equalsIgnoreCase(filter)){
					if(filter.equalsIgnoreCase(columns[columns.length-1])){
						flag=true;
						System.out.println(columns[i] );
					index = i;
					
					}else{
					System.out.println(columns[i]);
					index = i;
					break;
					}
				}
			}
		}
		else {
			index = -2;
			System.out.print("| ");
			for(String column: columns) 
				System.out.print(column +" |");
			System.out.println();
		}
		return index;
	}
	
    public static void main(String[] args) {
		if(args != null && args.length>0) {
			String fileName = args[0]; 
			String filteredColumnName = null;
			if(args.length>1) {
				filteredColumnName = args[1];
			}
			sender.read(fileName, filteredColumnName);
		}
		else {
			System.err.println("No File name provided");
		}
	}

}
