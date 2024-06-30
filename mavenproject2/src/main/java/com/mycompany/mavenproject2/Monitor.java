package com.mycompany.mavenproject2;

import java.io.IOException;
import java.util.ArrayList;
//import com.mycompany.mavenproject2.Generator;

public class Monitor {

    private static ArrayList<Float> rpm = new ArrayList<>();
    private static ArrayList<Float> oilPressure = new ArrayList<>();
    private static ArrayList<Float> tirePressure = new ArrayList<>();
    private static ArrayList<Float> oilTemp = new ArrayList<>();
    private static ArrayList<Float> engineTemp = new ArrayList<>();
    private static ArrayList<Float> waterTemp = new ArrayList<>();
    private static ArrayList<Float> batteryVoltage = new ArrayList<>();
    private static ArrayList<Float> brakes = new ArrayList<>();
    private static ArrayList<Float> levelWater = new ArrayList<>();
    private static ArrayList<Float> levelOil = new ArrayList<>();
    private Car car;

    private static Generator gen;

    public Monitor() throws IOException {
        gen = new Generator();
        car = new Car();
        if (rpm.isEmpty()) {
            setRpm(1);
            setOilPressure(1);
            setTirePressure(1);
            setOilTemp(1);
            setEngineTemp(1);
            setWaterTemp(1);
            setBatteryVoltage(1);
            setBrakes(1);
            setLevelWater(1);
            setLevelOil(1);
        }
    }

    public static void updateRpm(int time, int flag) throws IOException {
        if (flag != 0) {
            rpm.add(gen.gerarNumeroNormal(time) * 1500);
        } else {
            rpm.add(4.0f);
        }
        rpm.remove(0);
    }

    public ArrayList<Float> getRpm() {
        return rpm;
    }

    private static void setRpm(int flag) throws IOException {
        if (flag != 0) {
            for (int i = 100; i < 500; i += 30) {
                float aux = gen.gerarNumeroNormal(i) * 1500;
                rpm.add(aux);
            }
        } else {
            rpm.add(4.0f);
        }
    }

    public ArrayList<Float> getOilPressure() {
        return oilPressure;
    }

    public static void updateOilPressure(int time, int flag) throws IOException {
        if (flag != 0) {
            oilPressure.add(gen.gerarNumeroNormal(time) * 80);
        } else {
            oilPressure.add(4.0f);
        }
        oilPressure.remove(0);
    }

    private static void setOilPressure(int flag) throws IOException {
        if (flag != 0) {
            for (int i = 100; i < 500; i += 30) {
                float aux = gen.gerarNumeroNormal(i) * 80;
                oilPressure.add(aux);
            }
        } else {
            oilPressure.add(4.0f);
        }
    }

    public ArrayList<Float> getTirePressure() {
        return tirePressure;
    }

    public static void updateTirePressure(int time, int flag) throws IOException {
        if (flag != 0) {
            tirePressure.add(gen.gerarNumeroNormal(time) * 30);
        } else {
            tirePressure.add(4.0f);
        }
        tirePressure.remove(0);
    }

    private static void setTirePressure(int flag) throws IOException {
        if (flag != 0) {
            for (int i = 100; i < 500; i += 30) {
                float aux = gen.gerarNumeroNormal(i) * 30;
                tirePressure.add(aux);
            }
        } else {
            tirePressure.add(4.0f);
        }
    }

    public ArrayList<Float> getOilTemp() {
        return oilTemp;
    }

    public static void updateOilTemp(int time, int flag) throws IOException {
        if (flag != 0) {
            oilTemp.add(gen.gerarNumeroNormal(time) * 90);
        } else {
            oilTemp.add(4.0f);
        }
        oilTemp.remove(0);
    }

    private static void setOilTemp(int flag) throws IOException {
        if (flag != 0) {
            for (int i = 100; i < 500; i += 30) {
                float aux = gen.gerarNumeroNormal(i) * 90;
                oilTemp.add(aux);
            }
        } else {
            oilTemp.add(4.0f);
        }
    }

    public ArrayList<Float> getEngineTemp() {
        return engineTemp;
    }

    public static void updateEngineTemp(int time, int flag) throws IOException {
        if (flag != 0) {
            engineTemp.add(gen.gerarNumeroNormal(time) * 90);
        } else {
            engineTemp.add(4.0f);
        }
        engineTemp.remove(0);
    }

    private static void setEngineTemp(int flag) throws IOException {
        if (flag != 0) {
            for (int i = 100; i < 500; i += 30) {
                float aux = gen.gerarNumeroNormal(i) * 90;
                engineTemp.add(aux);
            }
        } else {
            engineTemp.add(4.0f);
        }
    }

    public ArrayList<Float> getWaterTemp() {
        return waterTemp;
    }

    public static void updateWaterTemp(int time, int flag) throws IOException {
        if (flag != 0) {
            waterTemp.add(gen.gerarNumeroNormal(time) * 90);
        } else {
            waterTemp.add(4.0f);
        }
        waterTemp.remove(0);
    }

    private static void setWaterTemp(int flag) throws IOException {
        if (flag != 0) {
            for (int i = 100; i < 500; i += 30) {
                float aux = gen.gerarNumeroNormal(i) * 90;
                waterTemp.add(aux);
            }
        } else {
            waterTemp.add(4.0f);
        }
    }

    public ArrayList<Float> getBatteryVoltage() {
        return batteryVoltage;
    }

    public static void updateBatteryVoltage(int time, int flag) throws IOException {
        if (flag != 0) {
            batteryVoltage.add(gen.gerarNumeroNormal(time) * 12);
        } else {
            batteryVoltage.add(4.0f);
        }
        batteryVoltage.remove(0);
    }

    private static void setBatteryVoltage(int flag) throws IOException {
        if (flag != 0) {
            for (int i = 100; i < 500; i += 30) {
                float aux = gen.gerarNumeroNormal(i) * 12;
                batteryVoltage.add(aux);
            }
        } else {
            batteryVoltage.add(4.0f);
        }
    }

    public ArrayList<Float> getBrakes() {
        return brakes;
    }

    public static void updateBrakes(int time, int flag) throws IOException {
        if (flag != 0) {
            brakes.add(gen.gerarNumeroNormal(time) * 50);
        } else {
            brakes.add(4.0f);
        }
        brakes.remove(0);
    }

    private static void setBrakes(int flag) throws IOException {
        if (flag != 0) {
            for (int i = 100; i < 500; i += 30) {
                float aux = gen.gerarNumeroNormal(i) * 50;
                brakes.add(aux);
            }
        } else {
            brakes.add(4.0f);
        }
    }

    public ArrayList<Float> getLevelWater() {
        return levelWater;
    }

    public static void updateLevelWater(int time, int flag) throws IOException {
        if (flag != 0) {
            levelWater.add(gen.gerarNumeroNormal(time) * 50);
        } else {
            levelWater.add(4.0f);
        }
        levelWater.remove(0);
    }

    private static void setLevelWater(int flag) throws IOException {
        if (flag != 0) {
            for (int i = 100; i < 500; i += 30) {
                float aux = gen.gerarNumeroNormal(i) * 50;
                levelWater.add(aux);
            }
        } else {
            levelWater.add(4.0f);
        }
    }

    public ArrayList<Float> getLevelOil() {
        return levelOil;
    }

    public static void updateLevelOil(int time, int flag) throws IOException {
        if (flag != 0) {
            levelOil.add(gen.gerarNumeroNormal(time) * 50);
        } else {
            levelOil.add(4.0f);
        }
        levelOil.remove(0);
    }

    private static void setLevelOil(int flag) throws IOException {
        if (flag != 0) {
            for (int i = 100; i < 500; i += 30) {
                float aux = gen.gerarNumeroNormal(i) * 50;
                levelOil.add(aux);
            }
        } else {
            levelOil.add(4.0f);
        }
    }

    public String getCarMarca() {
        return this.car.getMarca();
    }

    public String getCarModelo() {
        return this.car.getModelo();
    }

    public int getCarAno() {
        return this.car.getAno();
    }
}
