/* @author "Arthur Gramiscelli Branco"
   Created on 24/05/2019
   Updated on 18/04/2020
   This class gets the system time on instantiation and it's methods
   can be used to calculate final time
*/

package util;

public class Timer {

    private long startingTimeMili;
    private long startingTimeNano;
    private long totalTime;

    public Timer() {
        this.startingTimeMili = System.currentTimeMillis();
        this.startingTimeNano = System.nanoTime();
    }

    public long getTotalTimeInNano() {
        this.totalTime = System.nanoTime() - startingTimeNano;
        return totalTime;
    }

    public long getTotalTimeInMillis() {
        this.totalTime = System.currentTimeMillis() - startingTimeMili;
        return totalTime;
    }

    public long getTotalTimeInSeconds() {
        return getTotalTimeInMillis() / 1000;
    }

    public long getTotalTimeInMinutes() {
        return getTotalTimeInSeconds() / 60;
    }

    public long getTotalTimeInHours() {
        return getTotalTimeInMinutes() / 60;
    }

    public String getTotalTime() {
        StringBuilder totalTime = new StringBuilder();
        if(getTotalTimeInHours()!=0) {
            totalTime.append(getTotalTimeInHours() + " h, ");
        }if(getTotalTimeInMinutes()!=0) {
            totalTime.append((getTotalTimeInMinutes() - 60*getTotalTimeInHours()) + " min, ");
        }if(getTotalTimeInSeconds()!=0) {
            totalTime.append((getTotalTimeInSeconds() - 60*getTotalTimeInMinutes()) +  " seg, ");
        }if(getTotalTimeInMillis()!=0) {
            totalTime.append((getTotalTimeInMillis() - 1000*getTotalTimeInSeconds()) + " milliseg.");
        }
        return totalTime.toString();
    }

    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}