/*
 * Class: PersistRange
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
package vn.sps.study.sdj.model;

public class PersistRange {
    private Long minRange;

    private Long maxRange;

    public PersistRange(Long minRange, Long maxRange) {
        super();
        this.minRange = minRange;
        this.maxRange = maxRange;
    }

    public Long getMinRange() {
        return minRange;
    }

    public Long getMaxRange() {
        return maxRange;
    }
}
