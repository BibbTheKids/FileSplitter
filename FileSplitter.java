import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FileSplitter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama file: ");
        String filename = scanner.nextLine();

        System.out.print("Masukkan jumlah baris untuk setiap potongan: ");
        int linesPerSplit = scanner.nextInt();

        Queue<String> queue = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineCount = 0;

            while ((line = br.readLine()) != null) {
                queue.offer(line);
                lineCount++;

                // Jika jumlah baris mencapai batas, tampilkan potongan
                if (lineCount % linesPerSplit == 0) {
                    System.out.println("Potongan:");
                    while (!queue.isEmpty()) {
                        System.out.println(queue.poll());
                    }
                    System.out.println();
                }
            }

            // Tampilkan sisa baris yang mungkin ada
            if (!queue.isEmpty()) {
                System.out.println("Potongan terakhir:");
                while (!queue.isEmpty()) {
                    System.out.println(queue.poll());
                }
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file: " + e.getMessage());
        }

        scanner.close();
    }
}
