package utils;

import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FileIOManager {

    // Method to load a list from a file
    public static <T> List<T> loadListFromFile(String filePath, Class<T> objectType) {
        List<T> list = new ArrayList<>();
        File f = new File(filePath);

        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = reader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, "|");
                List<String> values = new ArrayList<>();

                while (st.hasMoreTokens()) {
                    values.add(st.nextToken().trim());
                }

                T obj = objectType.getDeclaredConstructor().newInstance();
                Method initializeMethod = obj.getClass().getMethod("initializeData", List.class);
                initializeMethod.invoke(obj, values);
                list.add(obj);
            }
            return list;
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

// Method to save a list to a file
    public static <T> boolean saveObjectListToFile(String filePath, List<T> objectList) {
        File f = new File(filePath);

        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(f))) {
            for (T item : objectList) {
                writer.write(item.toString());
                writer.write("\n");
            }
            writer.flush();
            return true;
        } catch (IOException e) {
            System.out.println("Save file failed: " + e.getMessage());
            return false;
        }
    }
}
