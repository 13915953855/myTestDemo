package design.mode.decorator;

/**
 * @Author: 徐森
 * @CreateDate: 2019/12/11
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        TheGreatestSoga soga = new Monkey();
        TheGreatestSoga bird = new Bird(soga);
        TheGreatestSoga fish = new Fish(bird);
        fish.move();
    }
}
