package com.arcesium.hrudwik;

public class Employee implements Cloneable{
    private Integer id;
    private String first_name;
    private String last_name;
    private String level;

    public Employee() {
    }

    public Employee(String first_name, String second_name, String level) {
        this.first_name = first_name;
        this.last_name = second_name;
        this.level = level;
    }

    public Employee(Integer id, String first_name, String second_name, String level) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = second_name;
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Object clone() throws
            CloneNotSupportedException
    {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", second_name='" + last_name + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
