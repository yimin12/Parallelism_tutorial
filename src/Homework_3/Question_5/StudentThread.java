package Homework_3.Question_5;


import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/2/3 18:09
 *   @Description :
 *
 */
public class StudentThread extends Thread implements Runnable{

    private Student student; // one student per student thread
    private final static String path = "src/Homework_3/Question_5/FinalGrades.txt";
    private Map<Integer, List<Integer>> map; // key : scores  , value : thread id
    private Object lock;
    private GraderThread grader;

    public StudentThread(Student student, Object lock, Map<Integer, List<Integer>> map, GraderThread grader) throws InterruptedException {
        this.map = map;
        this.student = student;
        this.student.init();
        this.map.put(this.student.getId(),student.getScores()); // regard student's id as thread id
        this.grader = grader;
        this.lock = lock;
    }

    public enum CHOICE {
        ONE, TWO, THREE, FOUR, FIVE
    }

    public void generateScoreInMap(CHOICE choice){
        synchronized (lock) {
            List<Integer> scores = student.getScores();
            switch (choice){
                case ONE:
                    student.generateHomeword();
                    scores.set(0, student.getHomework());
                case TWO:
                    student.generateQuiz();
                    scores.set(1, student.getQuiz());
                case THREE:
                    student.generateMidterm();
                    scores.set(2, student.getMidterm());
                case FOUR:
                    student.generateProject();
                    scores.set(3, student.getProject());
                case FIVE:
                    student.generateFinal();
                    scores.set(4, student.getFinal_score());
            }
        }

    }

    public void writeToFile(Student student) throws IOException {
        File file = new File(path);
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
        BufferedWriter bw = new BufferedWriter(fw);
        String formatted = "Thread_" + student.getId() + "\t" + student.getFormatted();
        bw.write(formatted + "\n");
        bw.close();

    }

    public void readGrade() throws InterruptedException {
        synchronized(lock){
            if(!grader.getFlag()){
                lock.wait();
            }
            try(BufferedReader br = new BufferedReader(new FileReader(path))){
                String line;
                StringBuffer sb = new StringBuffer(); // should not use StringBuilder here
                while((line = br.readLine())!=null){
                    String formatted = line + " " + " and message is from thread_" + student.getId();
                    System.out.println(formatted);
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        CHOICE choice = CHOICE.ONE;
        try{
            while(true){
                generateScoreInMap(choice);
                choice = CHOICE.TWO;
                TimeUnit.SECONDS.sleep(1);
                generateScoreInMap(choice);
                choice = CHOICE.THREE;
                TimeUnit.SECONDS.sleep(1);
                generateScoreInMap(choice);
                choice = CHOICE.FOUR;
                TimeUnit.SECONDS.sleep(1);
                generateScoreInMap(choice);
                choice = CHOICE.FIVE;
                TimeUnit.SECONDS.sleep(1);
                generateScoreInMap(choice);
                TimeUnit.SECONDS.sleep(1);
                this.map.put(this.student.getId(),student.getScores());
                break;
            }
            readGrade();
        } catch (InterruptedException ioException) {
            ioException.printStackTrace();
        }
    }
}
