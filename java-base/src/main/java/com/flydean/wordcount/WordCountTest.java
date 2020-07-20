package com.flydean.wordcount;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wayne
 * @version WordCountTest
 */
@Slf4j
public class WordCountTest {

    @Test
    public void countBefore8(){
        Map<String,Integer> wordCount=  new HashMap<>();
        String[] wordArray= new String[]{"we","are","the","world","we"};
        for(String word: wordArray){
            //如果存在则加1，否则将值设置为1
            if(wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            }else{
                wordCount.put(word, 1);
            }
        }
    }

    @Test
    public void countAfter8WithCompute(){
        Map<String,Integer> wordCount=  new HashMap<>();
        String[] wordArray= new String[]{"we","are","the","world","we"};
        Arrays.asList(wordArray).forEach(word ->{
            wordCount.putIfAbsent(word,0);
            wordCount.compute(word,(w,count)->count+1);
        });
    }

    @Test
    public void countAfter8WithCompute2(){
        Map<String,Integer> wordCount=  new HashMap<>();
        String[] wordArray= new String[]{"we","are","the","world","we"};
        Arrays.asList(wordArray).forEach(word -> wordCount.compute(word,(w, count)->count == null ? 1 : count + 1));
    }

    @Test
    public void countAfter8WithMerge(){
        Map<String,Integer> wordCount=  new HashMap<>();
        String[] wordArray= new String[]{"we","are","the","world","we"};
//        Arrays.asList(wordArray).forEach(word->wordCount.merge(word, 1, (oldCount, one) -> oldCount + one));
        Arrays.asList(wordArray).forEach(word->wordCount.merge(word, 1, Integer::sum));
    }


}
