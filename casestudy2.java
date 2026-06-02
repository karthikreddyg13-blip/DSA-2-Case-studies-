public class SegmentTree {

    static int[] marks = {78, 90, 65, 85, 92, 74, 88, 95};

    public static void main(String[] args) {

        int sum = 0;
        int max = marks[0];

        for(int i = 2; i <= 6; i++) {
            sum += marks[i];
            if(marks[i] > max)
                max = marks[i];
        }

        System.out.println("Range Sum = " + sum);
        System.out.println("Maximum Marks = " + max);
    }
}
