package learn;

import java.util.LinkedList;

/**
 * @author JaydenZhou
 * @description
 * @date 19-9-7
 */
public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<String> books = new LinkedList<>();
        books.offer("疯狂Java");
        books.push("轻量Java EE");
        books.offerFirst("疯狂Android");
        for(String book : books) {
            System.out.println(book);
        }
        System.out.println(books.peekFirst());
        System.out.println(books.peekLast());
        System.out.println(books.pop());
        System.out.println(books);
        System.out.println(books.pollLast());
        System.out.println(books);

    }
}
