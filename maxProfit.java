import java.util.*;
public class maxProfit {
    static int[] timeUnits;
    static int[] earnings;
    static int targetMoney;
    static int targetTime;
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);

		timeUnits = new int[3];
		timeUnits[0] = 5;
		timeUnits[1] = 4;
		timeUnits[2] = 10;

		earnings = new int[3];
		earnings[0] = 1500;
		earnings[1] = 1000;
		earnings[2] = 3000;

		System.out.println("Enter targetMoney");
		targetMoney = sc.nextInt();

		System.out.println("Enter targetTime");
		targetTime = sc.nextInt();

		ArrayList<int[]> res = new ArrayList<>();
		
		util (targetTime, targetMoney, res, new int[3]);

		if (res.size() == 0) {
		    System.out.print("T: " + 0 + " " + "P: " + 0 + " " + "C: " + 0);
		}
		else {
		    for (int i = 0; i < res.size(); i++) {
		       System.out.print("T: " + res.get(i)[0] + " " + "P: " + res.get(i)[1] + " " + "C: " + res.get(i)[2]);
		       System.out.println();
		    }
		}
 	}
 	public static void util (int time, int money, ArrayList<int[]> res, int[] arr) {
 	    if (time == 0 && money != targetMoney) {
 	        return;
 	    }
 	    if (money == 0) {
 	        res.add(arr);
 	        return;
 	    }
 	    for (int i = 0; i < 3; i++) {
 	        if (timeUnits[i] <= time) {
 	            arr[i] += 1;
              util (time - timeUnits[i], money - (time - timeUnits[i])*earnings[i], res, arr);
 	            arr = new int[3];
 	        }
 	    }
 	}
}
