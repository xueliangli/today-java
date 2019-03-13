package TIJ4code;

/**
 * @program: java
 * @description:
 * @analysis:
 * @author: 李学亮    email: 18222027300@163.com
 * @create: 2019-03-07 10:19
 **/
public class E01_11 {
    static class AllTheColorOfTheRainbow{
        int anIntegerRepresentingColors=0;
        int hue=0;
        void changeTheHueOfTheColor(int newHue){
            hue=newHue;
        }
        int changeColor(int newColor){
            return anIntegerRepresentingColors=newColor;
        }
    }

    public static void main(String[] args) {
        AllTheColorOfTheRainbow allTheColorOfTheRainbow=new AllTheColorOfTheRainbow();
        System.out.println(allTheColorOfTheRainbow.anIntegerRepresentingColors);
        System.out.println(allTheColorOfTheRainbow.hue);
        System.out.println(allTheColorOfTheRainbow.changeColor(7));
        allTheColorOfTheRainbow.changeTheHueOfTheColor(77);
        System.out.println(allTheColorOfTheRainbow.hue);
    }
}
