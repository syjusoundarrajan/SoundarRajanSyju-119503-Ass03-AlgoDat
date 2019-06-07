
public class MergeSort {

	
	int[] array, TempMergeArr;
	int len;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inputarray= {46,45,87,32,84};
		MergeSort MS = new MergeSort();
		MS.sort(inputarray);
	}
	private void sort(int[] inputarray) {
		
		this.array=inputarray;
		this.len=inputarray.length;
		this.TempMergeArr=new int[len];
		divideArray(0,len-1);
		
	}
	private void divideArray(int LowInd, int HighInd) {
		// TODO Auto-generated method stub
		if(LowInd<HighInd){
			int mid = LowInd+(HighInd-LowInd)/2;
			
			//Left
			divideArray(LowInd,mid);
			
			//Right
			divideArray(mid+1, HighInd);
			
			MergeArray(LowInd, mid, HighInd);
			
		}
	}
	private void MergeArray(int LowInd, int mid, int HighInd) {
		for(int i=LowInd;i<=HighInd;i++) {
			TempMergeArr[i]=array[i];
			
		}
		int i=LowInd, j= mid+1, k= LowInd;
		while(i<=mid  && j<=HighInd) {
			if(TempMergeArr[i] <= TempMergeArr[j]) {
				array[k]= TempMergeArr[i];
				i++;
			}
			else {
				array[k] = TempMergeArr[j];
				j++;
			}
			k++;
		}
		while(i<mid)
		{
			array[k] = TempMergeArr[i];
			k++;
			i++;
		}
		// TODO Auto-generated method stub
		
	}
	

}

