import java.util.Scanner;

public class QuizGame {
	public static void main(String[] args) {
		int x = 5;

		x *= 2 + 3;
		System.out.printf("Your final score is: " + x);

		// Create a Scanner object to read user input

		// Create an array of questions and an array of answers
		String[] questions = {
				"What is the capital of France?\nA: Paris\nB: London\nC: Rome\nD: Berlin",
				"Which planet is known as the Red Planet?\nA: Venus\nB: Mars\nC: Jupiter\nD: Saturn",
				"What is the largest ocean on Earth?\nA: Atlantic\nB: Pacific\nC: Indian\nD: Arctic",
				"Who wrote 'Hamlet'?\nA: Charles Dickens\nB: J.K. Rowling\nC: William Shakespeare\nD: Leo Tolstoy",
				"What is the chemical symbol for water?\nA: O2\nB: H2O\nC: CO2\nD: NaCl"
		};
		char[] answers = { 'A', 'B', 'B', 'C', 'B' };

		// create and initialize the score variable
		int score = 0;

		try (Scanner scanner = new Scanner(System.in)) {
			// Itterate through the questions array
			for (int i = 0; i < questions.length; i++) {
				// Display the question and read the user's answer
				System.out.println("Question " + (i + 1) + ": " + questions[i]);
				System.out.print("Enter your answer (A, B, C, or D): ");

				// Read the user's answer and convert it to upper case, make sure it isn't blank
				String userAnswer = scanner.nextLine().toUpperCase();

				// Check if the answer is valid
				if (userAnswer.isEmpty() || userAnswer.length() > 1 || !Character.isLetter(userAnswer.charAt(0))) {
					System.out.println("Invalid answer! Please enter a single letter (A, B, C, or D).");
					// Repeat the current question by decrementing the loop counter
					i--;
					// Skip the rest of the code in the loop
					continue;
				}

				// Extract the first character as the user's answer
				char answer = userAnswer.charAt(0);

				// Check if the answer is correct and update the score
				if (answer == answers[i]) {
					System.out.println("Correct!");
					score++;
				} else {
					System.out.println("Wrong answer!");
				}
				System.out.println();
			}
		}
		// The game is over, no more questions to display

		// Calculate and display the final score
		double percentage = (double) score / questions.length * 100;
		System.out.printf("Your final score is: %.2f%%\n", percentage);
	}
}
