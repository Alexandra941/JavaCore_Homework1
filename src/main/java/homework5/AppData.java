package homework5;

import java.util.Arrays;

public class AppData {
    private String[] header;
    private int[][] data;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public String[] getHeader() {
        return header;
    }

    public int[][] getData() {
        return data;
    }

    public void Print() {
        if (this.header != null && this.header.length > 0){
            System.out.println(Arrays.toString(this.header));
        }

        if (this.data != null && this.data.length > 0){
            for (int[] dataRow : this.data) {
                if (dataRow == null) {
                    System.out.println();
                    continue;
                }
                System.out.println(Arrays.toString(dataRow));
            }

        }
    }
}
