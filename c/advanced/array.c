#include <stdio.h>

void calculatePercentage() {
	int m1, m2, m3;

	int size = 3;
	int percentage[size];

	for (int i=0; i<size; i++) {
		printf("Enter marks:\n");
		scanf("%d%d%d", &m1, &m2, &m3);
		percentage[i] = (m1+m2+m3)/3;
	}

	for (int i=0; i<size; i++) {
		printf("percentage of student %d is %d\n", i, percentage[i]);
	}
}

void modifyArray(int *arr, int n) {
	for (int i=0; i<n; i++) {
		arr[i] *= 3;
	}
}

int main() {
	int arr[] = {-9, 3, -18, 6};
	int n = sizeof(arr)/sizeof(arr[0]);

	modifyArray(arr, n);

	for (int i=0; i<n; i++) {
		printf("%d=%d\n", i, arr[i]);
	}
}
