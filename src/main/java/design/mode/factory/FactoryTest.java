package design.mode.factory;

/**
 * @Author: 徐森
 * @CreateDate: 2019/12/11
 * @Description:
 */
public class FactoryTest {
    public static void main(String[] args) {
        ExportFactory exportFactory = new ExportHtmlFactory();
        ExportFile exportFile = exportFactory.factory("standard");
        exportFile.export("hello");
    }
}
