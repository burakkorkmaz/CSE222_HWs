package tr.edu.gtu.bkorkmaz.singleLinkedList;

public class Main {

    public static void main(String[] args) {
        SingleLinkedList<Integer> LL = new SingleLinkedList<>();
        LL.add(0,1);
        LL.add(1,2);
        LL.add(2,3);
        LL.add(3,4);
        LL.add(4,5);
        LL.add(5,6);
        LL.add(6,7);
        LL.add(7,8);
        LL.add(8,9);
        LL.add(9,10);


        System.out.println(LL.toString());


        LL.remove(5);

        for (int i = 0; i < LL.size(); i++) {

            System.out.println(LL.get(i));
        }
    }


}
