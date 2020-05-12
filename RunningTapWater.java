package practice;

public class RunningTapWater {

	public static void main(String[] args) {
		int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
		int result = 0;
		int leftArray[] = new int[arr.length];
		int rightArray[] = new int[arr.length];
		
		if(arr.length <= 2 || arr == null) {
			result = 0;
		}
		
		//traverse left array
		int max = arr[0];
		leftArray[0]= arr[0];
		for(int i = 1 ; i < arr.length ; i++) {
			if(arr[i]<max) {
				leftArray[i] = max;
			}else {
				max = arr[i];
				leftArray[i] = max;
			}
		}
		
		//traverse right array
		rightArray[arr.length - 1] = arr[arr.length - 1];
		max = arr[arr.length - 1];
		for(int i = arr.length-2 ; i >= 0 ; i--) {
			if(arr[i]<max) {
				rightArray[i] = max;
			}else {
				max = arr[i];
				rightArray[i] = max;
			}
		}
		
		for(int i = 0 ; i < arr.length ; i++) {
			result = result + Math.min(leftArray[i], rightArray[i]) - arr[i];
		}
		
		System.err.println("Water to be tapped : " + result);

	}

}
