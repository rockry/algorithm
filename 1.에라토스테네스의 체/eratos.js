var readline = require('readline');
var r = readline.createInterface({
    input:process.stdin,
    output:process.stdout
});

r.question("input a number : ", function(res) {
    var startTime = new Date().getTime();
    //console.time("elapsedTime")
    getEratos(res);
    //console.timeEnd("elapsedTime")
    var endTime = new Date().getTime();
    console.log("<elapsed time> : ", (endTime - startTime)/1000);
    r.close() // 반드시 close()를 해줘야 합니다. 
});

function getEratos(num) {
    num *= 1;
    if(!Number.isInteger(num)) {
        console.log("please input a number..");
        return;
    }
    var sieve = [];
    
    for (i = 2; i <= num; i++) {
        sieve[i] = 0;
    }
    
    for (i = 2; i <= num; i++) {
        if(sieve[i] === 0) {
            for (j = 2; i*j <= num; j++) { //i부터 시작해도 됨. for문을 num만큼 도는게 아니기 때문에 큰 영향 없음.
                sieve[i*j] = 1; // 소수가 아닌 경우 1을 넣어둔다
            }
        }
    }
    
    // 출력
    var totalNum = 0;
    for (i = 2; i<= num; i++) {
        if (sieve[i] == 0) {
            //process.stdout.write(i + " ");
           totalNum++;
        }
    }
    console.log("\ntotalNum = ", totalNum);
}

