#include <stdio.h>

int main() {
    int n;
    scanf("%d", &n);

    if (n == 3) {
        printf("-1");
    } else if (n % 2 == 1) {
        printf("%d\n", n - 2);
        for (int i = 1; i < n - 2; i++)
            printf("%d\n", i);
        printf("%d\n", n);
        printf("%d\n", n - 1);
    } else {
        printf("%d\n", n / 2);
        for (int i = 1; i < n / 2; i++)
            printf("%d\n", i);
        for (int i = (n / 2 + 2); i <= n; i++)
            printf("%d\n", i);
        printf("%d\n", (n / 2) + 1);
    }

    return 0;
}
