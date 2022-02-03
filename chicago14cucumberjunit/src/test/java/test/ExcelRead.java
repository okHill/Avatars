package test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelRead {

    public static void main(String[] args) throws Exception {
//      1. Open file
        File file = new File("src/SampleData.xlsx");

//        System.out.println(file.exists());
        // if the print result is true, the path is working

//      2. Load the file into Java Memory by FileInputStream

        FileInputStream fileInputStream = new FileInputStream(file);

//      3. Load the Excel Workbook into Java Class

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

//      4. Remember Hierarchy
        // Workbook -> sheet -> row -> cell

//      5. Get the sheet from Workbook

        XSSFSheet sheet = workbook.getSheet("Employees");

//      6. Read the Sheet : How to get to Adam Smith?

        sheet.getRow(2).getCell(1);

//      7. Print the selection out

        System.out.println(sheet.getRow(2).getCell(1)); // --> Smith

//      8. Get the rows dynamically

        int usedRows = sheet.getPhysicalNumberOfRows();
        // counts only the cells that are used
        // unused cells will not be counted
        // empty cells will not interfere, they will not be counted
        // starts counting from 1 ?

        int lastUsedRow = sheet.getLastRowNum();
        // will count from top to bottom
        // empty cells will not be counted
        // counting rows starts from index 0

        // TASK: 1. Create a logic that prints out Marie's name dynamically

            // start looking for the row number
        for(int rowNum = 0; rowNum < usedRows; rowNum++) {

            if(sheet.getRow(rowNum).getCell(0).toString().equals("Marie")) {

                System.out.println("Marie's name: " + sheet.getRow(rowNum).getCell(0));
            }
        }

        // TASK: Create a logic that prints out Adam's last name dynamically

        for(int rowNum = 0; rowNum < usedRows; rowNum++) {
            if(sheet.getRow(rowNum).getCell(0).toString().equalsIgnoreCase("Adam")) {

                System.out.println("Adam's last name: " + sheet.getRow(rowNum).getCell(1));
            }
        }

        // Print out King's Job_ID dynamically

        for(int rowNum = 0; rowNum < usedRows; rowNum++) {
            if(sheet.getRow(rowNum).getCell(1).toString().equalsIgnoreCase("King")) {
                System.out.println("King's job id: " + sheet.getRow(rowNum).getCell(2));
            }
        }
    }
}
