
import java.io.*;

public class RandomAccessRevisi {
    public static void main(String[] args) {
        String bookList[] = {"Satu", "Dua", "Tiga"};
        int yearList[] = {1920, 1230, 1940};
        try {
            RandomAccessFile books = new RandomAccessFile("books.txt", "rw");
            for (int i = 0; i < 3; i++) {
                books.writeUTF(bookList[i]);
                books.writeInt(yearList[i]);
                books.seek(books.getFilePointer() - 8); // Move pointer back to read the written data
                System.out.println(books.readUTF() + " " + books.readInt());
            }
            books.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Indeks melebihi batas");
        } finally {
            System.out.println("Test");
        }
    }
}
