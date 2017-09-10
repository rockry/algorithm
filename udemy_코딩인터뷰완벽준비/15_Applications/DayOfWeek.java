public class DayOfWeek {
    public static int getDayOfWeek(int month, int day) {
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = 0;
        for(int i = 1; i < month; i++) {
            days += daysInMonth[i];
        }
        days += day;
        days += 5;
        return days % 7;
    }
}