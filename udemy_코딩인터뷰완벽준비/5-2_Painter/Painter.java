public class Painter {
    public static void paint(int[][] image, int x, int y, int newC) {
        paintRec(image, x, y, newC, image[x][y]); // 배열 구조상은 [y][x]가 맞음
    }
    public static void paintRec(int[][] image, int x, int y, int newC, int oldC) {
        if(image[x][y] != oldC)
            return;
        if(x<0 || y<0 || x>image.length-1 || y>image[0].length-1) //이중배열 length Check 주의
            return;
            
        image[x][y] = newC;
        paintRec(image, x-1, y, newC, oldC);
        paintRec(image, x, y-1, newC, oldC);
        paintRec(image, x+1, y, newC, oldC);
        paintRec(image, x, y+1, newC, oldC);
    }
}