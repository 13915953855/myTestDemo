package org.test.interfaceTest;

/**
 * @Author: 徐森
 * @CreateDate: 2019/1/16
 * @Description:
 */
@Table("tb_user")
public class Filter {
    @Column("id")
    private int Id;
    @Column("user_name")
    private String name;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
