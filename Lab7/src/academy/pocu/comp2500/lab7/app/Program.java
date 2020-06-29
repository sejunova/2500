package academy.pocu.comp2500.lab7.app;

import academy.pocu.comp2500.lab7.Author;
import academy.pocu.comp2500.lab7.Book;
import academy.pocu.comp2500.lab7.Bookshelf;
import academy.pocu.comp2500.lab7.Bundle;
import academy.pocu.comp2500.lab7.Genre;
import academy.pocu.comp2500.lab7.ReadingList;

public class Program {

    public static void main(String[] args) {
        {
            Author author = new Author("James", "Bond");
            Book book0 = new Book("How to be the best", author, 1990, Genre.BIOGRAPHY);
            Bookshelf bookshelf = new Bookshelf(10);

            assert (bookshelf.add(book0));
            assert (bookshelf.remove(book0));
            assert (!bookshelf.remove(book0));

            Book book1 = new Book("C# for dummies", new Author("Jason", "Bourne"), 2005, Genre.ROMANCE);
            Book book2 = new Book("C# for dummies", new Author("Jason", "Bourne"), 2005, Genre.ROMANCE);
            Book book3 = new Book("Java for dummies", new Author("James", "Bond"), 2007, Genre.MYSTERY);

            Bundle bundle = new Bundle("Programming");

            assert (bundle.add(book0));
            assert (bundle.add(book1));
            assert (!bundle.add(book2));
            assert (bundle.add(book3));

            assert (bundle.remove(book3));
            assert (bundle.remove(book0));
            assert (!bundle.remove(book0));

            ReadingList readingList = new ReadingList("Summer Break Homework");

            assert (readingList.add(book0));
            assert (readingList.add(book1));
            assert (readingList.add(book2));
            assert (readingList.add(book3));

            assert (readingList.remove(book3));
            assert (readingList.remove(book0));
            assert (!readingList.remove(book0));
        }
        {
            Book book1 = new Book("C# for dummies", new Author("Jason", "Bourne"), 2005, Genre.ROMANCE);
            Book book2 = new Book("Hello World", new Author("Jason", "Bourne"), 2004, Genre.MYSTERY);
            Book book3 = new Book("Java for dummies", new Author("James", "Bond"), 2007, Genre.MYSTERY);
            ReadingList readingList = new ReadingList("Summer Break Homework");
            readingList.add(book1);
            readingList.add(book2);
            readingList.add(book3);
        }

        {
            Book book1 = new Book("C# for dummies", new Author("Jason", "Bourne"), 2005, Genre.ROMANCE);
            Book book2 = new Book("C# for dummies", new Author("Jason", "Bourne"), 2005, Genre.ROMANCE);
            Book book3 = new Book("Java for dummies", new Author("James", "Bond"), 2007, Genre.MYSTERY);

            Bundle bundleA = new Bundle("A");
            Bundle bundleB = new Bundle("A");

            bundleA.add(book1);
            bundleA.add(book2);
            bundleA.add(book3);

            bundleB.add(book1);
            bundleB.add(book2);
            bundleB.add(book3);


            System.out.println(bundleA.equals(bundleB));

        }
    }
}