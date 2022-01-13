public class Experiments {

    public static void main(String[] args) {
        String date = String.valueOf(java.time.LocalDate.now());
        System.out.println("Today is: " + date);

        String timeToMillis = String.valueOf(java.time.LocalTime.now());
        System.out.println("The time at the moment is: " + timeToMillis);

        long millis = System.currentTimeMillis();
        java.util.Date dateAndTime = new java.util.Date(millis);
        System.out.println("Date and time is: " + dateAndTime);
    }
}
