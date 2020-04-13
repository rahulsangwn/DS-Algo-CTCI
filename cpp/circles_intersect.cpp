#include <iostream>
#include <algorithm>

using namespace std;

struct circle {
	int center;
	int radius;
	int start;
	int end;
};
bool mycomparer(circle c1, circle c2) {
	if (c1.end == c2.end) return c1.start < c2.start;
	else return c1.end < c2.end;
}
int main() {
	int N;
	cin >> N;

	circle *mycircle = new circle[N];
	
	for (int i = 0; i < N; i++) {
		cin >> mycircle[i].center;
		cin >> mycircle[i].radius;
		mycircle[i].start = mycircle[i].center - mycircle[i].radius;
		mycircle[i].end = mycircle[i].center + mycircle[i].radius;
	}

	sort(mycircle, mycircle + N, mycomparer);

	int i = 0, j = 1, count = 0;
	while (j < N) {
		if (mycircle[i].end <= mycircle[j].start) {
			i = j;
		}
		else {
			count++;
		}
		j++;
	}
	cout << count;
}
