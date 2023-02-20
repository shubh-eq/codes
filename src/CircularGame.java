import java.util.*;

public class CircularGame {

    public static int getWinnerIndex(String[] contestant, int[] songStopsInSec){
        int contestantsLeft = contestant.length;

        int contestantIter = 0;
        int timeIter = 0;
        int currCount = 0;
        while(contestantsLeft>1){

            contestantIter = (contestantIter+1)%contestant.length;

            if(contestant[contestantIter]!=null){
                currCount++;
            }
            if(currCount==songStopsInSec[timeIter]){
                System.out.println("Contestant: "+contestant[contestantIter]+" at index:"+timeIter+" has been eliminated");
                contestant[contestantIter] = null;
                currCount=-1;
                contestantsLeft--;
                timeIter = (timeIter + 1)%songStopsInSec.length;
            }
            if(contestantsLeft==1){
                break;
            }
        }

        int result=-1;
        for(int i=0; i<contestant.length; i++){
            if(contestant[i]!=null){
                result=i;
                break;
            }
        }
        return result;
    }

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of Contestants:");
        int contestantLen = sc.nextInt();
        sc.nextLine();

        String[] contestant = new String[contestantLen];
        for(int i=0; i<contestantLen; i++){
            contestant[i] = sc.nextLine();
        }

        System.out.println("Enter number of StopTimes:");
        int stopLen = sc.nextInt();
        sc.nextLine();

        int[] songStopInSec = new int[stopLen];
        for(int i=0; i<stopLen; i++){
            songStopInSec[i] = sc.nextInt();
        }


        int winnerIndex = getWinnerIndex(contestant, songStopInSec);
        System.out.println("Winner Index: "+ winnerIndex);

        sc.close();
    }
}
