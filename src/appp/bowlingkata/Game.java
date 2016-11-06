package appp.bowlingkata;

public class Game {
    private int score;
    private int[] gameThrows = new int[21];
    private int currentThrow = 0;
    private int currentFrame = 1;
    private boolean isFirstThrow = true;
    private int ball;

    public int score() {
        return scoreForFrame(currentFrame - 1);
    }

    public void add(int pins) {
        gameThrows[currentThrow++] = pins;
        this.score += pins;

        adjustCurrentFrame(pins);
    }

    private void adjustCurrentFrame(int pins) {
        if (isFirstThrow) {
            if (pins == 10) { //strike
                currentFrame++;
            } else {
                isFirstThrow = false;
            }
        } else {
            isFirstThrow = true;
            currentFrame++;
        }
        if (currentFrame > 11) {
            currentFrame = 11;
        }
    }


    public int scoreForFrame(int theFrame) {
        int score = 0;
        ball = 0;
        for (int currentFrame = 0; currentFrame < theFrame; currentFrame++) {
            if (strike()) {
                score += 10 + nextTwoBallsForStrike();
                ball++;
            } else if (spare()) {
                score += 10 + nextBallForSpare();
                ball += 2;
            } else {
                score += twoBallsInFrame();
                ball += 2;
            }
        }
        return score;
    }

    private int nextTwoBallsForStrike() {
        return gameThrows[ball + 1] + gameThrows[ball + 2];
    }

    private boolean strike() {
        return gameThrows[ball] == 10;
    }

    private int nextBallForSpare() {
        return gameThrows[ball + 2];
    }

    private boolean spare() {
        return twoBallsInFrame() == 10;
    }

    private int twoBallsInFrame() {
        return gameThrows[ball] + gameThrows[ball + 1];
    }

    public int currentFrame() {
        return this.currentFrame;
    }
}
