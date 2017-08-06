#include <stdio.h>
#include <time.h>

void getEratos(int num) {
    int *sieve;
    sieve = (int *) malloc(sizeof(int) * num);

    // 입력받은 수 만큼 배열에 모두 초기화 해둔다
    int i, j;
    for (i = 2; i <= num; i++) {
        sieve[i] = 0;
    }
    
    for (i = 2; i <= num; i++) {
        if(sieve[i] == 0) {
            for (j = 2; i*j <= num; j++) {
                sieve[i*j] = 1; // 소수가 아닌 경우 1을 넣어둔다
            }
        }
    }
    
    // 출력
    for (i = 2; i<= num; i++) {
        if (sieve[i] == 0) {
            printf("%d ", i);
        }
    }
}

int main(void) {
    int num;
    printf("input a number : ");
    scanf("%d", &num);
    time_t startTime = 0, endTime = 0;
    startTime = clock();
    getEratos(num);
    endTime = clock();
    //float gapTime = (float)(endTime-startTime)/(CLOCKS_PER_SEC);
    printf("\n<elapsed time> : %.4f", (float)(endTime-startTime)/(CLOCKS_PER_SEC));
    return;
}
