import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculations = true;

        while (continueCalculations) {
            System.out.print("Enter the number of subjects: ");
            int numSubjects = scanner.nextInt();

            int totalMarks = 0;
            int[] marks = new int[numSubjects];

            // Input marks for each subject
            for (int i = 0; i < numSubjects; i++) {
                System.out.print("Enter marks obtained in subject " + (i + 1) + ": ");
                marks[i] = scanner.nextInt();
                totalMarks += marks[i];
            }

            // Calculate average percentage
            double averagePercentage = (double) totalMarks / numSubjects;

            // Grade calculation
            char grade;
            if (averagePercentage >= 90) {
                grade = 'A';
            } else if (averagePercentage >= 80) {
                grade = 'B';
            } else if (averagePercentage >= 70) {
                grade = 'C';
            } else if (averagePercentage >= 60) {
                grade = 'D';
            } else {
                grade = 'F';
            }

            // Display results
            System.out.println("\nResults:");
            System.out.println("Total Marks: " + totalMarks);
            System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
            System.out.println("Grade: " + grade);

            // Ask if the user wants to continue
            System.out.print("\nDo you want to calculate grades for another student? (yes/no): ");
            String choice = scanner.next();
            if (!choice.equalsIgnoreCase("yes")) {
                continueCalculations = false;
            }
        }

        scanner.close();
        System.out.println("Program terminated.");
    }
}
