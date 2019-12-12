package design.mode.factory;

/**
 * @Author: 徐森
 * @CreateDate: 2019/12/11
 * @Description:
 */
public interface ExportFactory {
    public ExportFile factory(String type);
}
