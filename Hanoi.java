import java.util.Scanner;
class Hanoi {
    static void hanoi(int limit, char src, char tmp, char dst) {
        if(limit == 1) {
            return;
        } else {
            hanoi(limit - 1, src, dst, tmp);
            System.out.printf("Move Disk %d From %c To %c\n",
                    limit, src, dst);
            hanoi(limit - 1, tmp, src, dst);
            return;
        }
    }
    public static void main(String[] args) {
        char src_tower = 'A', tmp_tower = 'B', dst_tower = 'C';
        int limit;
        System.out.printf("\nEnter The Number of Disks:\t");
        Scanner scanner = new Scanner(System.in);
        limit = scanner.nextInt();
        System.out.printf("\nSequence of Disks:\n");
        hanoi(limit, src_tower, tmp_tower, dst_tower);
        System.out.printf("\n");
    }
}