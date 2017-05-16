package tr.edu.gtu.bkorkmaz;

public class Main {

    public static void main(String[] args) {

        AVLTree<String> avl = new AVLTree<>();

        avl.add("nush");
        avl.add("ile");
        avl.add("uslanmayani");
        avl.add("etmeli");
        avl.add("tekdir");
        avl.add("tekdir");
        avl.add("ile");
        avl.add("uslanmayanin");
        System.out.println("------before adding hakki--------");
        System.out.println(avl.toString());
        avl.add("hakki");
        avl.add("kotektir");
        System.out.println("------after adding hakki--------");
        System.out.println(avl.toString());
        avl.add("edille");
        System.out.println("------Adding edille--------");
        System.out.println(avl.toString());
        avl.add("dakik");
        System.out.println("------Adding dakik--------");
        System.out.println(avl.toString());
        avl.add("ferc");
        System.out.println("------Adding ferc--------");
        System.out.println(avl.toString());
        System.out.println("-------Deleting hakki-------");
        avl.delete("hakki");
        System.out.println(avl.toString());
        System.out.println("-------Deleting ferc-------");
        avl.delete("ferc");
        System.out.println(avl.toString());
        System.out.println("-------Deleting etmeli-------");
        avl.delete("etmeli");
        System.out.println(avl.toString());
        System.out.println("--------------");



    }
}
