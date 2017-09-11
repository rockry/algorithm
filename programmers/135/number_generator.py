# x만큼 간격이 있는 n개의 숫자
def number_generator(x, n):
    return [x*(i+1) for i in range(n)]

print(number_generator(3,5))