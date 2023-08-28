import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class MaxAttendanceTest {

    // Constructs an ArrayList of CourseActivity

    private ArrayList<CourseActivity> createSchedule(int[] days, int[] startTimes, int[] endTimes, int[] studentNumbers) {
        ArrayList<CourseActivity> schedule = new ArrayList<>();
        for (int i = 0; i < startTimes.length; i++) {
            schedule.add(new CourseActivity("", "", days[i], startTimes[i], endTimes[i], studentNumbers[i], ""));
        }
        return schedule;
    }

    @Test
    public void testCase01() {
        int[] days = {1, 1, 1, 2};
        int[] startTimes = {10, 14, 15, 9};
        int[] endTimes = {11, 16, 17, 11};
        int[] studentNumbers = {10, 25, 15, 35};
        MaxAttendance maxAtt = new MaxAttendance(createSchedule(days, startTimes, endTimes, studentNumbers));
        assertEquals(40, maxAtt.maxAttendance());

    }
    @Test
    public void testCase02() {
        int[] days = {1, 1, 1, 2,2, 2,2};
        int[] startTimes = {10, 14, 15, 9,13,16,19};
        int[] endTimes = {11, 16, 17, 11,17,18,20};
        int[] studentNumbers = {10, 25, 15, 35,50,30,20};
        MaxAttendance maxAtt = new MaxAttendance(createSchedule(days, startTimes, endTimes, studentNumbers));
        assertEquals(80, maxAtt.maxAttendance());

    }
    @Test
    public void testCase03() {
        int[] days = {         3,3,3,3};
        int[] startTimes = {   9,10,11,15};
        int[] endTimes = {    12,11,14,18};
        int[] studentNumbers = {30,20,40,20};
        MaxAttendance maxAtt = new MaxAttendance(createSchedule(days, startTimes, endTimes, studentNumbers));
        assertEquals(70, maxAtt.maxAttendance());

    }
    @Test
    public void testCase04() {
        int[] days = {1,1,1};
        int[] startTimes = {10,11,12};
        int[] endTimes = {19,17,15};
        int[] studentNumbers = {20,20,80};
        MaxAttendance maxAtt = new MaxAttendance(createSchedule(days, startTimes, endTimes, studentNumbers));
        assertEquals(120, maxAtt.maxAttendance());

    }

    // Add your own test cases
    @Test
    public void testCase05() {
        int[] days = {4,4,4,4,4,4,4};
        int[] startTimes = { 8,9,12,14,15,16,17};
        int[] endTimes = {9,18,13,17,17,18,20};
        int[] studentNumbers = {  20,20,10,25,35,45,40};
        MaxAttendance maxAtt = new MaxAttendance(createSchedule(days, startTimes, endTimes, studentNumbers));
        assertEquals(125, maxAtt.maxAttendance());
    }

    @Test
    public void testCase06() {
        int[] days = {4,4,4,4,4,4,4,4,4,4};
        int[] startTimes = { 8,9,12,14,15,16,18,19,20,22};
        int[] endTimes = {9,22,13,17,17,17,22,23,22,23};
        int[] studentNumbers = {  20,20,10,25,35,45,40,100,20,100};
        MaxAttendance maxAtt = new MaxAttendance(createSchedule(days, startTimes, endTimes, studentNumbers));
        assertEquals(200, maxAtt.maxAttendance());
    }
    @Test
    public void testCase07() {
        int[] days = {1,1,1,1};
        int[] startTimes = {18,19,20,22};
        int[] endTimes = {22,23,22,23};
        int[] studentNumbers = { 40,100,20,100};
        MaxAttendance maxAtt = new MaxAttendance(createSchedule(days, startTimes, endTimes, studentNumbers));
        assertEquals(200, maxAtt.maxAttendance());
    }
    @Test
    public void testCase08() {
        int[] days = {1, 1, 1, 2};
        int[] startTimes = {10, 14, 17, 9};
        int[] endTimes = {11, 16, 18, 11};
        int[] studentNumbers = {10, 25, 15, 35};
        MaxAttendance maxAtt = new MaxAttendance(createSchedule(days, startTimes, endTimes, studentNumbers));
        assertEquals(35, maxAtt.maxAttendance());

    }
    @Test
    public void t() {
        int[] days = {7, 6, 5, 7, 6, 5, 7, 6, 5};
        int[] startTimes = {0, 0, 0, 1, 1, 1, 2, 2, 2};
        int[] endTimes = {1, 1, 1, 2, 2, 2, 3, 3, 3};
        int[] studentNumbers = {1, 1, 10000, 2, 12000, 11000, 3, 1, 9000};
        MaxAttendance maxAtt = new MaxAttendance(createSchedule(days, startTimes, endTimes, studentNumbers));
        System.out.println(maxAtt.maxAttendance());
    }
    @Test
    public void t1() {
        int[] days = {7};
        int[] startTimes = {23};
        int[] endTimes = {24};
        int[] studentNumbers = {1};
        MaxAttendance maxAtt = new MaxAttendance(createSchedule(days, startTimes, endTimes, studentNumbers));
        System.out.println(maxAtt.maxAttendance());
    }

}
