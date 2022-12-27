package com.viettel.statisticservice.controller;

import com.viettel.statisticservice.service.StatisticService;
import com.viettel.statisticservice.service.dto.StatisticDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaController {
    private final Logger logger = LoggerFactory.getLogger(KafkaController.class);

    @Autowired
    private StatisticService statisticService;

//    @KafkaListener(topics = {"statistic"}, groupId = "statisticGroup")
//    public void statisticListener() {
//
//    }
//
//    @KafkaListener(topics = {"statistic.DLT"}, groupId = "statisticGroup")
//    public void catchStatisticDeadLetter(StatisticDTO statisticDTO) {
//        logger.error("DTL topic received: Error in sending information: " + statisticDTO.toString());
//    }
//
//    @KafkaListener(topics = {"email"}, groupId = "emailGroup")
//    public void emailListener(StatisticDTO statisticDTO) throws Exception {
//        logger.info("Received event: " + statisticDTO.toString());
//        statisticService.addStatistic(statisticDTO);
//    }

    @KafkaListener(topics = {"email.DLT"}, groupId = "emailGroup")
    public void catchEmailDeadLetter(StatisticDTO statisticDTO) {
        logger.error("DTL topic received: Error in sending information: " + statisticDTO.toString());
    }

    @KafkaListener(topics = {"user"}, groupId = "userGroup")
    public void userListener(StatisticDTO statisticDTO) throws Exception {
        logger.info("Received event: " + statisticDTO.toString());
        statisticService.addStatistic(statisticDTO);
    }

    @KafkaListener(topics = {"user.DLT"}, groupId = "userGroup")
    public void catchUserDeadLetter(StatisticDTO statisticDTO) {
        logger.error("DTL topic received: Error in sending information: " + statisticDTO.toString());
    }

    @KafkaListener(topics = {"group"}, groupId = "groupGroup")
    public void groupListener(StatisticDTO statisticDTO) throws Exception {
        logger.info("Received event: " + statisticDTO.toString());
        statisticService.addStatistic(statisticDTO);
    }

    @KafkaListener(topics = {"group.DLT"}, groupId = "groupGroup")
    public void catchGroupDeadLetter(StatisticDTO statisticDTO) {
        logger.error("DTL topic received: Error in sending information: " + statisticDTO.toString());
    }

    @KafkaListener(topics = {"course"}, groupId = "courseGroup")
    public void courseListener(StatisticDTO statisticDTO) throws Exception {
        logger.info("Received event: " + statisticDTO.toString());
        statisticService.addStatistic(statisticDTO);
    }

    @KafkaListener(topics = {"course.DLT"}, groupId = "courseGroup")
    public void catchCourseDeadLetter(StatisticDTO statisticDTO) {
        logger.error("DTL topic received: Error in sending information: " + statisticDTO.toString());
    }

    @KafkaListener(topics = {"student"}, groupId = "studentGroup")
    public void studentListener(StatisticDTO statisticDTO) throws Exception {
        logger.info("Received event: " + statisticDTO.toString());
        statisticService.addStatistic(statisticDTO);
    }

    @KafkaListener(topics = {"student.DLT"}, groupId = "studentGroup")
    public void catchStudentDeadLetter(StatisticDTO statisticDTO) {
        logger.error("DTL topic received: Error in sending information: " + statisticDTO.toString());
    }

    @KafkaListener(topics = {"role"}, groupId = "roleGroup")
    public void roleListener(StatisticDTO statisticDTO) throws Exception {
        logger.info("Received event: " + statisticDTO.toString());
        statisticService.addStatistic(statisticDTO);
    }

    @KafkaListener(topics = {"role.DLT"}, groupId = "roleGroup")
    public void catchRoleDeadLetter(StatisticDTO statisticDTO) {
        logger.error("DTL topic received: Error in sending information: " + statisticDTO.toString());
    }

    @KafkaListener(topics = {"score"}, groupId = "scoreGroup")
    public void scoreListener(StatisticDTO statisticDTO) throws Exception {
        logger.info("Received event: " + statisticDTO.toString());
        statisticService.addStatistic(statisticDTO);
    }

    @KafkaListener(topics = {"score.DLT"}, groupId = "scoreGroup")
    public void catchScoreDeadLetter(StatisticDTO statisticDTO) {
        logger.error("DTL topic received: Error in sending information: " + statisticDTO.toString());
    }
}
