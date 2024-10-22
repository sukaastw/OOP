import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

class Member {
    private String name;
    private String memberID;
    private ArrayList<Book> borrowedBooks = new ArrayList<>();

    // Constructor
    public Member(String name, String memberID) {
        this.name = name;
        this.memberID = memberID;
    }

    public String getMemberID() {
        return memberID;
    }

    // Method to borrow a book
    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.setAvailable(false);
            System.out.println(name + " Anda telah Meminjam " + book.getTitle());
        } else {
            System.out.println("Buku Tidak Ada");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setAvailable(true);
            System.out.println(name + " Telah Mengembalikan " + book.getTitle());
        } else {
            System.out.println("Buku Tidak Dipinjam oleh " + name);
        }
    }

    public void displayBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println(name + " Anda Tidak Memiliki Buku yang Dipinjam");
        } else {
            System.out.println(name + " Anda telah meminjam Buku berikut:");
            for (Book book : borrowedBooks) {
                System.out.println("- " + book.getTitle());
            }
        }
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println(book.getTitle() + " Menambahkan ke Perpustakaan");
    }

    public void addMember(Member member) {
        members.add(member);
        System.out.println(member.getMemberID() + " Menambahkan Peserta");
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void listAvailableBooks() {
        System.out.println("Buku yang ada di Perpustakaan:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println("- " + book.getTitle() + " oleh " + book.getAuthor());
            }
        }
    }
}

public class LibraryApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        library.addBook(new Book("Mudah Belajar Java", "Budi Raharjo"));
        library.addBook(new Book("Belajar Pemrograman Web untuk Pemula", "Kristiano Haryono"));
        library.addBook(new Book("Jaringan kompuer", "Irwansyah"));

        System.out.println("Masukkan Nama:");
        String memberName = scanner.nextLine();
        System.out.println("Masukkan No Peserta:");
        String memberID = scanner.nextLine();
        Member member = new Member(memberName, memberID);
        library.addMember(member);

        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. List buku");
            System.out.println("2. Pinjam buku");
            System.out.println("3. Mengembalikan Buku");
            System.out.println("4. Data Buku yang dipinjam");
            System.out.println("5. Kembali");
            System.out.print("Pilihan: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    library.listAvailableBooks();
                    break;
                case 2:
                    System.out.println("Masukkan nama buku yang akan dipinjam:");
                    String bookTitle = scanner.nextLine();
                    for (Book book : library.getBooks()) { // Use getter to access books
                        if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                            member.borrowBook(book);
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Masukkan nama buku yang akan dikembalikan:");
                    String returnTitle = scanner.nextLine();
                    for (Book book : library.getBooks()) { // Use getter to access books
                        if (book.getTitle().equalsIgnoreCase(returnTitle)) {
                            member.returnBook(book);
                            break;
                        }
                    }
                    break;
                case 4:
                    member.displayBorrowedBooks();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Tidak Ada Pilihan");
            }
        }
        scanner.close();
    }
}
