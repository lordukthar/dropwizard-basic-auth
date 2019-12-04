package org.aja.helloworld.core;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.aja.helloworld.resources.Translate;
import org.aja.helloworld.resources.TranslateService;

import java.util.concurrent.TimeUnit;

public class WordCache {

   private final TranslateService translateService;
    private final LoadingCache<String, Translate> cache;

    public WordCache(TranslateService translateService) {
        this.translateService = translateService;

        CacheLoader<String, Translate> loader;
        loader = new CacheLoader<String, Translate>() {
            @Override
            public Translate load(String swedishWord) {
                System.out.println("Cache is activcated");
                return translateService.getPersianWord(swedishWord);
            }
        };


        cache = CacheBuilder.newBuilder()
                .expireAfterAccess(30, TimeUnit.SECONDS)
                .build(loader);

    }

    public Translate getPersianWord(String persianWord) {
        return cache.getUnchecked(persianWord);
    }


}
