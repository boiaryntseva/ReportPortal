package libs;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


public class SpreadSheetData {

    private transient Collection<Object[]> data;

    public SpreadSheetData(final InputStream excelInputStream, final String sheetName) throws IOException {
        this.data = loadFromSpreadsheet(excelInputStream, sheetName);
    }

    public Collection<Object[]> getData() {
        return data;
    }

    private Collection<Object[]> loadFromSpreadsheet(final InputStream excelFile, final String sheetName)
            throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook(excelFile);

        data = new ArrayList<>();

        Sheet sheet = workbook.getSheet(sheetName);

        int numberOfColumns = countNonEmptyColumns(sheet);
        List<Object[]> rows = new ArrayList<>();
        List<Object> rowData = new ArrayList<>();

        for (Row row : sheet) {
            if (isEmpty(row)) {
                break;
            } else {
                rowData.clear();
                for (int column = 0; column < numberOfColumns; column++) {
                    Cell cell = row.getCell(column);
                    rowData.add(objectFrom(workbook, cell));
                }
                rows.add(rowData.toArray());
            }
        }
        return rows;
    }

    public static List<Object[]> getDataFromExcel(final InputStream excelFile, final String sheetName) throws IOException {
        List<Object[]> dataList = new ArrayList<>();

        HSSFWorkbook workbook = new HSSFWorkbook(excelFile);
        Sheet sheet = workbook.getSheet(sheetName);

//            int numberOfColumns = countNonEmptyColumns(sheet);
//            for(int i =2; i <= reader.getRowCount("RegistrationData"); i++) {
//
//                String fname = reader.getCellData("RegistrationData", "FirstName", i);
//                String Lname = reader.getCellData("RegistrationData", "LastName", i);
//                String email = reader.getCellData("RegistrationData", "Email", i);
//                String password = reader.getCellData("RegistrationData", "Password", i);
//                dataList.add(new Object[] {fname, Lname, email, password});
//            }
//            return dataList;
//        }
//
        int numberOfColumns = countNonEmptyColumns(sheet);
        List<Object[]> rows = new ArrayList<>();
        List<Object> rowData = new ArrayList<>();

        for (
                Row row : sheet) {
            if (isEmpty(row)) {
                break;
            } else {
                rowData.clear();
                for (int column = 0; column < numberOfColumns; column++) {
                    Cell cell = row.getCell(column);
                    rowData.add(objectFrom(workbook, cell));
                }
                rows.add(rowData.toArray());
            }
        }
        return rows;
    }

    private static boolean isEmpty(final Row row) {
        Cell firstCell = row.getCell(0);
        return (firstCell == null)
                || (firstCell.getCellType() == Cell.CELL_TYPE_BLANK);
    }

    /**
     * Count the number of columns, using the number of non-empty cells in the
     * first row.
     */
    private static int countNonEmptyColumns(final Sheet sheet) {
        Row firstRow = sheet.getRow(0);
        return firstEmptyCellPosition(firstRow);
    }

    private static int firstEmptyCellPosition(final Row cells) {
        int columnCount = 0;
        for (Cell cell : cells) {
            if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
                break;
            }
            columnCount++;
        }
        return columnCount;
    }

    private static Object objectFrom(final HSSFWorkbook workbook, final Cell cell) {
        Object cellValue = null;

        if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
            cellValue = cell.getRichStringCellValue().getString();
        } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            cellValue = getNumericCellValue(cell);
        } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            cellValue = cell.getBooleanCellValue();
        } else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
            cellValue = evaluateCellFormula(workbook, cell);
        }

        return cellValue;

    }

    private static Object getNumericCellValue(final Cell cell) {
        Object cellValue;
        if (DateUtil.isCellDateFormatted(cell)) {
            cellValue = new Date(cell.getDateCellValue().getTime());
        } else {
            cellValue = cell.getNumericCellValue();
        }
        return cellValue;
    }

    private static Object evaluateCellFormula(final HSSFWorkbook workbook, final Cell cell) {
        FormulaEvaluator evaluator = workbook.getCreationHelper()
                .createFormulaEvaluator();
        CellValue cellValue = evaluator.evaluate(cell);
        Object result = null;

        if (cellValue.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            result = cellValue.getBooleanValue();
        } else if (cellValue.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            result = cellValue.getNumberValue();
        } else if (cellValue.getCellType() == Cell.CELL_TYPE_STRING) {
            result = cellValue.getStringValue();
        }

        return result;
    }
}