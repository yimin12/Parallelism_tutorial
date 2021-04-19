package Homework_12.Question_4;

import Homework_6.Question_3.Employee;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/4/19 15:53
 *   @Description :
 *
 */
public class CaseStudy {

    private static final String DIR = "E:\\Dev_Software\\test\\Parallel_2021\\src\\Homework_12\\Question_4\\test.txt";

    private static class OutputAction extends RecursiveAction {

        private static final long serialVersionUID = -196522408291343951L;
        private final List<Employee> employees;

        public OutputAction(List<Employee> employees){
            this.employees = employees;
        }

        @Override
        protected void compute() {
            if(employees.size() == 1){
                save(employees.get(0));
            } else {
                for(final Employee e : employees){
                    List<Employee> cur = new ArrayList<>();
                    cur.add(e);
                    ForkJoinTask.invokeAll(new OutputAction(cur));
                }
            }
        }
    }

    public static void parallelSave(){
        final ForkJoinPool pool = new ForkJoinPool();
        try {
            List<Employee> employees = generateEmployee(10000);
            pool.invoke(new OutputAction(employees));
        } finally {
            pool.shutdown();
        }
    }

    private static void save(Employee input) {

        try (FileOutputStream fos = new FileOutputStream(new File(DIR));
             ObjectOutputStream obs = new ObjectOutputStream(fos)) {
            obs.writeObject(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static List<Employee> generateEmployee(int num) {

        return Stream.iterate(0, n -> n + 1)
                .limit(num)
                .map(x -> {
                    return new Employee(
                            generateRandomName(4),
                            generateRandomAge(15, 100),
                            generateRandomSalary(900.00, 200_000.00)
                    );
                })
                .collect(Collectors.toList());

    }

    private static String generateRandomName(int length) {

        return new Random()
                .ints(5, 97, 122) // 97 = a , 122 = z
                .mapToObj(x -> String.valueOf((char) x))
                .collect(Collectors.joining());

    }

    private static int generateRandomAge(int min, int max) {
        return new Random()
                .ints(1, min, max)
                .findFirst()
                .getAsInt();
    }

    private static BigDecimal generateRandomSalary(double min, double max) {
        return new BigDecimal(new Random()
                .doubles(1, min, max)
                .findFirst()
                .getAsDouble()).setScale(2, RoundingMode.HALF_UP);
    }
}
