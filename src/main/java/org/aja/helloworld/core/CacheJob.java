package org.aja.helloworld.core;

import org.knowm.sundial.SundialJobScheduler;
import org.knowm.sundial.annotations.CronTrigger;
import org.knowm.sundial.exceptions.JobInterruptException;


@CronTrigger(cron = "0 * * ? * *")
public class CacheJob  extends org.knowm.sundial.Job {

    private final WordCache wordCache;

    public CacheJob(){

        wordCache = (WordCache) SundialJobScheduler.getServletContext().getAttribute("WordCache");
    }

    @Override
    public void doRun() throws JobInterruptException {
       wordCache.reloadCache();
        System.out.println("cache");
    }
}

