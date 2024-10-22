import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("\nSistem Manajemen Mahasiswa");
            System.out.println("1. Menambahkan data baru");
            System.out.println("2. Data mahasiswa");
            System.out.println("3. Menghapus data");
            System.out.println("4. keluar");
            System.out.print("Pilihan: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                   
                    System.out.print("Masukkan NIM: ");
                    String nim = scanner.nextLine();

                    System.out.print("Masukkan Nama: ");
                    String name = scanner.nextLine();

                    Student student = new Student(nim, name);
                    
                    System.out.println("\nMenambahkan course untuk " + student.getName());
                    String addMore;
                    do {
                        System.out.print("masukkan kode course: ");
                        String courseCode = scanner.nextLine();

                        System.out.print("masukkan nama course: ");
                        String courseName = scanner.nextLine();

                        student.addCourse(courseCode, courseName);

                        System.out.print("apakah ingin menambahkan lagi?(ya/tidak): ");
                        addMore = scanner.nextLine().trim().toLowerCase();
                    } while (addMore.equals("ya"));

                    students.add(student);
                    System.out.println("Menambahkan data telah berhasil");
                    break;

                case 2:
                    System.out.println("\nDaftar Mahasiswa");
                    for (Student s : students) {
                        s.printStudentDetails();
                        System.out.println();
                    }
                    break;

                case 3:
                    // Remove a student by NIM
                    System.out.print("Masukkan NIM untuk menghapus data: ");
                    String nimToRemove = scanner.nextLine();
                    boolean removed = students.removeIf(s -> s.nim.equals(nimToRemove));
                    
                    if (removed) {
                        System.out.println("Mahasiswa dengan NIM " + nimToRemove + " berhasil");
                    } else {
                        System.out.println("Mahasiswa dengan NIM " + nimToRemove + " Tidak ada");
                    }
                    break;

                case 4:
                    running = false;
                    System.out.println("Bay");
                    break;

                default:
                    System.out.println("Tidak ada pilihan");
                    break;
            }
        }

        scanner.close();
    }
}
