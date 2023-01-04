package com.viettel.statisticservice.service.ScheduledTasks;

import com.viettel.statisticservice.StatisticServiceApplication;
import com.viettel.statisticservice.service.StatisticService;
import com.viettel.statisticservice.service.dto.StatisticDTO;
import net.javacrumbs.shedlock.core.SchedulerLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class Task {
    private final Logger logger = LoggerFactory.getLogger(Task.class);

    @Value(value = "${logging.file.name}")
    private String logPath;

    @Autowired
    private StatisticService statisticService;

    @Scheduled(cron = "0/15 * * * * *")
    @SchedulerLock(name = "LogsDeleter", lockAtLeastFor = 10000, lockAtMostFor = 12000)
    public void deleteLogs() throws Exception {
        final String clazz = "";
        // get all file names in log folder
        final String logPath = "./" + this.logPath.substring(0, this.logPath.indexOf("/"));
        File logFolder = getLogsFolder(logPath);
        List<String> fileNames = Arrays.asList(Objects.requireNonNull(logFolder.list()));

        StatisticDTO statisticDTO = new StatisticDTO();
        statisticDTO.setClazz(clazz);
        statisticDTO.setAccountId(1l);
        statisticDTO.setCreateBy("Statistic-service");
        int count = 0;
        if(!fileNames.isEmpty()){
            // sort to be decrease in file names
            String currentYear = Calendar.getInstance().get(Calendar.YEAR) + "";
            String previousYear = (Integer.parseInt(currentYear) - 1) + "";
            Comparator<String> stringComparator = (s, s1) -> s1.compareToIgnoreCase(s);
//            keep the current file log and other file which is not the legacy log file like (.git, .DSstore,...), not to delete
            fileNames = fileNames.stream().filter(name -> name.contains(currentYear) || name.contains(previousYear))
                    .sorted(stringComparator)
                    .collect(Collectors.toList());
//            keep the nearest log file, not to delete
            fileNames.remove(0);

            for(String fileName: fileNames){
                File logFile = new File(logFolder, fileName);
                if(!logFile.exists()) continue;
                logFile.delete();
                count++;
            }
        }

        // testing schedulerLock
        String message="Statistic-service: Deleted logs ... size: " + count;
        logger.info(message);
        statisticDTO.setMessage(message);
        statisticService.addStatistic(statisticDTO);
    }

    private File getLogsFolder(String path){
        File file = new File(path);
        if(!file.exists()) {
            logger.info("Creating log folder: "+ file.getParentFile() + " result: " + file.mkdir());
        }
        return  file;
    }
}
