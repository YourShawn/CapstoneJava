package com.capstone.healthcare.common;

import java.util.Random;
import java.util.UUID;

public class NumberUtil {

    public static Double getGapNumber(){
        // 创建Random对象
        Random random = new Random();

        // 生成0.0到1.0之间的随机数
        double randomValue = random.nextDouble();

        // 范围映射到0.1到0.6
        double minValue = 0.1;
        double maxValue = 0.6;
        double scaledValue = minValue + (randomValue * (maxValue - minValue));

        return scaledValue;
    }

    public static String getUpperUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replace("-","").toUpperCase();
    }


    public static Double getRandomNumber(double minValue ,double maxValue){
        // 创建Random对象
        Random random = new Random();

        // 生成0.0到1.0之间的随机数
        double randomValue = random.nextDouble();

        double scaledValue = minValue + (randomValue * (maxValue - minValue));

        return scaledValue;
    }

    public static void main(String[] args) {
        Double randomNumber = getRandomNumber(0, 1);
        System.out.println(randomNumber);
    }

}
