#include <iostream>
using namespace std;
void MaxSubArray(long int nums[], int size);
int main()
{
	//std::cout << "Hello World!\n";
	int t;
	cin >> t;

	while (t--) {
		int N;
		long int* arr;
		cin >> N;
		arr = new long int[N];
		for (int i = 0; i < N; i++) {
			cin >> arr[i];
		}

		MaxSubArray(arr, N);
		cout << endl;
	}
}

void MaxSubArray(long int nums[], int size)
{

	long currentSum = 0, maxSum = 0;
	for (int i = 0; i < size; i++)
	{
		if (currentSum < 0)
		{
			currentSum = 0;
		}

		currentSum += nums[i];

		if (currentSum > maxSum)
		{
			maxSum = currentSum;
		}
	}
	//if (maxSum == 0 && nums.Sum() < 0) { return nums.Max(); }
	cout << maxSum;
}