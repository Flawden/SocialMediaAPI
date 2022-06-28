package ru.flawden.SocialMediaAPI.util;

import org.springframework.stereotype.Component;

@Component
public class ConverterUtil {

    private final static  char[] ENGLISH = {'a','b','v','g','d','e','e','z','z','i','i','k','l','m','n','o','p', 'r', 's', 't', 'u', 'p','f', 'h', 'c', 's', 's', ' ', 'i', ' ', 'e', 'u', 'i'};

    private final static char [] RUSSIAN = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};
    //Make static
    public String convert(String filename) {

        char[] charFileName = filename.toLowerCase().toCharArray();

        for(int i=0;i<filename.length();i++) {
            if (charFileName[i] == ' ') {
                charFileName[i] = '_';
                continue;
            }
            for(int j=0; j<ENGLISH.length;j++) {
                if(charFileName[i] == RUSSIAN[j]) {
                    charFileName[i] = ENGLISH[j];
                    break;
                }
                System.out.print(j);
            }

        }

        System.out.println("Готовая строка" + String.valueOf(charFileName));
        return String.valueOf(charFileName);
    }

}
