package Home_Tasks.HT_19;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.add(25);
        tree.add(36);
        tree.add(12);
        tree.add(1);
        tree.add(77);
        tree.printTree();
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите целое число n, длоя поиска в дереве");
        int n = iScanner.nextInt();
        if (tree.contains(n)) System.out.println("Цифра в дереве есть");
        else System.out.println("Цифры в дереве нет");
    }
}
