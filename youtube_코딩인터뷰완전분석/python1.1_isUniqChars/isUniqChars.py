def isUniqChars(str_data):
    return len(set(str_data)) == len(list(str_data))

print(isUniqChars("asdbqwe1234"))