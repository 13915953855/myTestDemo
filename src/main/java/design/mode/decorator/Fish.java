package design.mode.decorator;

/**
 * @Author: 徐森
 * @CreateDate: 2019/12/11
 * @Description:
 */
public class Fish extends Change {
    public Fish(TheGreatestSoga soga) {
        super(soga);
    }

    @Override
    public void move() {
        super.move();
        System.out.println("Fish move");
    }
}
