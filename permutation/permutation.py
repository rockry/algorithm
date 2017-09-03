#순열은 for문으로 만드려면 for문을 n-1만큼 돌려야 된다. 총 갯수 = n*(n-1)*...*1
def perm_for(input):
    for i in range(len(input)): # 첫번째 for문은 첫번째 원소를 선택
        input[0], input[i] = input[i], input[0]
        for j in range(1,len(input)): # 두번째 for문은 두번째 원소를 선택
            input[1], input[j] = input[j], input[1]
            print(input)
            input[1], input[j] = input[j], input[1] # 원래대로 복구시켜줘야 된다.
        input[0], input[i] = input[i], input[0] # 원래대로 복구시켜줘야 된다.

#순열을 회기문으로 만들면 자동으로 n*(n-1)*...*1 순서로 돌게 할 수 있다.
def perm(input, i):
    # print("entry:", input, i)
    n = len(input)
    if i == n - 1:
        print(input)
    else:
        for j in range(i, n): # (n - i)반복
            input[i], input[j] = input[j], input[i] #이번 회기의 첫원소(아직 확정되지 않은 원소)와 다음원소들(j)을 하나씩 교환 
            # print("i=", i," j=",j)
            perm(input, i + 1) # 다음번 회기는 i+1부터 n까지 즉 (n-i)번 for문을 반복한다.
            input[i], input[j] = input[j], input[i] # 원래대로 복구
            # print("last:", input, i, j)


perm_for([1,2,3])
print()
perm([1,2,3], 0)
