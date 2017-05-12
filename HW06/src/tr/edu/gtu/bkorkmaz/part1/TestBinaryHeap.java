package tr.edu.gtu.bkorkmaz.part1;

public class TestBinaryHeap {

    public static void main(String[] args) {

        BinaryHeap<Integer> bh = new BinaryHeap<>();

        bh.offer(3);
        bh.offer(2);
        bh.offer(7);
        bh.offer(9);
        bh.offer(1);
        bh.offer(2);

        System.out.println("Integer Queue _3 2 7 9 1 2_ \nReordering according" +
                " to their priority:");

        int heapSize = bh.size();
        for (int i = 0; i < heapSize; i++) {

            System.out.println(bh.poll());
        }


        BinaryHeap<Character> charBH = new BinaryHeap<>();
        charBH.add('f');
        charBH.add('k');
        charBH.add('b');
        charBH.add('v');
        charBH.add('a');

        System.out.println("Character Queue _f k b v a_\nReordering according" +
                " to their priority:");

        heapSize = charBH.size();
        for (int i = 0; i < heapSize; i++) {

            System.out.println(charBH.poll());
        }

        BinaryHeap<String> strBH = new BinaryHeap<>();


        System.out.println("_String Words Queue_\nextraordinary \ncontribution"+
                "\nattention\nconvenience\nextraordinary\ncertification\n" +
                "\nSorting alphabetically:");
        strBH.offer("extraordinary");
        strBH.offer("contribution");
        strBH.offer("attention");
        strBH.offer("convenience");
        strBH.offer("extraordinary");
        strBH.offer("certification");

        heapSize = strBH.size();
        for (int i = 0; i < heapSize; i++) {

            System.out.println(strBH.poll());
        }
    }
}
