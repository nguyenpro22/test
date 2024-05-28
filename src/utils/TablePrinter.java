package utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class TablePrinter {

    public static <T> void printTable(List<String> headers, List<T> data) {
        List<Integer> columnWidths = new ArrayList<>();

        // Calculate column widths
        for (int i = 0; i < headers.size(); i++) {
            int maxWidth = headers.get(i).length();
            for (T item : data) {
                Class<?> clazz = item.getClass();
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    if (!Modifier.isFinal(field.getModifiers())) {
                        if (field.getName().equals(headers.get(i))) {
                            field.setAccessible(true);
                            try {
                                String cell = String.valueOf(field.get(item));
                                if (cell.length() > maxWidth) {
                                    maxWidth = cell.length();
                                }
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
            maxWidth = maxWidth % 2 == 0 ? maxWidth : maxWidth + 1;
            columnWidths.add(maxWidth + 2);
        }

        printBorder(columnWidths);

        printRow(headers, columnWidths);
        printBorder(columnWidths);

        for (T item : data) {
            List<String> stringRow = new ArrayList<>();
            Class<?> clazz = item.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                // Check if the field is not final
                if (!Modifier.isFinal(field.getModifiers())) {
                    field.setAccessible(true);
                    try {
                        stringRow.add(String.valueOf(field.get(item)));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            printRow(stringRow, columnWidths);
        }

        printBorder(columnWidths);
    }

    private static void printRow(List<String> row, List<Integer> columnWidths) {
        for (int i = 0; i < row.size(); i++) {
            String cell = row.get(i);
            int paddingSize = (columnWidths.get(i) - cell.length()) / 2;
            String padding = createPadding(paddingSize);
            String value = cell.length() % 2 == 0 ? cell : " " + cell;
            System.out.print("|" + padding + value + padding);
        }
        System.out.println("|");
    }

    private static String createPadding(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private static void printBorder(List<Integer> columnWidths) {
        for (int width : columnWidths) {
            System.out.print("*");
            for (int i = 0; i < width; i++) {
                System.out.print("=");
            }
        }
        System.out.print("*\n");
    }
}
