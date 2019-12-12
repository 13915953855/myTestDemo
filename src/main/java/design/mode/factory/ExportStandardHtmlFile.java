package design.mode.factory;

/**
 * @Author: 徐森
 * @CreateDate: 2019/12/11
 * @Description:
 */
public class ExportStandardHtmlFile implements ExportFile {
    @Override
    public boolean export(String data) {
        System.out.println("this is ExportStandardHtmlFile");
        return true;
    }
}
