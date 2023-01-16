package me.mikusugar.webhome.pojo;

import java.util.HashMap;

/**
 * @author mikusugar
 */
public class InputConfig {

    public static InputConfig parseArgs(String[] args) {
        final HashMap<String, String> map = new HashMap<>();
        for (String str : args) {
            final String[] split = str.split("=");
            map.put(split[0].trim(), split[1].trim());
        }
        return new InputConfig(map.get("json"), map.get("example"), map.get("out"));
    }

    public InputConfig(String json, String example, String out) {
        this.json = json;
        this.out = out;
    }

    public InputConfig() {
    }


    private String json;
    private String out;

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }



    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
    }

    @Override
    public String toString() {
        return "InputConfig{" +
                "json='" + json + '\'' +
                ", out='" + out + '\'' +
                '}';
    }
}
