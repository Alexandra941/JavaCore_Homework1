package homework5;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String fileName = "Homework5.csv";

        AppData dataToSave = new AppData(
                new String[]{"Value 1","Value 2","Value 3"},
                new int[][] {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9},
                        {0, 256, 879}
                });

        System.out.printf("Сохраняем данные в файл %s \n", fileName);
        dataToSave.Print();
        saveDataToCsv(dataToSave, fileName);

        System.out.printf("Считываем данные из файла %s \n", fileName);
        AppData appData = readFromCsv(fileName);
        appData.Print();
    }

    private static AppData readFromCsv(String fileName) {
        if (fileName == null || fileName.isEmpty()){
            return null;
        }

        String[] headers = new String[0];
        ArrayList<int[]> data = new ArrayList<>();

        try {
            File file = new File(fileName);
            if(file.exists() && file.isFile()){
                BufferedReader br = Files.newBufferedReader(file.getAbsoluteFile().toPath());
                String line = br.readLine();

                if (line == null || line.isEmpty()){
                    return null;
                }

                headers = line.split(";");

                line = br.readLine();

                while (line != null) {
                    if (!line.isEmpty()) {
                        String[] csvData = line.split(";");

                        data.add(Arrays.stream(csvData).map(String::trim).mapToInt(Integer::parseInt).toArray());
                    }

                    line = br.readLine();
                }
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return new AppData(headers, data.toArray(new int[0][0]));
    }

    private static void saveDataToCsv(AppData appData, String fileName) {
        if (appData == null || appData.getHeader() == null && appData.getData() == null) {
            return;
        }

        File file = createFileIfNotExists(fileName);
        if (!file.exists()) {
            System.out.printf("Не удалось создать файл %s \n", fileName);
        }

        try (PrintWriter writer = new PrintWriter(file)) {
            if (appData.getHeader() != null) {
                writer.println(toCsvStringRow(Arrays.toString(appData.getHeader())));
            }

            if (appData.getData() != null) {
                for (int[] row : appData.getData()) {
                    writer.println(toCsvStringRow(Arrays.toString(row)));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static File createFileIfNotExists(String fileName){
        File file = new File(fileName);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return file;
    }

    private static String toCsvStringRow(String row) {
        String result = row.replaceAll(",",";");
        result = result.substring(1);
        result = result.substring(0, result.length() - 1);
        return result + "\n";
    }
}
