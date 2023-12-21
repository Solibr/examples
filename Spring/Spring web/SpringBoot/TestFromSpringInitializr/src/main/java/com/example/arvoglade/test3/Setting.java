package com.example.arvoglade.test3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Setting {
    MyEnum type;
    Boolean state;
}
