package Utils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtil {

  public static String[][] getDatafromExcel() throws IOException {

      FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\RahulShettyTestDataExcel.xlsx");
      XSSFWorkbook workbook = new XSSFWorkbook(fis);
      XSSFSheet sheet = workbook.getSheet("country");

      int totalrows = sheet.getPhysicalNumberOfRows();
      int totalcolms = sheet.getRow(0).getPhysicalNumberOfCells();

       String[][] data = new String[totalrows-1][totalcolms];

      for(int i=1;i<totalrows;i++){
          for(int j =0;j<totalcolms;j++){
              data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
          }
      }
return data;
    }
}
