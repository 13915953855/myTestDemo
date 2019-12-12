package design.mode.decorator;

/**
 * @Author: 徐森
 * @CreateDate: 2019/12/11
 * @Description:
 */
public class Change implements TheGreatestSoga {

    private TheGreatestSoga soga;

    public Change(TheGreatestSoga soga){
        this.soga = soga;
    }

    @Override
    public void move() {
        soga.move();
    }
}
