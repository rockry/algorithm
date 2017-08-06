# -*- coding: utf-8 -*-
import sys, time, timeit

def getEratos(num) :
    #init
    sieve = {}
    for i in range(2, N+1):
        sieve[i] = 0
        
    # Sieve of Eratosthenes
    for i in range(2, N+1):
        if sieve[i]==0:
            n=2
            while i*n <= N:
                sieve[i*n]=1
                n+=1

    #print results
    for i in range(2, N+1):
        if sieve[i]==0:
            print( i, end=" " )

if __name__=="__main__":
    print( sys.version )
    N = int( input("input a number : ") )
    #start = time.time()
    start = timeit.default_timer()
    getEratos(N)
    #end = time.time() - start
    end = timeit.default_timer()
    print("\n<elapsed time> : ", round(end - start, 4))
    #input("press any key")

