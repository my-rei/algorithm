#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	int num, mid; int i = 0; int newnum = -1;
	scanf("%d", &num);
	int ori = num;

	while (newnum != ori) {
		if (newnum != -1) num = newnum;
		mid = num % 10 + num / 10;
		newnum = (num % 10) * 10 + mid % 10;
		i++;
	}

	printf("%d\n", i);
}