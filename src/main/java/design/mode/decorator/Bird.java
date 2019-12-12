package design.mode.decorator;

/**
 * @Author: 徐森
 * @CreateDate: 2019/12/11
 * @Description:
 */
public class Bird extends Change {
    public Bird(TheGreatestSoga soga) {
        super(soga);
    }

    @Override
    public void move() {
        super.move();
        System.out.println("Bird move");
    }
}
