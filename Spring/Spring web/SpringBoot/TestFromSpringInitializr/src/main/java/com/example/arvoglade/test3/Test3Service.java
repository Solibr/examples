package com.example.arvoglade.test3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.CaseFormat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class Test3Service {

    public String test3() {
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Boolean> map;
        Map<String, Boolean> map2;

        // Без преобразования
        //map = getList().stream().collect(Collectors.toMap(x -> x.getType().toString(), x -> x.getState()));

        // Тут оба мапа получаются идентичными. То есть с этим можно работать
        map = getList().stream().collect(Collectors.toMap(x -> CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, x.getType().toString()), x -> x.getState()));
        map2 = mapper.convertValue(getObject(), HashMap.class);

        System.out.println("MyObject" + getObject());
        System.out.println("Map" + map2);


        return map2.toString() + "\n" +  map;
    }

    public List<Setting> getList() {
        List<Setting> list = new ArrayList<>();
        list.add(new Setting(MyEnum.FIRST_VALUE, true));
        list.add(new Setting(MyEnum.SECOND_VALUE, false));
        return list;
    }

    public MyClass getObject() {
        MyClass my = new MyClass();
        my.setFirstValue(true);
        my.setSecondValue(false);
        return my;
    }

}
