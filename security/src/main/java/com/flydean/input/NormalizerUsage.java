package com.flydean.input;

import org.junit.Test;

import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wayne
 * @version NormalizerUsage,  2020/7/27
 */
public class NormalizerUsage {

    @Test
    public void testNormalizer(){
        System.out.println(Normalizer.normalize("\u00C1", Normalizer.Form.NFKC));
        System.out.println(Normalizer.normalize("\u0041\u0301", Normalizer.Form.NFKC));
    }

    public void falseNormalize(){
        String s = "\uFE64" + "script" + "\uFE65";
        Pattern pattern = Pattern.compile("[<>]"); // 检查是否有尖括号
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            throw new IllegalStateException();
        }
        s = Normalizer.normalize(s, Normalizer.Form.NFKC);
    }

    public void trueNormalize(){
        String s = "\uFE64" + "script" + "\uFE65";
        s = Normalizer.normalize(s, Normalizer.Form.NFKC);
        Pattern pattern = Pattern.compile("[<>]"); // 检查是否有尖括号
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            throw new IllegalStateException();
        }
    }

}
