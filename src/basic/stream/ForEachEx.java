package basic.stream;

import java.util.ArrayList;
import java.util.List;

class SampleDto {
    String key;
    String value;

    public SampleDto(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }
}

public class ForEachEx {

    public static void main(String[] args) {

        // 샘플코드 1. forEach()를 사용하여 다수의 값 변경
        List<SampleDto> list = new ArrayList<>();
        for (int i = 0; i < 10; i ++) {
            list.add(new SampleDto("key_" + i, "value_" + i));
        }
        System.out.println(list); // [key_0=value_0, key_1=value_1, key_2=value_2, key_3=value_3, key_4=value_4, key_5=value_5, key_6=value_6, key_7=value_7, key_8=value_8, key_9=value_9]

        list.stream().forEach(
                x -> {
                    x.setKey("new_" + x.getKey());
                    x.setValue("new_" + x.getValue());
                }
        );
        System.out.println(list); // [new_key_0=new_value_0, new_key_1=new_value_1, new_key_2=new_value_2, new_key_3=new_value_3, new_key_4=new_value_4, new_key_5=new_value_5, new_key_6=new_value_6, new_key_7=new_value_7, new_key_8=new_value_8, new_key_9=new_value_9]

    }

}
