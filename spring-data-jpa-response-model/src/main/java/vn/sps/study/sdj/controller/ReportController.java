/*
 * Class: ReportController
 *
 * Created on Oct 30, 2020
 *
 * (c) Copyright Swiss Post Solutions Ltd, unpublished work
 * All use, disclosure, and/or reproduction of this material is prohibited
 * unless authorized in writing.  All Rights Reserved.
 * Rights in this program belong to:
 * Swiss Post Solution.
 * Floor 4-5-8, ICT Tower, Quang Trung Software City
 */
package vn.sps.study.sdj.controller;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.sps.study.sdj.jpa.src.repository.SrcProcessEventRepository;
import vn.sps.study.sdj.model.PersistRange;

@RestController
@RequestMapping("/report")
public class ReportController {

    private static final Logger LOGGER = LoggerFactory
        .getLogger(ReportController.class);

    @Autowired
    private SrcProcessEventRepository srcProcessEventRepository;

    @PostMapping("/persist-order-by-date")
    public void reportPersistIdOf() {

        //        Date fromDate = Date
        //            .from(date.atStartOfDay().toInstant(ZoneOffset.UTC));
        //        Date toDate = Date
        //            .from(date.plusDays(1).atStartOfDay().toInstant(ZoneOffset.UTC));

        Date fromTime = Date.from(
            LocalDate.parse("2020-07-13").atStartOfDay()
                .toInstant(ZoneOffset.UTC));
        Date toTime = Date.from(
            LocalDate.parse("2020-07-14").atStartOfDay()
                .toInstant(ZoneOffset.UTC));

        LOGGER.info(
            "Finding persist order from [{}] to [{}]",
            fromTime.toString(),
            toTime.toString());

        long begin = System.currentTimeMillis();
        PersistRange persistRange = srcProcessEventRepository
            .findPersistRange1(fromTime, toTime);
        if (persistRange != null) {
            LOGGER.info(
                "Min: {} - Max: {}. Duration {} ms",
                persistRange.getMinRange() != null
                        ? persistRange.getMinRange().longValue()
                        : "NULL",
                persistRange.getMaxRange() != null
                        ? persistRange.getMaxRange().longValue()
                        : "NULL",
                (System.currentTimeMillis() - begin));
        }
    }
}
