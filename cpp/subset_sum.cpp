#include <iostream>
#include <numeric>
#include <algorithm>
using namespace std;
bool search(int arr[], int last) {
	for (int i = 0; i <= last; i++) {
		if (arr[i] == 1) return true;
	}
	return false;
}
int is_subset_sum(int arr[], int helper[], int current_sum, int ptr, int last, int sum) {
	if (ptr == -1) {
		if (/*accumulate(helper, helper + last, 0) != 0 && */search(helper, last) && current_sum == sum) return 1;
		else return 0;
	}
	else {
		helper[ptr] = 1;
		int fun1 = is_subset_sum(arr, helper, current_sum + arr[ptr], ptr - 1, last, sum);
		helper[ptr] = 0;
		int fun2 = is_subset_sum(arr, helper, current_sum, ptr - 1, last, sum);
		return (fun1 + fun2);
	}
}

int main() {
	int t;
	cin >> t;
	while (t--) {
		int N;
		cin >> N;
		int *arr = new int[N];
		for (int i = 0; i < N; i++) {
			cin >> arr[i];
		}
		int sum;
		//cin >> sum;
		int *helper = new int[N];
		int value = is_subset_sum(arr, helper, 0, N-1, N-1, 0);
		
		if (value > 0) cout << "Yes" << endl;
		else cout << "No" << endl;
	}
}