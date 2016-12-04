package appp.bowlingkata;

public class Game {
    private int currentFrame = 0;
    private boolean isFirstThrow = true;
    private Scorer scorer = new Scorer();

    int score() {
        return scoreForFrame(currentFrame);
    }

    void add(int pins) {
        scorer.addThrow(pins);
        adjustCurrentFrame(pins);
    }

    private void adjustCurrentFrame(int pins) {
        if (lastBallInFrame(pins)) {
            advanceFrame();
        } else {
            isFirstThrow = false;
        }
    }

    private boolean lastBallInFrame(int pins) {
        return strike(pins) || (!isFirstThrow);
    }

    private boolean strike(int pins) {
        return (isFirstThrow && pins == 10);
    }

    private void advanceFrame() {
        currentFrame++;
        if (currentFrame > 10)
            currentFrame = 10;
    }

    int scoreForFrame(int theFrame) {
        return scorer.scoreForFrame(theFrame);
    }

    private boolean adjustFrameForStrike(int pins) {
        if (pins == 10) {
            advanceFrame();
            return true;
        }
        return false;
    }

    int currentFrame() {
        return this.currentFrame;
    }
}

class Scorer {
    private int ball;
    private int[] gameThrows = new int[21];
    private int currentThrow;

    int scoreForFrame(int theFrame) {
        int score = 0;
        ball = 0;
        for (int currentFrame = 0;
             currentFrame < theFrame;
             currentFrame++) {
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
        return nextThrow() + gameThrows[ball + 2];
    }

    private int nextBallForSpare() {
        return gameThrows[ball + 2];
    }

    private boolean strike() {
        return currentThrow() == 10;
    }

    private boolean spare() {
        return currentThrow() + nextThrow() == 10;
    }

    private int nextThrow() {
        return gameThrows[ball + 1];
    }

    private int currentThrow() {
        return gameThrows[ball];
    }

    private int twoBallsInFrame() {
        return currentThrow() + nextThrow();
    }

    void addThrow(int pins) {
        gameThrows[currentThrow++] = pins;
    }
}