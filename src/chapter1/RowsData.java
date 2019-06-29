package chapter1;

public class RowsData {
    public String get_name() {
        return _name;
    }

    public Integer get_num1() {
        return _num1;
    }

    public Integer get_num2() {
        return _num2;
    }

    private String _name;
    private Integer _num1;
    private Integer _num2;

    public RowsData(String name, Integer num1, Integer num2){
        _name = name;
        _num1 = num1;
        _num2 = num2;
    }


}
