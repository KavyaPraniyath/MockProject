package problems;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LC353SnakeGame {
    private final int width;
    private final int height;
    private final int[][] food;
    int foodCount;
    Deque<Integer> snake;
    Set<Integer> body;

    public LC353SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        foodCount = 0;
        snake = new LinkedList<>();
        body = new HashSet<>();

        // Add first pos to th eq and set
        snake.addFirst(0);
        body.add(0);
    }

    public int move(String direction) {
        if (snake.isEmpty()) {
            return -1; // Game over if snake is empty
        }
        //first get the head and calculate the new head
        //if new head in set game over
        //if new index is any of the walls game over
        //if food, then add head, increase score
        //if not food, then remove tail, then add new head;

        int head = snake.peekFirst();
        int row = head / width;
        int col = head % width;
        switch (direction) {
            case "U" : row--;
            break;
            case "D": row ++;
            break;
            case "L": col--;
            break;
            case "R": col++;
            break;
        }

        int newHead = row * width + col;
        if (body.contains(newHead) && newHead != snake.peekLast()) {
            return -1;
        }
        if (row < 0 || row >= height || col < 0 || col >= width) {
            return -1;
        }
        if (foodCount < food.length && food[foodCount][0] == row && food[foodCount][1] == col) {
            foodCount++;
            snake.addFirst(newHead);
            body.add(newHead);
        } else {
            int tail = snake.removeLast();
            body.remove(tail);
            snake.addFirst(newHead);
            body.add(newHead);
        }
        return foodCount;
    }

    public static void main(String[] args) {
        // Initialize the game
        int width = 3;
        int height = 2;
        int[][] food = {{1, 2}, {0, 1}};
        LC353SnakeGame snakeGame = new LC353SnakeGame(width, height, food);

        System.out.println(snakeGame.move("R")); // Output: 0
        System.out.println(snakeGame.move("D")); // Output: 0
        System.out.println(snakeGame.move("R")); // Output: 1
        System.out.println(snakeGame.move("U")); // Output: 1
        System.out.println(snakeGame.move("L")); // Output: 2
        System.out.println(snakeGame.move("U")); // Output: -1
    }
}
