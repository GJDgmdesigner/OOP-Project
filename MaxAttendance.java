import java.util.ArrayList;

public class MaxAttendance {

    private ALBinHeap<CourseActivity> minPQ1;             //Class CourseActivity to represent a course activity in a university.
    private ALBinHeap<CourseActivity> minPQ2;             //set up 2 course activity arraylist
	

    // LAB 14 PART B MAX ATTENDANCE

    public int maxAttendance() {
        int totalNum = 0;                               // store return num
        int currentNum = 0;                             //

        while (!minPQ1.isEmpty()){
            CourseActivity start = minPQ1.getMin();      //get earliest store course start time object
            CourseActivity end = minPQ2.getMin();        //get earliest store course end time object

            //System.out.println("start: "+start.getNumStudents());
            //System.out.println("end: "+end.getNumStudents());

            if (start.getDay()*24 + start.getStartTime() < end.getDay()*24 + end.getEndTime()){          // compare the start and end hours( turn to 24h), if earlist start time class ealiear tham earlist end time class, 那么两者就重叠了
                currentNum = currentNum + start.getNumStudents();                                        // update currentnum, add nums of this early start point class students num
                if (totalNum < currentNum){
                    totalNum = currentNum;                                                                // if present maximum student smaller than new maximum student, updata max
                }
                minPQ1.delMin();                                                                          // delete object from start time arraylist, start next loop

            } else {
                currentNum = currentNum - end.getNumStudents();                                           // UPDATA CURRENT
                minPQ2.delMin();
            }
           // System.out.println("currentnum: "+currentNum);
           // System.out.println("totalnum: "+totalNum);
        }

        return totalNum;                               // return the maximum attendance of students

    }


    public MaxAttendance(ArrayList<CourseActivity> activities) {
        minPQ1 = new ALBinHeap<>();
        minPQ2 = new ALBinHeap<>();
        // for start time
        for(CourseActivity activity: activities){

            this.minPQ1.add(activity, activity.getDay()*24+          // fill minPQ1 arraylist start time as priority
                    activity.getStartTime());
        }

        // for end time
        for (CourseActivity activity: activities) {

            this.minPQ2.add(activity, activity.getDay()*24+         // fill minPQ2 arraylist end time as priority
                    activity.getEndTime());
        }

    }





}
