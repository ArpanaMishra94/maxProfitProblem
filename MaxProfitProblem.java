import java.util.*;
public class MaxProfitProblem {
    static int[] timeUnits;
    static int[] earnings;
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

		System.out.println("Enter targetTime");
		targetTime = sc.nextInt();

		Infrastructure res = new Infrastructure();
		
		util (targetTime, 0, res, new int[3]);

		if (res.infra.size() == 0) {
		    System.out.print("T: " + 0 + " " + "P: " + 0 + " " + "C: " + 0);
		}
		else {
		    System.out.println("Total Profit: " + res.earnings);
		    for (int i = 0; i < res.infra.size(); i++) {
		       System.out.print("T: " + res.infra.get(i)[0] + " " + "P: " + res.infra.get(i)[1] + " " + "C: " + res.infra.get(i)[2]);
		       System.out.println();
		    }
		}
 	}
 	public static void util (int time, int money, Infrastructure res, int[] arr) {
 	    if(money == res.earnings) {
 	        int[] arrClone = new int[3];
 	        for (int i = 0; i < 3; i++) {
 	            arrClone[i] = arr[i];
 	        }
 	        res.infra.add(arrClone);
 	    }
 	   
 	    if(money > res.earnings) {
 	        res.earnings = money;
 	        res.infra.clear();
 	        int[] arrClone = new int[3];
 	        for (int i = 0; i < 3; i++) {
 	            arrClone[i] = arr[i];
 	        }
 	        res.infra.add(arrClone);
 	     }
 	     
 	    for (int i = 0; i < 3; i++) {
 	        if (timeUnits[i] < time) {
 	            arr[i] += 1;
 	            util(time - timeUnits[i], money + (time - timeUnits[i])*earnings[i], res, arr);
 	            arr[i] -= 1;
 	        }
 	    }
 	}
}

class Infrastructure {
    public int earnings;
    public ArrayList<int[]> infra;
    
    public Infrastructure () {
        this.earnings = 0;
        this.infra = new ArrayList<>();
    }
}