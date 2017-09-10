public class SwitchBoard {
    int[] storedNum;
    public SwitchBoard() {
        storedNum = new int[10*1000*1000/32];
    }
    public void store(String phoneNumber) {
        int num = Integer.parseInt(phoneNumber);
        storedNum[num/32] = storedNum[num/32] | 1<<(num%32);
    }
    public boolean exist(String phoneNumber) {
        int num = Integer.parseInt(phoneNumber);
        return (storedNum[num/32] & 1<<(num%32)) != 0;
    }
    public static void main(String[] args) {
        SwitchBoard sw = new SwitchBoard();
        // sw.store("1234567");
        // sw.store("0000010");

        // System.out.println(sw.exist("5555555"));
        // System.out.println(sw.exist("1234567"));
        // System.out.println(sw.exist("0000010"));

        int max = -1>>>1;
        System.out.println(Integer.toBinaryString(max));
    }
    
}