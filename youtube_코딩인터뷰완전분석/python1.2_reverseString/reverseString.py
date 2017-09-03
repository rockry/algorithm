def reverseString(str_data):
    return str_data[::-1]

def reverseString2(str_data):
    stack = []
    for ch in str_data:
        stack.append(ch)
        
    result = ""
    while len(stack) > 0:
        result += stack.pop()
    return result
    
print(reverseString2("asdbqwe1234"))