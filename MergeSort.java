import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

class MergeSort
{
	
	void merge(int arr[], int l, int m, int r)
	{
		int n1 = m - l + 1;
		int n2 = r - m;
		int L[] = new int[n1];
		int R[] = new int[n2];
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];
		int i = 0, j = 0;
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			}
			else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
	void sort(int arr[], int l, int r)
	{
		if (l < r) {
			int m =l+ (r-l)/2;
			sort(arr, l, m);
			sort(arr, m + 1, r);
			merge(arr, l, m, r);
		}
	}
	static void printArray(int arr[])
	{
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	static void printArray(String arr[])
	{
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
public static void main(String args[])
	{
		try {
			int threshold=1000;
			File object = new File("number.txt");
			Scanner reader = new Scanner(object);
			List<String> numbers = new ArrayList<>();
			boolean flag = false;
			int i=0;
			while(i<threshold && reader.hasNextLine())
			{
				String arr = reader.nextLine();
				String[] string = arr.split(",");
				for(String number : string ){
					numbers.add(number);
					i++;
					if(i>=threshold)
					{
						flag = true;
						break;
					}
				}
				if(flag) break;

			}

			int data[] =new int[threshold];
			for(int j=0;j<numbers.size();j++)
				data[j]=Integer.parseInt(numbers.get(j));

			System.out.print("\nInteger array : " + Arrays.toString(data));


			long lStartTime = new Date().getTime();
			MergeSort ob = new MergeSort();
			ob.sort(data, 0, data.length - 1);
			System.out.println("\nSorted array");
			printArray(data);
			long lEndTime = new Date().getTime();
			long difference = lEndTime - lStartTime;
			System.out.println("Elapsed milliseconds: " + difference);
			reader.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("An error has occurred.");
			e.printStackTrace();
		}
	}
}