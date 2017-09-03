def anagram_tmp(str1, str2):
    if len(str1) != len(str2):
        return False
    if sorted(str1) != sorted(str2):
        return False
    return True
    
def anagram_new(str1, str2):
    if ''.join(sorted(str1.lower())).strip() != ''.join(sorted(str2.lower())).strip():
        return False
    return True
    
print(anagram_new("abc de", "b  cedA"))
print(anagram_new("abcde", "bcedk"))